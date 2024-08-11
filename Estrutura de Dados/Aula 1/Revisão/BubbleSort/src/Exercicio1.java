
import javax.swing.JOptionPane;
public class Exercicio1 {
	static int i,valores[]=new int [10];
	public static void main(String[]args){
		for (i=0;i<=9;i++)
		{
			valores[i]=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor"));
		}
		rot_ordenar();                 //chamando a rotina que irá realizar a ordenação dos valores
		rot_exibir();                  //chamando a rotina que irá exibir os valores ordenados
	}

	public static void rot_ordenar(){
		int j,aux;
		for (i=0;i<=8;i++)
			for (j=i+1;j<=9;j++)
			{
				if (valores[i]>valores[j]){
					aux=valores[i];
					valores[i]=valores[j];
					valores[j]=aux;
				}
			}
	}

	public static void rot_exibir(){
		System.out.println("Valores ordenados:");
		for (i=0;i<=9;i++)
		{
			System.out.println(+valores[i]);
		}
	}

}
