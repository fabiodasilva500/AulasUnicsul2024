using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;
using System.Net;
using System.Data.Sql;
using System.Data.SqlClient;
using System.Data.SqlTypes;

public partial class Login : System.Web.UI.Page
{
  
    protected void Page_Load(object sender, EventArgs e)
    {
        if(!IsPostBack){
          //PRIMEIRA VEZ SENDO CARREGADA OU SENDO CHAMADO UM CALLBACK
        }
    }
    #region EVENTO DE LOGIN
    protected void btnentrar_Click(object sender, EventArgs e)
    {
        string cpf = txtcpf.Text.Trim();//CAPTURA O CPF E A SENHA SEM ESPAÇOS VAZIOS
        string senha = txtsenha.Text.Trim();
        if (senha.Length < 6)
        {
            //SENHA MENOR QUE 6 DIGITOS
            resposta.Text = "A SENHA DEVE CONTER 6 DIGITOS";
        }
        else {
            if (cpf.Length < 11)
            {
                //CPF MENOR QUE 11 DIGITOS
                resposta.Text = "O CPF DEVE CONTER 11 DIGITOS";
            }

            else
            {
                //INSTANCIA UMA CLASSE EXISTENTE
                Validate Vcpf = new Validate();
                //VARIAVEL DE FALSE OR TRUE PARA VALIDAR CPF
                bool cpfc = Vcpf.Verifica_Cpf(cpf);
                if (cpfc == true)
                {
                    //CPF VALIDO INSTANCIA A CLASSE DE CRIPTOGRAFIA
                    PORC cripto = new PORC();
                    //ENVIA A SENHA PARA A CRIPTOGRAFIA
                    string Senhac = cripto.criptografar(senha);
                    //CHAMA O METODO DE LOGIN COM O CPF E A SENHA AGORA CRIPTOGRAFADA
                    verificalogin(cpf, Senhac);
                }
                else {
                    resposta.Text = "O CPF DIGITADO NÃO É VALIDO";
                }
              
            }
        }
       
    }
    #endregion
    
    #region VERIFICAR LOGIN NO BANCO DE DADOS
    private void verificalogin(string cpf, string senhac)
    {
      //INSTANCIA A CLASSE DE VALIDAÇÃO
        Validate validar = new Validate();
        //STRING DE CONEXÃO E QUERY DOS SISTEMA
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "SELECT CPF,SENHA FROM BCB_INFO WHERE CPF= '" + cpf + @"'AND SENHA= '" + senhac + "'";
        //CRIA UMA NOVA TABELA COM NOME DTA AONDE DENTRO DA CLASSE DE VALIDAÇÃO ELA SERA USADA PARA INSERIR O RESULTADO DA QUERY ACIMA
        DataTable dta = validar.Tabela_Generica(Scon, Squery);
        if (dta.Rows.Count != 0)
        {
            //APOS A TABELA CONTER ALGUMA LINHA COM AS INFORMAÇÕES DA QUERY REDIRECIONA PARA O PERFIL INICIAL INDICANDO A SENHA CRIPTOGRADA COMO ID DE INDENTIFICAÇÃO
            Response.Redirect("~/Perfil.aspx?id=" + senhac + "");
            

        }
        else
        {
        //CASO CONTRARIO
            resposta.Text = "USUÁRIO NÃO CADASTRADO OU SENHA INCORRETA";
        }

    }
    #endregion
    //#region VERIFICAR NIVEL DE USUÁRIO
    //private void verificanivel(string cpf) {
    //    Validate nivel = new Validate();
    //    string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=SSO_LOGIN;Integrated Security=True";
    //    string Squery = @"select NIVEL from SSO_PERFIL where CPF = '"+cpf+"' and NIVEL = 'ADM'";
    //    DataTable dta = nivel.Tabela_Generica(Scon, Squery);
    //    if (dta.Rows.Count != 0)
    //    {
    //        Response.Redirect("~/Admin.aspx");
    //    }
    //    else { 
    //      //USUARIO COMUM
    //        Response.Redirect("~/Perfil.aspx");
    //    }


    //}
    //#endregion
    protected void btncadastro_Click(object sender, EventArgs e)
    {
        //REDIRECIONA PARA A PAGINA DE CADASTRO 
        Response.Redirect("~/cadastro.aspx");
    }
}