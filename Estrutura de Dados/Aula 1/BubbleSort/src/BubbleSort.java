import javax.swing.JOptionPane;

public class BubbleSort {
	public static int vetor[]=new int [10];        	//declarando o vetor que irá armazenar os valores
	public static int i;                            //declarando a variável que será utilizada como variável de incremento


	public static void main(String[] args) {
		for (i=0;i<9;i++)
		{
			vetor[i]=Integer.parseInt(JOptionPane.showInputDialog("Informe um número"));        //armazenando os dados informados no vetor
		}

		rot_ordenar();                    //chamando a rotina de ordenação
		rot_exibir();                     //chamando a rotina de exibição
	}

	public static void rot_ordenar(){
		int j,aux;
		for (i=0;i<9;i++)                                //declarando o primeiro laço de repetição
			for (j=i+1;j<10;j++)                              //declarando um segundo laço de repetição para que possa ser realizada a comparação dos valores armazenados no vetor
			{
				if (vetor[i]>vetor[j]) {                            //se o conteúdo da posição do vetor for maior que o conteúdo da anterior, as variáveis serão tratadas para que ocorra uma ordenação dos valores
					aux=vetor[i];                                      //caso ela seja verdadeira, a variável aux recebe o conteúdo de vetor[i]
					vetor[i]=vetor[j];                                 //a posição do vetor ficou momentâneamente vázia, sendo assim ela recebe o conteúdo da posição posterior
					vetor[j]=aux;                                      //agora o conteúdo da posição posterior ficou vago então ela recebe o conteúdo da posição anterior da variável vetor[i], que está armazenada na variável aux para que possa ocorrer a substituição e ordenação dos valores
				}
			}
	}

	public static void rot_exibir(){
		System.out.println("Os valores informados em ordem crescente são:");
		for (i=0;i<10;i++)
		{
			System.out.println(+vetor[i]);                  //exibindo os valores em ordem crescente
		}
	}

}
