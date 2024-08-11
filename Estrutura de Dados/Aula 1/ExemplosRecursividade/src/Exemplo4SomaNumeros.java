public class Exemplo4SomaNumeros {
	static int s=0;
	public static void main(String[]args){
		System.out.println("A soma dos 10 primeiros números inteiros tem como resultado o valor de:"+Somar(s));
	}

	public static int Somar(int num){
		if (num==10){
			s=(s+10);                        
			return 10;                       
		}

		else{
			Somar(num+1);                    
			s=(s+num);                       
			return s;
		}
	}
}
