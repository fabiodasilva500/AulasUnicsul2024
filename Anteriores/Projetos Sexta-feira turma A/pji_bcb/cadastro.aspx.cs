using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;
using System.Net;
using System.Data.Sql;
using System.Data.SqlClient;
using System.Data.SqlTypes;

public partial class cadastro : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)//serve para o primeiro carregamento da pagina
        {
           
        }
    }
    protected void btncadastro_Click(object sender, EventArgs e)
    {
        //captura todas as regiões sem espaços vazios e faz a validação de todos os espaços
        string nome = txtnome.Text.Trim();
        string cpf = txtcpf.Text.Trim();
        string senha = txtsenha.Text.Trim();
        string senhac = txtsenhac.Text.Trim();
        string email = txtemail.Text.Trim();

        //condições de dados validos
        
        if(nome == ""){
            resposta.Text = "PREENCHA O NOME";
        
        }
        else{
        if (senha.Length < 6)
        {
            resposta.Text = "A SENHA DEVE CONTER 6 DIGITOS";
        }
        else
        {
            if(senha == senhac){
            if (cpf.Length < 11)
            {

                resposta.Text = "O CPF DEVE CONTER 11 DIGITOS";
            }
            else {
               
                if (email.Contains('@'))
                {
                    Validate Vcpf = new Validate();
                    bool cpfc = Vcpf.Verifica_Cpf(cpf);
                    if (cpfc == true)
                    {
                        PORC cripto = new PORC();
                        string Senhac = cripto.criptografar(senha);
                        verificarsenha(nome,cpf,email,Senhac);
                        
                    }
                    else
                    {
                        resposta.Text = "O CPF DIGITADO NÃO É VALIDO";
                    }

                }
                else {


                    resposta.Text = "INSIRA UM EMAIL VÁLIDO";
                }
            }
                }
            else{
            resposta.Text="SENHAS PRECISAM SER IGUAIS"; 
            }
        }
            }
    }
    private void verificarsenha(string nome, string cpf, string email, string Senhac)
    {
        //metodo para verificar se a senha que foi inserida pelo usuario já existe (impossibilitando bugs no sistema posteriormente)
        Validate consultar_senha = new Validate();
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "SELECT SENHA FROM BCB_INFO WHERE SENHA= '" + Senhac + "'";
        DataTable dta = consultar_senha.Tabela_Generica(Scon, Squery);
        if (dta.Rows.Count == 0)
        {
            //caso a senha digita não exista chama o metodo de cadastro para que seja realizado o insert no banco
            cadastrar(nome, cpf, email, Senhac);
        }
        else
        {
            //se exister pede ao usuario uma nova senha
            //senhas duplicadas neste sistema causam divergencia de transferencia fazendo com que seja transferido entre senhas e não cpf
            //podendo ser corrigido porem com alteração no sistema inteiro
            resposta.Text = "Escolha uma Senha Mais Segura";
        }


    }
    private void cadastrar (string nome, string cpf,string email, string Senhac){
        // query de cadastro no banco de dados
        string Squery = "insert into BCB_INFO (NOME,CPF,EMAIL,SENHA) VALUES ('"+nome+"','"+cpf+"','"+email+"','"+Senhac+"')";
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        //instancia a classe para fazer a query e retornar uma tabela
        Validate Cadastrar = new Validate();
        DataTable dta = Cadastrar.Tabela_Generica(Scon, Squery);
        if(dta.Rows.Count == 0){
            //se a tabela retornar vazia o insert deu certo ele confirma falzendo um select de cpf e senha
            Squery = "SELECT CPF,SENHA FROM BCB_INFO WHERE CPF= '" + cpf + @"'AND SENHA= '" + Senhac + "'";
        DataTable dtal = Cadastrar.Tabela_Generica(Scon, Squery);
        if (dtal.Rows.Count != 0)
        {
            //apos a confirmação adiciona automaticamente 10 reais ao usuario
            Squery = "INSERT INTO BCB_PESSOA (CPF,SALDO) VALUES ('"+cpf+"','10.00')";
            DataTable dtala = Cadastrar.Tabela_Generica(Scon, Squery);
            resposta.Text = "Cadastro Realizado Com Sucesso";
            btnvoltar.Visible=true;
            btncadastro.Visible = false;
        }
        else
        {
            //caso contrario a falha significa que o cpf não foi registrado em outra tabela ou já existe na tabela de informações
            resposta.Text = "Falha No Cadastro (Revise as Informações)";
        }
        }
        else{
            //exceção final de cadastro somente em falta de dados
        
        resposta.Text="Exceção contate o administrador do sistema";
        }

    
    
    }
  
    protected void btnvoltar_Click(object sender, EventArgs e)
    {
        
        Response.Redirect("~/Login.aspx");
    }
}