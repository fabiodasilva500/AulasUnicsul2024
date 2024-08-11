import javax.swing.JOptionPane;

public class BubbleSort {
	public static int vetor[]=new int [10];        	//declarando o vetor que ir� armazenar os valores
	public static int i;                            //declarando a vari�vel que ser� utilizada como vari�vel de incremento


	public static void main(String[] args) {
		for (i=0;i<9;i++)
		{
			vetor[i]=Integer.parseInt(JOptionPane.showInputDialog("Informe um n�mero"));        //armazenando os dados informados no vetor
		}

		rot_ordenar();                    //chamando a rotina de ordena��o
		rot_exibir();                     //chamando a rotina de exibi��o
	}

	public static void rot_ordenar(){
		int j,aux;
		for (i=0;i<9;i++)                                //declarando o primeiro la�o de repeti��o
			for (j=i+1;j<10;j++)                              //declarando um segundo la�o de repeti��o para que possa ser realizada a compara��o dos valores armazenados no vetor
			{
				if (vetor[i]>vetor[j]) {                            //se o conte�do da posi��o do vetor for maior que o conte�do da anterior, as vari�veis ser�o tratadas para que ocorra uma ordena��o dos valores
					aux=vetor[i];                                      //caso ela seja verdadeira, a vari�vel aux recebe o conte�do de vetor[i]
					vetor[i]=vetor[j];                                 //a posi��o do vetor ficou moment�neamente v�zia, sendo assim ela recebe o conte�do da posi��o posterior
					vetor[j]=aux;                                      //agora o conte�do da posi��o posterior ficou vago ent�o ela recebe o conte�do da posi��o anterior da vari�vel vetor[i], que est� armazenada na vari�vel aux para que possa ocorrer a substitui��o e ordena��o dos valores
				}
			}
	}

	public static void rot_exibir(){
		System.out.println("Os valores informados em ordem crescente s�o:");
		for (i=0;i<10;i++)
		{
			System.out.println(+vetor[i]);                  //exibindo os valores em ordem crescente
		}
	}

}
