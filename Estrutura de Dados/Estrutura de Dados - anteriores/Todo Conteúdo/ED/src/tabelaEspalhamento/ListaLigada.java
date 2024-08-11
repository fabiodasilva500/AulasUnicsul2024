package tabelaEspalhamento;

/**
 *
 * @author Rodrigo Pereira
 */

public class ListaLigada {

    private No inicio;

 //Método construtor, que cria a lista vazia
 public ListaLigada(){

     inicio = null;

 }//Fim do Método construtor

 //OPerações
 public void adicionaInicio(Eletronico e){

   No novo = new No(e);
   novo.prox = inicio;
   inicio = novo;
 }//Fim do Método adicionNoInicio

 public void adicionaFinal(Eletronico e){
     No aux = null;
     No novo = new No(e);
     if(inicio == null)
         inicio = novo;
     else{
         aux = novo;
         while(aux.prox != null)
             aux = aux.prox;
     }

 }//Fim do Método adicionaFinal

 public void percorrerEletronicos(){

     Eletronico e=null;
        String a = "";
        No aux = inicio;
        No aux2 = inicio;
        if(inicio.prox == null)
            a+= aux.dados;
        else{
        while(inicio.prox!=null)
        {
            aux2 = aux;
            aux = aux.prox;
            a+=aux.dados+"|";
        }//Fim do While
          a+=aux.dados.getEletronico();
        }
        System.out.println(aux.dados.getEletronico());




    }//Fim do Método Percorrrer Aluno
}//Fim da Classe Lista Aluno




