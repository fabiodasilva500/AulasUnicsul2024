<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="Login" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  
    <link href="style.css" rel="stylesheet" />
    <title>BCB / Login</title>
</head>
<body>
      <form id="form1" runat="server" >
    <div class="camadaColor">
        <div class="janela">
            <header>
                <h1>BCB</h1>
                <p>Sua história nossa independência</p>
                <h3><asp:Label Text="" ID="resposta" runat="server" /></h3>
            </header>
        
            <section>
                <div class="image">
                    <div class="areaLogin">
                        <h2>Login</h2>
                        <div class="input">
                            <p>CPF : </p>
                            <asp:TextBox ID="txtcpf"  CssClass="input" runat="server" MaxLength="11" TextMode="Number"></asp:TextBox>
                        </div>
                        <div class="input">
                            <p>Senha : </p>
                            <asp:TextBox ID="txtsenha" CssClass="input" runat="server" TextMode="Password"></asp:TextBox>
                        </div>
                        <div>
                            <div class="">
                                <p>
                                    <asp:Button CssClass="botao" ID="btnlogin" runat="server" OnClick="btnentrar_Click" Text="Entrar" Width="85px"/>

                                </p>
                                <p>
                                    <asp:Button CssClass="botao" ID="btncadastro" runat="server" Text="Cadastre-se" Width="105px" OnClick="btncadastro_Click" />
                             </p>
                            </div>
                          
                        </div>
                            <p class="aviso">Não passe seus dados a ninguém, nós da BCB não solicitamos sua senha </p>
                            <p class="aviso">em mensagens, vídeochamadas ou telefone. </p>
                            <p class="aviso">Fique esperto!</p>
                    </div>
                
            
                    <p class="msg">Banco Colonial do Brasil</p>
                    <p class="msg">Seu dinheiro seguro pro que der e vier!</p>
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
      </form>
</body>
</html>
