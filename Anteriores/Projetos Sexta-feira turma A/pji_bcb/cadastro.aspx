<%@ Page Language="C#" AutoEventWireup="true" CodeFile="cadastro.aspx.cs" Inherits="cadastro" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Cadastrar</title>
    <link href="style.css" rel="stylesheet" />
</head>

<body>
    <form id="form1" runat="server">
    <div>
    
    <div class="camadaColor">
        <div class="janela">
            <header>
                <h1>BCB</h1>
                <p>Sua história nossa independência</p>
                <h3><asp:Label Text="" ID="resposta" runat="server" /></h3>
            </header>
        
            <section>
                <div class="areaCadastro">
                    <h2>Cadastro</h2>
                    <form action="">
                        <div>
                            <p>Nome :</p>
                            <asp:TextBox ID="txtnome" runat="server"></asp:TextBox>
                        </div>
                        <div>
                            <p>CPF :</p>
                            <asp:TextBox ID="txtcpf" runat="server" TextMode="Number"></asp:TextBox>
                        </div>
                        <div>
                            <p>E-mail :</p>
                            <asp:TextBox ID="txtemail" runat="server" TextMode="Email"></asp:TextBox>
                        </div>
                        <div>
                            <p>Senha :</p>
                            <asp:TextBox ID="txtsenha" runat="server" TextMode="Password"></asp:TextBox>
                        </div>
                        <div>
                            <p>Corfirme sua senha :</p>
                            <asp:TextBox ID="txtsenhac" runat="server" TextMode="Password"></asp:TextBox>
                        </div>
                        <div class="">
                            <div></div>
                            <p>
                               <asp:Button CssClass="botao" id="btncadastro" Text="Cadastrar" runat="server" OnClick="btncadastro_Click" />
                                <asp:Button CssClass="botao" ID="btnvoltar" Text="Voltar ao Login" runat="server" Visible="false" OnClick="btnvoltar_Click" />
                            </p>
                            <div></div>
                        </div>

                    </form>
                </div>
            </section>
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
    </div>
    </form>
</body>
</html>
