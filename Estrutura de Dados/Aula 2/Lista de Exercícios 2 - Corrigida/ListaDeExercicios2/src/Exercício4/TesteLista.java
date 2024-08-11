/*
 Exemplo: Implemente uma Lista de temperaturas em alocação estática com todas as operações  
*/

package Exercício4;

import javax.swing.JOptionPane;
public class TesteLista {
	public static void main(String[]args){
		Lista listaTemperaturas=new Lista();                   
		int op=0,pos;
		double conteudo;
		while(op!=99){
			op=Integer.parseInt(JOptionPane.showInputDialog("Cadastro\n1-Adiciona Final\n2-Adiciona Início\n3-Adiciona em uma posição específica\n"
					+ "4-Remove Final\n5-Remove Início\n6-Remove de uma posição específica\n7-Mostra Elementos\n99-Sair"));

			switch(op){
			case 1:
				conteudo=Double.parseDouble(JOptionPane.showInputDialog("Informe a temperatura"));
				listaTemperaturas.AdicionaFinal(conteudo);
				break;
			case 2:
				conteudo=Double.parseDouble(JOptionPane.showInputDialog("Informe a temperatura"));
				listaTemperaturas.AdicionaInicio(conteudo);
				break;
			case 3:
				conteudo=Double.parseDouble(JOptionPane.showInputDialog("Informe a temperatura"));
				pos=Integer.parseInt(JOptionPane.showInputDialog("Informe a posicao do vetor que você deseja inserir a temperatura"));
				pos=pos-1;     
				listaTemperaturas.AdicionaQualquerPosicao(conteudo,pos);
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+listaTemperaturas.RemoveFinal());				
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+listaTemperaturas.RemoveInicio());
				break;
			case 6:
				pos=Integer.parseInt(JOptionPane.showInputDialog("Informe a posição do vetor que você deseja remover a temperatura"));
				pos=pos-1;     
				JOptionPane.showMessageDialog(null,"O elemento removido foi:"+listaTemperaturas.RemoveQualquerPosicao(pos));
				break;
			case 7:
				JOptionPane.showMessageDialog(null,"Lista:"+listaTemperaturas.percorre());       
				break;
			case 99:
				JOptionPane.showMessageDialog(null,"Saindo");
				break;
			default:
				JOptionPane.showMessageDialog(null,"Opção inválida");
			}
		}
	}
}
