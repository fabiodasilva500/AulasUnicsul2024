
import javax.swing.JOptionPane;
public class Exemplo2Fatorial {
	public static void main(String[]args){
		int n;
		n=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor para que seja calculado o seu fatorial"));
		while(n<=0){
			n=Integer.parseInt(JOptionPane.showInputDialog("Você informou um número inválido, digite novamente"));
		}
		JOptionPane.showMessageDialog(null,"O fatorial do número é:"+Fatorial(n));
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
