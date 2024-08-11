/*
 5) Criar e carregar  uma matriz [4 x 4] inteiro, onde os valores da diagonal 
 principal serão carregados pela aplicação conforme o gráfico e os demais dados 
 serão digitados pelo usuário
*/

import javax.swing.JOptionPane;
public class Exercicio5 {
	static int i,j,y,matriz[][]=new int [4][4];

	public static void main(String[]args){
		y=1;          
		for (i=0;i<=3;i++)
			for (j=0;j<=3;j++)
			{
				if ((i==j)&&(i==0)){
					matriz[i][j]=y;                    
				}
				if ((i==j)&&(i!=0)){
					y=(y*3);                           
					matriz[i][j]=y;                    
				}
			}
		rot_inserir_valores();              
		rot_exibir_valores();               
	}

	public static void rot_inserir_valores(){
		for (i=0;i<=3;i++)
			for (j=0;j<=3;j++)
			{
				if (i!=j){
					matriz[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor para que gradativamente a matriz seja completada"));
				}
			}
	}

	public static void rot_exibir_valores(){
		System.out.println("Valores completados:");
		for (i=0;i<=3;i++)
			for (j=0;j<=3;j++)
			{
				System.out.println(+matriz[i][j]);
			}
	}
}