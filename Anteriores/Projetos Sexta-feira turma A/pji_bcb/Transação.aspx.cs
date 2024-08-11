using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;
using System.Net;
using System.Data.Sql;
using System.Data.SqlClient;
using System.Data.SqlTypes;

public partial class Transação : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            btndeposito.Visible = false;
            

        }
    }
    protected void btnconcluir_Click(object sender, EventArgs e)
    {

        string digitos = valor.Text.ToString().Replace(",", ".");
        string cpfd = Request.QueryString["cpfd"];
        string cpfn = Request.QueryString["cpfn"];
        //string Squery = "update bcb_pessoa  set saldo= saldo +132.00 where cpf = '" + cpfd + "'";
        
        Verifica_saldo(cpfn,digitos); //verifica se o saldo está negativo para a transação se não estiver negativo procede negativo manda ao deposito
        adicionar(cpfd, cpfn, digitos);
        valoratual(cpfd, cpfn, digitos);
       
        
    }
    #region EVENTOS DE SALDO
    private void Verifica_saldo(string cpfn, string digitos) {
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = @"select * from BCB_PESSOA where CPF = '"+cpfn+"' and SALDO > "+digitos+"";
        Validate Verificars = new Validate();
        DataTable Dta = Verificars.Tabela_Generica(Scon, Squery);
        if (Dta.Rows.Count > 0)
        {

        }
        else {

            Response.Redirect("~/Deposito.aspx?id=" + cpfn);
        }


    
    }
    private void adicionar(string cpfd, string cpfn, string digitos)
    {
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "UPDATE BCB_PESSOA SET SALDO =  SALDO +" + digitos + " WHERE CPF = '" + cpfd + "'";
        try
        {
            using (SqlConnection sqlcnn = new SqlConnection(Scon))
            {
                //ABRE UMA CONEXÃO
                sqlcnn.Open();
                //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE

                using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
                {
                    cmd.ExecuteScalar().ToString();
                  
                  

                    Dispose();
              

                }

            }
        }
        catch (Exception e)
        {
            
        }
         Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
         Squery = "update bcb_pessoa  set saldo= saldo - " + digitos + " where cpf = '" + cpfn + "'";
        try
        {
            using (SqlConnection sqlcnn = new SqlConnection(Scon))
            {
                //ABRE UMA CONEXÃO
                sqlcnn.Open();
                //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE

                using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
                {
                    cmd.ExecuteScalar().ToString();

                    resultado.Text = "Transação Concluida";

                    Dispose();


                }

            }
        }
        catch (Exception e)
        {


        }
    }
    private void valoratual(string cpfd, string cpfn, string digitos)
    {
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "SELECT SALDO FROM BCB_PESSOA WHERE CPF = '" + cpfn + "'";
        using (SqlConnection sqlcnn = new SqlConnection(Scon))
        {
            //ABRE UMA CONEXÃO
            sqlcnn.Open();
            //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE
            using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
            {
                string pessoa = cmd.ExecuteScalar().ToString();


                vsub.Text = "VALOR TRANSFERIDO R$ " + digitos;
                registrar(digitos, cpfn, cpfd);




            }


        }
    }  
    private void registrar(string digitos, string cpfn,string cpfd)
    {
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "SELECT NOME FROM BCB_INFO WHERE CPF= '" + cpfd + "'";
        using (SqlConnection sqlcnn = new SqlConnection(Scon))
        {
            //ABRE UMA CONEXÃO
            sqlcnn.Open();
            //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE
            using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
            {
                string pessoa = cmd.ExecuteScalar().ToString();
                string nome = pessoa;
                Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
                Squery = "INSERT INTO BCB_HIST (CPF,VALOR,NOME,TRANSAÇÃO) VALUES ('" + cpfn + "','" + digitos + "','" + nome + "','TRANSFERENCIA')";

                Validate Cadastrar = new Validate();
                DataTable dta = Cadastrar.Tabela_Generica(Scon, Squery);
                if (dta.Rows.Count == 0)
                {
                    Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
                    Squery = "SELECT * FROM BCB_HIST where NOME = '" + pessoa + "'";

                    Validate consultarregistro = new Validate();
                    DataTable dtal = consultarregistro.Tabela_Generica(Scon, Squery);
                    if (dtal.Rows.Count != 0)
                    {

                        resultado.Text = "CONCLUIDA";
                       
                        btnconcluir.Visible = false;
                        btnvoltar.Visible=true;
                    }
                    else
                    {

                        resultado.Text = "exceção";
                    }
                }


            }

        }
    }
    #endregion
    protected void btndeposito_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Deposito.aspx");
    }
    protected void btntras_Click(object sender, EventArgs e)
    {

    }
    protected void btnvoltar_Click(object sender, EventArgs e)
    {
        string cpfn = Request.QueryString["cpfn"];
         string  Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
              string  Squery = "SELECT SENHA FROM BCB_INFO WHERE CPF = '" + cpfn+"'";
          using (SqlConnection sqlcnn = new SqlConnection(Scon))
            {
                //ABRE UMA CONEXÃO
                sqlcnn.Open();
                //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE
           
                using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
                {
                    string cpft = cmd.ExecuteScalar().ToString();
                   
                    string id = cpft;
                    Response.Redirect("~/Perfil.aspx?id="+id);
                    Dispose();


                }
    }
    }
}