/*
 7) Realize recursivamente a soma de todos os números de 1 a 100.
*/

public class Exercicio7 {
	static int s=0;
	public static void main(String[]args){
		System.out.println("A soma dos 100 primeiros números inteiros tem como resultado o valor de:"+Somar(s));
	}

	public static int Somar(int num){
		if (num==100){
			s=(s+100);                        
			return 100;                       
		}

		else{
			Somar(num+1);                    
			s=(s+num);                       
			return s;
		}
	}

}
