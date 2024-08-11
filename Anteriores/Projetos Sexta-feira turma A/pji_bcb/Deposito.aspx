<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Deposito.aspx.cs" Inherits="Deposito" %>

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
    <title>BCB/ Perfil</title>
</head>
<body>

    <header>
        <h1>BCB</h1>
        <p>Sua história nossa independência</p>
    </header>

    <div class="camadaColor">
        <nav>
            <div id="separar" class="navegacao">
                
                <a href="Extrato.html"><div><p>Extrato</p></div></a>
         
                
            </div>
        </nav>
        <div class="janela3">
            <div class="tituloPagina"><p>DEPOSITAR</p></div>
            <p>
                <table class="areaLogin">
                    <tr>
                        <tr>
                             <p>
                <asp:Label ID="resultado" runat="server" Text=""></asp:Label>
                <asp:Label ID="vtrans" runat="server" Text=""></asp:Label>
                  <asp:Label ID="vsub" runat="server" Text=""></asp:Label>
            </p>
                        </tr>
                        <td>
                            VALOR
                        </td>
                        <td>
                            <asp:TextBox ID="txtquantia" runat="server" TextMode="Number"/>
                        </td>
                        <td>
                            <asp:Button Text="Depositar" runat="server" Class="botao" ID="btndeposito" OnClick="btndeposito_Click" />
                            <asp:Button CssClass="botao" ID="btnvoltar" Text="Voltar" runat="server" Visible="false" OnClick="btnvoltar_Click" />
                            
                        </td>
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
