
public class ExemplosRecursao {
	
	public static void main(String[]args) {
		int n = 5;
		int vet[]={8, 2, 3 ,4, 1};  
		System.out.println(fatorial(n)+"\n");
		System.out.println(fibonacci(n)+"\n");
		System.out.println(somaVetor(vet, n)+"\n");
		System.out.println(soma1aN(n)+"\n");
		System.out.println(retNaturaisDec(n)+"\n");

	}
	
	
	/* Ex1 --> Faça uma função recursiva que calcule e retorne o fatorial de um número inteiro N. */
	static int fatorial(int n) {
		if(n < 2) {
			return 1;
		}
		return n * fatorial(n - 1);
	}
	
	
	/* Ex2 --> Faça uma função recursiva que calcule e retorne o N-ésimo termo da sequência Fibonacci.
    Alguns números desta sequência são: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...        */
	
	static int fibonacci(int n) {
		if(n < 2) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	
	/* Ex3 --> Faça uma função recursiva que permita somar os elementos de um vetor de inteiros. */
	static int somaVetor(int vet[], int n) {
		if(n == 1) {
			return vet[0];
		}
		return vet[n - 1] + somaVetor(vet, n - 1);
	}
	
	
	/* Ex5 --> Crie uma função recursiva que receba um número inteiro positivo N e calcule o somatório dos números de 1 a N */

	static int soma1aN(int n) {
		if(n == 1) {
			return 1;
		}
		return n + soma1aN(n - 1);
	} 
	
	
	/* Ex6 --> Faça uma função recursiva que receba um número inteiro positivo N e imprima todos os números naturais de
	0 até N em ordem decrescente */
	static int retNaturaisDec(int n) {
		if(n == -1) {
			return 0;
		}
		System.out.println("--"+n);
		return retNaturaisDec(n - 1);
	}

}
