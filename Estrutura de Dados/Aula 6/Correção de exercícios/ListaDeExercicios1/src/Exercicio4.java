import javax.swing.JOptionPane;
public class Exercicio4 {
	static int i,j, s_faixa=0,s_impares=0,s_divisivelOito = 0, s_divisivelTres = 0; 
	static int valores[][]=new int [4][4];

	public static void main(String[]args){
		int maior = 0;

		for (i=0;i<=3;i++)
			for (j=0;j<=3;j++)
			{
				valores[i][j]=Integer.parseInt(JOptionPane.showInputDialog("Informe um valor"));

				if(i==0 && j == 0){
					maior = valores[i][j];
				}

				if(valores[i][j]>maior){
					maior = valores[i][j];
				}
			}

		JOptionPane.showMessageDialog(null, "A soma dos números compreendidos na faixa de 1 á 100 tem como resultado:"+Faixa());          
		JOptionPane.showMessageDialog(null, "A quantidade de números ímpares entre 30 a 50 é igual á:"+Impares());                                        
		JOptionPane.showMessageDialog(null, "A quantidade de números divisíveis por 8 igual á:"+ModuloDivisaoOito());                                        
		JOptionPane.showMessageDialog(null, "A quantidade de números ímpares divísiveis por 3 é igual a:"+ModuloDivisaoTres());
		JOptionPane.showMessageDialog(null, "O fatorial do maior número informado é:"+Fatorial(maior));                                        
	}

	public static int Faixa (){
		for (i=0;i<=3;i++)
			for (j=0;j<=3;j++)
			{
				if ((valores[i][j]>=1)&&(valores[i][j]<=100)){
					s_faixa=(s_faixa+valores[i][j]);
				}
			}
		return s_faixa;                
	}


	public static int Impares(){
		for (i=0;i<=3;i++)
			for (j=0;j<=3;j++)
			{
				if ((valores[i][j]>=30)&&(valores[i][j]<=50)){
					if (valores[i][j]%2==1)
						s_impares=(s_impares+1);
				}
			}
		return s_impares;             
	}


	public static int ModuloDivisaoOito(){
		for (i=0;i<=3;i++)
			for (j=0;j<=3;j++)
			{
				if (valores[i][j]%8==0)
					s_divisivelOito=(s_divisivelOito+1);
			}
		return s_divisivelOito;             
	}
	
	public static int ModuloDivisaoTres(){
		for (i=0;i<=3;i++)
			for (j=0;j<=3;j++)
			{
				if (valores[i][j]%3==0 && valores[i][j]%2==1)
					s_divisivelTres=(s_divisivelTres+1);
			}
		return s_divisivelTres;             
	}

	public static int Fatorial(int maior){
		if(maior<=1){
			return maior;
		}
		else{
			return Fatorial(maior-1)*maior; 
		}
	} 
}