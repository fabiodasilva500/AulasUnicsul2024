package AgendaTele;

/**
 *
 * @author Rodrigo Pereira
 */

public class TabelaEspalhamento {


 private ListaAgenda lista[];

 public TabelaEspalhamento(){

     lista = new ListaAgenda[26];

 }

 public int funcaoEspalhamento(char e){

     int ind = Character.toLowerCase(e)-97;

     return  ind;
 }


 public void adiciona(Agenda e){

     char letra = e.getNome().charAt(0);
     int indice = funcaoEspalhamento(letra);
     if(lista[indice]==null)
         lista = new ListaAgenda[indice];
         lista[indice].adiciona(e);
 }//Fim do Método adiciona

 public Agenda remover(String nome){

     Agenda e = null;

     char ind = e.getNome().charAt(0);
     int indice = funcaoEspalhamento(ind);
     if(lista[indice] == null)
         System.out.println("Erro! não há Lista para esse contato!");
     else
         e = lista[indice].remover(nome);

     return e;
 }

 public void percorrer(){

     for(int i = 0; i<lista.length; i++)
         lista[i].Percorrer();
 }

}//Fim da Classe
