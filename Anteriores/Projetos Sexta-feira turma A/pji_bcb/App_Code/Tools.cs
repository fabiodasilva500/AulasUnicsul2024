using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;
using System.Net;
using System.Data.Sql;
using System.Data.SqlClient;
using System.Data.SqlTypes;
public class Validate
{
    public Validate()
    {
        //
        // 
        //
    }
    /// <summary>
    /// Envia uma query pro banco de dados
    /// </summary>
    /// <param name="Scon">string de conexão ao banco</param>
    /// <param name="Squery">query do usuário</param>
    /// <returns>Tabela com os dados</returns>
    public DataTable Tabela_Generica(string Scon, string Squery)
    {
        #region CONEXÃO E QUERY
        DataTable dt = new DataTable();
        SqlDataAdapter dta = new SqlDataAdapter();


        using (SqlConnection cnn = new SqlConnection(Scon))
        {
            cnn.Open();

            using (SqlCommand cmd = new SqlCommand(Squery, cnn))
            {
                dta.SelectCommand = cmd;
                dta.Fill(dt);
                cnn.Close();
                if (dt.Rows != null)
                {
                    return dt;
                }
                else
                {
                    return null;
                }
            }
        }
        #endregion
    }

    /// <summary>
    /// Envia comando ao banco de dados
    /// </summary>
    /// <param name="Scon">string de conexão</param>
    /// <param name="Squery">query de update ou insert no banco de dados</param>
    /// <returns>Resultado da query</returns>
    #region UPDATE
    public string Update(string Scon, string Squery)
    {
        
        using (SqlConnection cnn = new SqlConnection(Scon))
        {
            cnn.Open();
            using (SqlCommand cmd = new SqlCommand(Squery, cnn))
            {

              cmd.ExecuteScalar().ToString(); ;
                return cmd.ExecuteScalar().ToString();
            }
        }
    }

    #endregion
    /// <param name="cpf">Cpf recebido do usuário</param>
    /// <param name="cnpj">Cnpj recebido do usuário</param>
    /// <param name="Scon">String de conexão ao banco de dados</param>
    /// <returns>Verdadeiro ou falso</returns>
    public bool Verifica_Cpf(string cpf)
    {

        #region VERIFICA VALOR VAZIO
        if (cpf == "")
        {
            return false;
        }
        cpf = cpf.Trim();
        cpf = cpf.Replace("-", "").Replace(".", "");
        #endregion
        #region VERIFICA QUANTIDADE DE DIGITOS
        if (cpf.Length != 11) { return false; }
        #endregion
        #region VARIAVEIS PARA CALCULOS
        ///VARIAVEIS PARA SOMA E VALIDAÇÃO DOS NUMEROS
        int soma = 0;
        string digito = "";
        string cpfTemp;
        int resto;

        int[] p1 = new int[9] { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
        int[] p2 = new int[10] { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
        int[] n = new int[11];
        /////////////////////////////////////////////
        #endregion
        #region ELIMINA CASOS DE DIGITOS IGUAIS
        switch (cpf)
        {
            case "11111111111":
                return false;
            case "00000000000":
                return false;
            case "22222222222":
                return false;
            case "33333333333":
                return false;
            case "44444444444":
                return false;
            case "55555555555":
                return false;
            case "66666666666":
                return false;
            case "77777777777":
                return false;
            case "88888888888":
                return false;
            case "99999999999":
                return false;
        }
        #endregion
        #region CAPTURA CADA DIGITO DOS 11 DIGITOS DO CPF
        try
        {
            //converte para int e captura o numero de uma determinada posição da variavel cpf
            n[0] = Convert.ToInt32(cpf.Substring(0, 1));
            n[1] = Convert.ToInt32(cpf.Substring(1, 1));
            n[2] = Convert.ToInt32(cpf.Substring(2, 1));
            n[3] = Convert.ToInt32(cpf.Substring(3, 1));
            n[4] = Convert.ToInt32(cpf.Substring(4, 1));
            n[5] = Convert.ToInt32(cpf.Substring(5, 1));
            n[6] = Convert.ToInt32(cpf.Substring(6, 1));
            n[7] = Convert.ToInt32(cpf.Substring(7, 1));
            n[8] = Convert.ToInt32(cpf.Substring(8, 1));
            n[9] = Convert.ToInt32(cpf.Substring(9, 1));
            n[10] = Convert.ToInt32(cpf.Substring(10, 1));
            ///////////////////////////////////////////////////////////////////////////////////
        }
        catch
        {
            return false;
        }
        #endregion
        #region VALIDAÇÃO DO CPF
        cpfTemp = cpf.Substring(0, 9);
        soma = 0;

        for (int i = 0; i < 9; i++)
        { soma += int.Parse(cpfTemp[i].ToString()) * p1[i]; }
        resto = soma % 11;

        if (resto < 2)
        {
            resto = 0;
        }
        else
        {
            resto = 11 - resto;
        }
        digito = resto.ToString();
        cpfTemp = cpfTemp + digito;
        soma = 0;
        for (int i = 0; i < 10; i++)
        {
            soma += int.Parse(cpfTemp[i].ToString()) * p2[i];
        }
        resto = soma % 11;
        if (resto < 2)
        {
            resto = 0;
        }
        else
        {
            resto = 11 - resto;
        }
        digito = digito + resto.ToString();
        return cpf.EndsWith(digito);
        #endregion
    }
}