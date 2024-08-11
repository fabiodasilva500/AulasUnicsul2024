<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Transferencias.aspx.cs" Inherits="Transferencias" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    <!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>BCB/ Saldo</title>
</head>
<body>

    <header>
        <h1>BCB</h1>
        <p>Sua história nossa independência</p>
    </header>

    <div class="camadaColor">
        <nav>
            <div id="separar" class="navegacao">
                
              
          
            </div>
        </nav>
        <div class="janela3">
            <div class="tituloPagina"><p>PIX</p></div>
            <p>PESQUISE POR UMA CHAVE</p>
            <p>
                 <table>
            <tr>
               
                <td>
                    <asp:TextBox runat="server" ID="txtchave" /></td>
                <td>
                    <asp:Button Text="CONSULTAR" CssClass="" ID="btnconsulta" OnClick="btnconsulta_Click"  runat="server" /></td>
                
                
            </tr>
            <tr>
                <td>
                    <asp:Label Text="" ID="status" runat="server" /></td>
                <td><asp:Label Text="" ID="email" runat="server" /></td>
                <td><asp:Button Visible="false" ID="btnfazerpix" runat="server" CssClass="botao" OnClick="btnfazerpix_Click" text="Transferir" /></td>
               
            </tr>
                   
        </table>
            </p>
        </div>
    </div>

    <footer>
        <p>Banco Colonial do Brasil</p>
        <p>
            Contato:
        </p>
        <p>
            Fone (11) 9****-****
        </p>
        <p>
            E-mail bcb@gmail.com
        </p>
    </footer>
</body>
</html>
    </div>
    </form>
</body>
</html>
