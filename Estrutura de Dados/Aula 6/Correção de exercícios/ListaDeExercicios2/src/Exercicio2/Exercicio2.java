package Exercicio2;

import java.util.Random;

import javax.swing.JOptionPane;

public class Exercicio2 {
	static double[] dados;
	static int tamanho;

	public Exercicio2() {
		dados = new double[4];
		tamanho = 0;		
		Random gerador = new Random();
		for (int i=0;i<dados.length;i++){
			dados[i] = gerador.nextDouble();
			tamanho++;
		}
		int posicao = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição desejada para remoção"));
		JOptionPane.showMessageDialog(null,"O elemento removido foi:"+removeElementoEspecifico(posicao));        
	}

	static double removeElementoEspecifico(int posicao) {
		double itemRemovido =0;

		if ((posicao < tamanho) && (posicao >= 0) && (tamanho >= 1)) {
			itemRemovido = dados[posicao];

			for (int i = posicao; i < tamanho - 1; i++) {
				dados[i] = dados[i + 1];
			}

			tamanho--;
		}
		return itemRemovido;
	}

	public static void main(String[]args){
		new Exercicio2();
	}
}


