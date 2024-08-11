using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;
using System.Net;
using System.Data.Sql;
using System.Data.SqlClient;
using System.Data.SqlTypes;
public partial class Senha : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    protected void btnalterar_Click(object sender, EventArgs e)
    {
        string cpfd = Request.QueryString["id"];
        alterar(cpfd);
    }
    private void alterar(string cpfd)
    {
        string snova = txtsenha.Text;

        PORC cripto = new PORC();
        string Senhac = cripto.criptografar(snova);
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "UPDATE BCB_INFO SET SENHA = '" + Senhac + "'  WHERE senha = '" + cpfd + "'";
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

                  






                }

            }




        }
        catch (Exception e)
        {
            verificarstatus(Senhac);
        }
    }
    private void verificarstatus(string Senhac) { 
         string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "SELECT SENHA FROM BCB_INFO WHERE SENHA = '" + Senhac + "'";
        Validate verificar = new Validate();
        DataTable dta = verificar.Tabela_Generica(Scon,Squery);
        if (dta.Rows.Count != 0)
        {
            btnalterar.Visible = false;
            btnvoiltar.Visible = true;
            resultado.Text = "SENHA ALTERADA";
        }
        else {
            resultado.Text = "ALTERAÇÃO PERMITIDA APENAS UMA VEZ";
        
        }
    }
    protected void btnvoiltar_Click(object sender, EventArgs e)
    {
        string snova = txtsenha.Text;

        PORC cripto = new PORC();
        string Senhac = cripto.criptografar(snova);

        Response.Redirect("~/Perfil.aspx?id=" + Senhac);
    }
}
