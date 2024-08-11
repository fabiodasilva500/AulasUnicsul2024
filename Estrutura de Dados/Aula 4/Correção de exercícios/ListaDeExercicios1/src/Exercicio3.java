
import javax.swing.JOptionPane;
public class Exercicio3 {
	static int i,valores[]=new int [100];

	public static void main(String[]args){
		for (i=0;i<=9;i++)
		{
			valores[i]=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor"));
		}
		rot_ordenar();                         
		rot_exibir();                         
		rot_pesquisar();                      
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
		String concatena = "";
		for (i=0;i<=9;i++)
		{
			concatena += valores[i] + "\n";
		}
		JOptionPane.showMessageDialog(null, "Valores ordenados:\n"+concatena);
	}
	public static void rot_pesquisar(){
		int resposta,pesquisa,achar;
		resposta=Integer.parseInt(JOptionPane.showInputDialog("Caso você queira pesquisar algum número digite 1.\nCaso contrário digite outro valor e o programa será finalizado"));
		while(resposta==1){         
			pesquisa=Integer.parseInt(JOptionPane.showInputDialog("Informe um número que você deseja pesquisar"));
			achar=0;
			i=0;
			while((achar==0)&&(i<=99)){
				if (pesquisa==valores[i])
					achar=1;
				else
					i=i+1;
			}
			if (achar==1){
				JOptionPane.showMessageDialog(null , "O número:"+pesquisa+".Foi localizado na posição:"+i);
			}
			else{
				JOptionPane.showMessageDialog(null, "O número não foi localizado");
			}
			resposta=Integer.parseInt(JOptionPane.showInputDialog("Caso você queira pesquisar outro número digite 1.\nCaso contrário digite outro valor e o programa será finalizado"));
		}
	}
}

