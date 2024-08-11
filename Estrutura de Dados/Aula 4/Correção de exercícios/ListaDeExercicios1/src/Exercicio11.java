import javax.swing.JOptionPane;

/*
Receba um número. Calcule e mostre a série 1 + 1/2 + 1/3 + ... + 1/N recursivamente.
*/

public class Exercicio11 {
	static double n,calcular=0;
	public static void main(String[]args){
		n=Double.parseDouble(JOptionPane.showInputDialog("Informe um valor para que seja calculado\ne exibido o valor final da série"));
		JOptionPane.showMessageDialog(null,"O valor final da série tem como resultado:"+Serie(n));
	}

	public static double Serie(double num){
		if (num==1){
			calcular=calcular+1;                           
			return 1;                                     
		}
		else{
			Serie(num-1);                                
			calcular=calcular+(1/num);                   
			System.out.println(calcular);
		}
		return calcular;                              
	}
}

