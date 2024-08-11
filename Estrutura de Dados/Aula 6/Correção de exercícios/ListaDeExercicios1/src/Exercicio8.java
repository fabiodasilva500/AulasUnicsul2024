
/*
Realize recursivamente a soma de todos os números pares de 1 a 200
*/

public class Exercicio8 {
	static int s=0;
	public static void main(String[]args){
		System.out.println("Soma de todos os números pares de 1 a 200:"+Somar(s));
	}

	public static int Somar(int num){
		if (num==200){
			s=(s+200);                        
			return 200;                       
		}

		else{
			Somar(num+1);                    

			if(num%2==0) {
			s=(s+num);                       
			}
			return s;
		}
	}
}
