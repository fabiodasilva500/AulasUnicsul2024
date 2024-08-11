import javax.swing.JOptionPane;


public class Exemplo1ExibeValores {
	public static void main(String args[]){
		exibeValores(100);
	}

	static int exibeValores(int n){
		if(n==0)
			return n;
		else{
 			System.out.println("O valor de N é:"+n);
			exibeValores(n-1);
			return n;
		}
	}
}
