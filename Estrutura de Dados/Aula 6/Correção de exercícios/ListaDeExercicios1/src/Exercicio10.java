/*
Receba um n�mero inteiro. Calcule e mostre a s�rie de Fibonacci recursivamente at� o 
n�mero recebido
*/

public class Exercicio10 {
	  public static void main(String[] args) {
		  Exercicio10 fib = new Exercicio10();
		    System.out.println(fib.fibonacci(10));
		  }

		  public int fibonacci(int z) {
		    if (z == 0 || z == 1 )
		      return z;

		    return fibonacci(z - 1) + fibonacci(z - 2);
		  }
		}
