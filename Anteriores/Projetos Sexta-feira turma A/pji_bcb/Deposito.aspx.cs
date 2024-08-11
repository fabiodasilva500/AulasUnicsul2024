using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;
using System.Net;
using System.Data.Sql;
using System.Data.SqlClient;
using System.Data.SqlTypes;


public partial class Deposito : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if(!IsPostBack){
        
        }
    }
    protected void btndeposito_Click(object sender, EventArgs e)
    {
        string deposito = txtquantia.Text.Trim().ToString().Replace(",",".") ;
        string cpf = Request.QueryString["id"];
            valoratual(cpf,deposito);
        depositar(deposito, cpf);

    }
    private void depositar(string deposito, string cpf)
    {
        // 
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "UPDATE BCB_PESSOA SET SALDO = SALDO +" + deposito + "  WHERE CPF = '" + cpf + "'";
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
                    if (cmd.ToString().Contains("-"))
                    {
                        resultado.Text = "SALDO NEGATIVO";
                    }
                    else
                    {
                        
                        valoratual(cpf,deposito);

                    }



                    Dispose();


                }

            }
        }
        catch(Exception e){
        
        }
    }
    private void registrar(string deposito, string cpf)
    {
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "SELECT NOME FROM BCB_INFO WHERE CPF= '" + cpf + "'";
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
                Squery = "INSERT INTO BCB_HIST (CPF,VALOR,NOME,TRANSAÇÃO) VALUES ('"+cpf+"','"+deposito+"','"+nome+"','DEPOSITO')";
                
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

                        resultado.Text = "DEPOSITO REALIZADO";

                    }
                    else {

                        resultado.Text = "exceção";
                    }
                }


            }

        }
    }
     private void valoratual(string cpf,string deposito) {

        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "SELECT SALDO FROM BCB_PESSOA WHERE CPF = '" + cpf + "'";
        using (SqlConnection sqlcnn = new SqlConnection(Scon))
        {
            //ABRE UMA CONEXÃO
            sqlcnn.Open();
            //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE
            using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
            {
                string pessoa = cmd.ExecuteScalar().ToString();

               
                btnvoltar.Visible = true;
                btndeposito.Visible = false;
                registrar(deposito, cpf);



            }


        }
    }
    
     protected void btnvoltar_Click(object sender, EventArgs e)
     {
         string cpf = Request.QueryString["id"];
         string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
         string Squery = "SELECT SENHA FROM BCB_INFO WHERE CPF = '" + cpf + "'";
        
             using (SqlConnection sqlcnn = new SqlConnection(Scon))
             {
                 //ABRE UMA CONEXÃO
                 sqlcnn.Open();
                 //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE

                 using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
                 {
                     string id = cmd.ExecuteScalar().ToString();
                     Response.Redirect("~/Perfil.aspx?id="+ id);


                     Dispose();


                 }

             }
         
        
     }
}
      
   