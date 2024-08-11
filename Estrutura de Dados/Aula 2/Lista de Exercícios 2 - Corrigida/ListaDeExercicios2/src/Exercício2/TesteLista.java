/*
	2) Implemente uma Lista de caracteres em aloca��o est�tica com todas as opera��es 
*/


package Exerc�cio2;

import javax.swing.JOptionPane;
public class TesteLista {
	public static void main(String[]args){
		Lista listaCaracteres=new Lista();                   
		int op=0,pos;
		char caractere;
		while(op!=99){
			op=Integer.parseInt(JOptionPane.showInputDialog("Cadastro\n1-Adiciona Final\n2-Adiciona In�cio\n3-Adiciona em uma posi��o espec�fica\n"
					+ "4-Remove Final\n5-Remove In�cio\n6-Remove de uma posi��o espec�fica\n7-Mostra Elementos\n99-Sair"));

			switch(op){
			case 1:
				caractere=JOptionPane.showInputDialog("Informe um caractere").charAt(0);
				listaCaracteres.AdicionaFinal(caractere);
				break;
			case 2:
				caractere=JOptionPane.showInputDialog("Informe um caractere").charAt(0);
				listaCaracteres.AdicionaInicio(caractere);
				break;
			case 3:
				caractere=JOptionPane.showInputDialog("Informe um caractere").charAt(0);
				pos=Integer.parseInt(JOptionPane.showInputDialog("Informe a posicao do vetor que voc� deseja inserir o caractere"));
				pos=pos-1;     
				listaCaracteres.AdicionaQualquerPosicao(caractere,pos);
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+listaCaracteres.RemoveFinal());				
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+listaCaracteres.RemoveInicio());
				break;
			case 6:
				pos=Integer.parseInt(JOptionPane.showInputDialog("Informe a posi��o do vetor que voc� deseja remover o caractere"));
				pos=pos-1;     
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+listaCaracteres.RemoveQualquerPosicao(pos));
				break;
			case 7:
				JOptionPane.showMessageDialog(null,"Lista:"+listaCaracteres.percorre());       
				break;
			case 99:
				JOptionPane.showMessageDialog(null,"Saindo");
				break;
			default:
				JOptionPane.showMessageDialog(null,"Op��o inv�lida");
			}
		}
	}
}
