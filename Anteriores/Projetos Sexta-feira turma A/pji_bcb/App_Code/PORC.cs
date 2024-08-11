using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// CRIPTOGRAFIA MD5
/// ATENÇÃO: NÃO REVERSIVEL (BASE64 É REVERSIVEL)
/// FONTE: MICROSOFT,STACKOVERFLOW
/// </summary>
public class PORC
{
	public PORC()
	{
		
	}
    public string criptografar(string senha){
        try
        {
            System.Security.Cryptography.MD5 md5 = System.Security.Cryptography.MD5.Create();
            byte[] inputBytes = System.Text.Encoding.ASCII.GetBytes(senha);
            byte[] hash = md5.ComputeHash(inputBytes);
            System.Text.StringBuilder sb = new System.Text.StringBuilder();
            for (int i = 0; i < hash.Length; i++)
            {
                sb.Append(hash[i].ToString("X2"));
            }
            return sb.ToString(); // Retorna senha criptografada 
        }
        catch (Exception)
        {
            return null; // Caso encontre erro retorna nulo
        }
    }
}