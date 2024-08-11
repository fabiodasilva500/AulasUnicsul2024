package TabelaAgenda;

/**
 *
 * @author Rodrigo Pereira
 */

import java.util.Scanner;

public class TesteChar {

    public static int teste(char x){

        return x;
    }

    public static void main(String[] args) {

        System.out.println("Código ASCII de A até Z - Convertido em caracters Minúsculos");
    for(char x='A'; x<='Z';x++)
            System.out.println(x+"=>"+ Character.toLowerCase(x)+
                    "=>"+(Character.toLowerCase(teste(x))-97));
        System.out.println("Código ASCII de A a Z");

        for(char x='A';x<='Z';x++)
            System.out.println(x+"=>"+ teste(x));
        System.out.println("Código ASCII de a até z");
        for(char x='a';x<='z';x++)
          System.out.println(x+"=>"+(teste(x)-97));
          System.out.println("Dica para associar com Índice vetor");
           for(char x='a';x<='z';x++)
               System.out.println(x+"=>"+(teste(x)-97));

          //Leitura do texto via Teclado
          Scanner sc = new Scanner(System.in);
          System.out.println("Digite seu nome: ");
          String nome = sc.next();
          System.out.println();

          //Obtem o primeiro caracter, mostra com ASCII
          char x = nome.charAt(0);
          System.out.println("Primeira letra do seu nome: "+x+
                  (Character.toLowerCase(teste(x))-97));

    }


}
