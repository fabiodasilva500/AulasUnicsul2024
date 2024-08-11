/*
 9) Realize recursivamente a soma de todos os números ímpares de 1 a 300
*/

public class Exercicio9 {
	static int s=0;
	public static void main(String[]args){
		System.out.println("Soma de todos os números ímpares de 1 a 300:"+Somar(s));
	}

	public static int Somar(int num){
		if (num==300){
			s=(s+300);                        
			return 300;                       
		}

		else{
			Somar(num+1);                    

			if(num%2==1) {
			s=(s+num);                       
			}
			return s;
		}
	}
}
