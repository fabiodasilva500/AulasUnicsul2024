
public class Exemplo3SomaDivisiveisPorTres {
	static int s=0;
	public static void main(String[]args){
		System.out.println("Soma de todos os n�meros divis�veis pro 3 de 1 a 100 tem como resultado:"+Somar(s));
	}

	public static int Somar(int num){
		if (num==100){
			s=(s+100);                        
			return 100;                       
		}

		else{
			Somar(num+1);                    

			if(num%3==0) {
				s=(s+num);                       
			}
			return s;
		}
	}
}