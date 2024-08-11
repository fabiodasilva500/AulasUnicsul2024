/*
 * 1) Carregar um vetor [100] real de valores de saldos. Calcular e exibir:
	Média dos saldos positivos entre 100 à 1000
	Média geral dos saldos
	Soma dos saldos negativos
 */
import javax.swing.JOptionPane;
public class Exercicio1 {
	static double soma_total=0,soma_geral=0,m_geral,saldos[]=new double [100];
	static int i;
	public static void main(String[]args){
		for (i=0;i<=99;i++)
		{
			saldos[i]=Integer.parseInt(JOptionPane.showInputDialog("Informe o valor do saldo bancário"));
			soma_total=(soma_total+saldos[i]);                 
			soma_geral=(soma_geral+1);                         
		}
		m_geral=(soma_total/soma_geral);                   
		JOptionPane.showMessageDialog(null, "A média total dos saldos informados tem como resultado:"+m_geral);         
		rot_saldos_faixa();                                
		rot_saldos_negativos();                            
	}

	public static void rot_saldos_faixa(){
		double soma_faixa=0,soma_q_faixa=0,media_faixa;
		for (i=0;i<=99;i++)
		{
			if ((saldos[i]>=100)&&(saldos[i]<=1000)){
				soma_faixa=(soma_faixa+saldos[i]);                       
				soma_q_faixa=(soma_q_faixa+1);                           
			}
		}
		media_faixa=(soma_faixa/soma_q_faixa);                  
		JOptionPane.showMessageDialog(null, "A média dos saldos entre 100 e 1000 tem como resultado:"+media_faixa);           
	}

	public static void rot_saldos_negativos(){
		double soma_quantidade=0;
		for (i=0;i<=99;i++)
		{
			if (saldos[i]<0){
				soma_quantidade=(soma_quantidade+saldos[i]);             
			}
		}
		JOptionPane.showMessageDialog(null, "A soma do valor total de saldos negativos informados foi de:"+soma_quantidade);        
	}
}



