package Exercicio3;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) {
		Lista lista = new Lista();
		Pilha pilha = new Pilha();

		int opc=0;
		int x;
		String mostra;

		while(opc!=99) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Opções: \n 1- Inserir valor na lista \n 2- Remover valor da lista \n 3- Mostrar lista \n 4 - Inserir valor na pilha \n 5 - Remover valor da pilha \n 6 - Mostrar pilha \n 99- Sair"));

			switch(opc) {
			case 1:
				x = Integer.parseInt(JOptionPane.showInputDialog("Insira um valor para adicionar a lista:"));
				lista.Adicionar(x);
				break;
			case 2:
				if(!lista.VerifVazia()) {
					pilha.Adicionar(lista.retornar());
					lista.Remover();
				}
				break;
			case 3:
				mostra = lista.percorre();
				JOptionPane.showMessageDialog(null,"A lista é: " + mostra);
				break;
			case 4:
				x = Integer.parseInt(JOptionPane.showInputDialog("Insira um valor para adicionar a pilha:"));
				pilha.Adicionar(x);
				break;
			case 5:
				if(!pilha.VerifVazia()) {
					lista.Adicionar(pilha.retornar());
					pilha.Remover();
				}
				break;

			case 6:
				mostra = pilha.percorre();
				JOptionPane.showMessageDialog(null,"A pilha é: " + mostra);
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