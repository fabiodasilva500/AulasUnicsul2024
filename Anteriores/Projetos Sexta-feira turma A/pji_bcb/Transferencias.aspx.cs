using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;
using System.Net;
using System.Data.Sql;
using System.Data.SqlClient;
using System.Data.SqlTypes;

public partial class Transferencias : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        if(!IsPostBack){
        
        }
    }
    protected void btnconsulta_Click(object sender, EventArgs e)
    {
        string chave = txtchave.Text.Trim();
        if (chave != "")
        {
            consultarchave(chave);


        }
        else {
            status.Text = "Campo Vazio";
        }
    }
    private void consultarchave(string chave) {
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "select cpf from bcb_info where cpf = '"+chave+"'";
        Validate vchave = new Validate();
        DataTable dta = vchave.Tabela_Generica(Scon, Squery);
        if (dta.Rows.Count != 0)
        {



            using (SqlConnection sqlcnn = new SqlConnection(Scon))
            {
                //ABRE UMA CONEXÃO
                sqlcnn.Open();
                //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE
                Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
                Squery = "SELECT NOME FROM BCB_INFO WHERE CPF = '" + chave + "'";
                using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
                {
                    string cpft = cmd.ExecuteScalar().ToString();
                   
                    status.Text = cpft;
                    Dispose();


                }
                Squery = "SELECT EMAIL FROM BCB_INFO WHERE CPF = '" + chave + "'";
                using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
                {

                    string cpft = cmd.ExecuteScalar().ToString();
                    email.Text = cpft;
                    btnfazerpix.Visible = true;
                    Dispose();


                }

            }
        }
        else {
            btnfazerpix.Visible = false;
            email.Text = "";
            status.Text = "CHAVE NÃO EXISTENTE";
        }
    
    }
    protected void btnfazerpix_Click(object sender, EventArgs e)
    {
        string cpfn = Request.QueryString["id"];
        string cpft = txtchave.Text.ToString();
        
        Response.Redirect("~/Transação.aspx?cpfd=" + cpft + "&cpfn=" + cpfn);
       
    }
    
  
 
}