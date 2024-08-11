
import javax.swing.JOptionPane;
public class Exercicio2 {
	static int i,j,f,aux,vetor[]=new int [5];
	static int vetfat[]=new int [5];

	public static void main(String[]args){
		for (i=0;i<=4;i++)
		{
			aux=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor para que seja calculado o seu fatorial"));         

			while(aux<=0){
				aux=Integer.parseInt(JOptionPane.showInputDialog("Você informou um valor inválido por favor insira novamente"));      
			}

			vetor[i]=aux;                              
			vetfat[i]=(Fatorial(f));                  
			JOptionPane.showMessageDialog(null, "O fatorial do número:"+vetor[i]+", tem como resultado:"+vetfat[i]);                  
		}
	}

	public static int Fatorial(int num){
		f=1;
		for (j=1;j<=vetor[i];j++)
		{
			f=(f*j);                         
		}
		return f;                         
	}
}

