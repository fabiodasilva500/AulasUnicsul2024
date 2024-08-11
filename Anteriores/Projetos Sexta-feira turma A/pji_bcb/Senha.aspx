<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Senha.aspx.cs" Inherits="Senha" %>

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
    <title>BCB/ Mudar Senha</title>
</head>
<body>

    <header>
        <h1>BCB</h1>
        <p>Sua história nossa independência</p>
    </header>

    <div class="camadaColor">
        <nav>
            <div id="separar" class="navegacao">
                <a href="Saldo.html"><div><p>Saldo</p></div></a>
                <a href="Extrato.html"><div><p>Extrato</p></div></a>
                <a href="Perfil.html"><div><p>Perfil</p></div></a>
                
            </div>
        </nav>
        <div class="janela3">
            <div class="tituloPagina"><p>Mudar Senha</p></div>
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
                            ALTERE SUA SENHA
                        </td>
                        <td>
                            <asp:TextBox ID="txtsenha" runat="server"/>
                        </td>
                        <td>
                            <asp:Button Text="Alterar" runat="server" Class="botao" ID="btnalterar" OnClick="btnalterar_Click" />
                             <asp:Button Text="voltar" runat="server" Class="botao" ID="btnvoiltar" Visible="false" OnClick="btnvoiltar_Click" />
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
