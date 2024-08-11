using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.Sql;
using System.Data.SqlClient;
using System.Data.SqlTypes;
using System.Data;
using System.Net;
using System.Text;


public partial class Historico : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        string cpf = Request.QueryString["id"];
        carregatabela(cpf);
    }
    protected void btnvoltar_Click(object sender, EventArgs e)
    {
           string cpf = Request.QueryString["id"];
         string  Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
              string  Squery = "SELECT SENHA FROM BCB_INFO WHERE CPF = '" + cpf+"'";
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
    private void carregatabela(string cpf)
    {
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = @" Select * 
        from (select top 15 * from bcb_hist   Order by VALOR Desc) p 
        where cpf = '"+cpf+"'Order By VALOR Asc";
        Validate dll = new Validate();
        DataTable dta = dll.Tabela_Generica(Scon, Squery);
        StringBuilder sql = new StringBuilder();
        sql.AppendLine("<table id='tabela' class='table' style= whidth:100%");
        sql.AppendLine("<thead class='cabeca'>");
        sql.AppendLine("<tr>");
        sql.AppendLine("<th>CPF</th>");
        sql.AppendLine("<th>VALOR</th>");
        sql.AppendLine("<th>PARA</th>");
        sql.AppendLine("<th>TIPO DE TRANSAÇÃO</th>");
        sql.AppendLine("</thead>");
        sql.AppendLine("</tr>");

        ///inicio do corpo///
        sql.AppendLine("<tbody>");
        foreach (DataRow dtr in dta.Rows)
        {
            sql.AppendLine("<tr class='linhatabela'>");
            sql.AppendLine("<div class='divtbl'><td>" + dtr["CPF"] + "</td></div>");
            sql.AppendLine("<div class='divtbl'><td>" + dtr["VALOR"] + "</td></div>");
            sql.AppendLine("<div class='divtbl'><td>" + dtr["NOME"] + "</td></div>");
            sql.AppendLine("<div class='divtbl'><td>" + dtr["TRANSAÇÃO"] + "</td></div>");
            sql.AppendLine("</tr>");


        }
        sql.AppendLine("</tbody>");
        sql.AppendLine("</table>");

        if (dta != null)
        {
            string rsql = sql.ToString();
            pnl.Controls.Clear();
            pnl.Controls.Add(new LiteralControl(rsql));
            pnl.Visible = true;

        }
    }
}