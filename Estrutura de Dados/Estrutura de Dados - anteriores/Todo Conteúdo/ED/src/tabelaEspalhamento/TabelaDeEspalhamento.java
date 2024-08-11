package tabelaEspalhamento;

/**
 *
 * @author Rodrigo Pereira
 */

public class TabelaDeEspalhamento {

    private ListaLigada lista[];
    
 //Método construtor, que cria a lista vazia
 public TabelaDeEspalhamento(){
     
     lista = new ListaLigada[10];

 }//Fim do Método construtor


 public int espalhamento(int chave){

     int indice = chave % 10;

     return indice;
 }

 public void adicionaElemento(Eletronico e){

     int indice = espalhamento(e.getCod());
     if(lista[indice]==null)
      lista[indice] = new ListaLigada();
      lista[indice].adicionaFinal(e);

 }//Fim do Método adiconaElemento


public void percorre(){



}//Fim do Método percorre



}//Fim da Classe Lista Inteiros

