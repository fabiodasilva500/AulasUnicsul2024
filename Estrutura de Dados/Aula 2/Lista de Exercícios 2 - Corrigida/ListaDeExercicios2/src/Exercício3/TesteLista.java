/*
	3) Implemente uma Lista de Strings em aloca��o est�tica com todas as opera��es 
*/

package Exerc�cio3;

import javax.swing.JOptionPane;
public class TesteLista {
	public static void main(String[]args){
		Lista listaStrings=new Lista();                   
		int op=0,pos;
		String conteudo;
		while(op!=99){
			op=Integer.parseInt(JOptionPane.showInputDialog("Cadastro\n1-Adiciona Final\n2-Adiciona In�cio\n3-Adiciona em uma posi��o espec�fica\n"
					+ "4-Remove Final\n5-Remove In�cio\n6-Remove de uma posi��o espec�fica\n7-Mostra Elementos\n99-Sair"));

			switch(op){
			case 1:
				conteudo=JOptionPane.showInputDialog("Informe uma String");
				listaStrings.AdicionaFinal(conteudo);
				break;
			case 2:
				conteudo=JOptionPane.showInputDialog("Informe uma String");
				listaStrings.AdicionaInicio(conteudo);
				break;
			case 3:
				conteudo=JOptionPane.showInputDialog("Informe uma String");
				pos=Integer.parseInt(JOptionPane.showInputDialog("Informe a posicao do vetor que voc� deseja inserir uma String"));
				pos=pos-1;     
				listaStrings.AdicionaQualquerPosicao(conteudo,pos);
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+listaStrings.RemoveFinal());				
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+listaStrings.RemoveInicio());
				break;
			case 6:
				pos=Integer.parseInt(JOptionPane.showInputDialog("Informe a posi��o do vetor que voc� deseja remover a string"));
				pos=pos-1;     
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+listaStrings.RemoveQualquerPosicao(pos));
				break;
			case 7:
				JOptionPane.showMessageDialog(null,"Lista:"+listaStrings.percorre());       
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
