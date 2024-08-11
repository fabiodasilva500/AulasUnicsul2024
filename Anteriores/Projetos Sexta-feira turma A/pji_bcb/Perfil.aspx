<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Perfil.aspx.cs" Inherits="Perfil" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>HOME</title>
    <link href="style.css" rel="stylesheet" />
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
                

                <div><p> <asp:Button ID="btnsair" runat="server" OnClick="btnsair_Click" Text="Sair" CssClass="botao" /></p></div>
                <div><p> <asp:Button ID="btntras" runat="server" OnClick="btpaginatransferir_Click" Text="Transferencias" CssClass="botao" /></p></div>
                <div><p> <asp:Button ID="btndeposito" runat="server" OnClick="btndeposito_Click" Text="Deposito" CssClass="botao" /></p></div>
                <div><p> <asp:Button ID="btnsenha" runat="server" OnClick="btnsenha_Click" Text="Mudar Senha" CssClass="botao" /></p></div>
                 <div><p> <asp:Button ID="btnhistorico" runat="server" OnClick="btnhistorico_Click" Text="Historico" CssClass="botao" /></p></div>
                
            </div>
        </nav>
        <div class="janela3">
            <div class="tituloPagina"><p>Bem Vindo(a) <p><asp:Label ID="nome" runat="server"></asp:Label></p></p></div>
            <p>SALDO:
                <asp:Label ID="lblsaldo" runat="server"></asp:Label>
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
