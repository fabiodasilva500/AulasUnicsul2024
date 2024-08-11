using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;
using System.Net;
using System.Data.Sql;
using System.Data.SqlClient;
using System.Data.SqlTypes;


public partial class Perfil : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        //NO PRIMEIRO CARREGAMENTO DA PAGINA CAPTURA O ID DA URL INDENTIFICANDO O USUARIO QUE ESTA NA PAGINA INICIAL DE PERFIL
        if (!IsPostBack)
        {
            string id = Request.QueryString["id"];
            indentificação(id);
        }
    }
    #region METODOS
    private void indentificação(string id)
    {
        //pesquisa o cpf pelo id (senha criptografada e recupera nome e saldo atual do usuario para exibir na tela)
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "SELECT NOME FROM BCB_INFO WHERE SENHA= '" + id + "'";
        using (SqlConnection sqlcnn = new SqlConnection(Scon))
        {
            //ABRE UMA CONEXÃO
            sqlcnn.Open();
            //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE
            using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
            {
                string pessoa = cmd.ExecuteScalar().ToString();
                nome.Text = pessoa;
                Dispose();


            }
            Squery = "SELECT CPF FROM BCB_INFO WHERE SENHA= '" + id + "'";
            using (SqlCommand cmds = new SqlCommand(Squery, sqlcnn))
            {
                string cpf = cmds.ExecuteScalar().ToString();
                saldoatual(cpf);

            }
        }
    }
    private void saldoatual(string cpf)
    {
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "SELECT SALDO FROM BCB_PESSOA WHERE CPF= '" + cpf + "'";
        using (SqlConnection sqlcnn = new SqlConnection(Scon))
        {
            //ABRE UMA CONEXÃO
            sqlcnn.Open();
            //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE
            using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
            {
                string SALDO = cmd.ExecuteScalar().ToString();
                lblsaldo.Text = "R$" + SALDO;
                Dispose();


            }

        }
    }
    #endregion
    #region BOTÃO DE AÇÃO
    protected void btpaginatransferir_Click(object sender, EventArgs e)
    {
        string id = Request.QueryString["id"];
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "SELECT CPF FROM BCB_INFO WHERE SENHA= '" + id + "'";
        using (SqlConnection sqlcnn = new SqlConnection(Scon))
        {
            //ABRE UMA CONEXÃO
            sqlcnn.Open();
            //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE
            using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
            {
                string cpft = cmd.ExecuteScalar().ToString();
                Response.Redirect("~/Transferencias.aspx?id=" + cpft);
                Dispose();


            }

        }
        
       
    }
    protected void btndeposito_Click(object sender, EventArgs e)
    {
        string id = Request.QueryString["id"];
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "SELECT CPF FROM BCB_INFO WHERE SENHA= '" + id + "'";
        using (SqlConnection sqlcnn = new SqlConnection(Scon))
        {
            //ABRE UMA CONEXÃO
            sqlcnn.Open();
            //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE
            using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
            {
                string pessoa = cmd.ExecuteScalar().ToString();
                Response.Redirect("~/Deposito.aspx?id=" + pessoa);
                Dispose();


            }


        }
    }
    protected void btnsenha_Click(object sender, EventArgs e)
    {
        string id = Request.QueryString["id"];
        Response.Redirect("~/Senha.aspx?id="+ id);
    }
    protected void btnhistorico_Click(object sender, EventArgs e)
    {
        string id = Request.QueryString["id"];
        string Scon = "Data Source=DESKTOP-01QK6E3;Initial Catalog=PJI_BCB;Integrated Security=True";
        string Squery = "SELECT CPF FROM BCB_INFO WHERE SENHA= '" + id + "'";
        using (SqlConnection sqlcnn = new SqlConnection(Scon))
        {
            //ABRE UMA CONEXÃO
            sqlcnn.Open();
            //CRIA UM NOVO CMD PASSANDO A QUERY E A CONEXÃO PRA ELE
            using (SqlCommand cmd = new SqlCommand(Squery, sqlcnn))
            {
                string pessoa = cmd.ExecuteScalar().ToString();
                Response.Redirect("~/Historico.aspx?id=" + pessoa);
                Dispose();


            }

        }
    }
    protected void btnsair_Click(object sender, EventArgs e)
    {
        Response.Redirect("~/Login.aspx");
    }
    #endregion
}