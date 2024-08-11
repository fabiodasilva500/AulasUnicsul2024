import javax.swing.JOptionPane;

/*
 6) Receba um n�mero inteiro. Calcule e mostre o seu fatorial recursivamente.
*/

public class Exercicio6 {
	public static void main(String[]args){
		int n;
		n=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor para que seja calculado o seu fatorial"));
		while(n<=0){
			n=Integer.parseInt(JOptionPane.showInputDialog("Voc� informou um n�mero inv�lido, digite novamente"));
		}
		JOptionPane.showMessageDialog(null,"O fatorial do n�mero �:"+Fatorial(n));
	}

	public static int Fatorial(int num){
		int f;
		if (num==1){
			return 1;
		}
		else{
			f=(num*Fatorial(num-1));
			return f;
		}
	}
}