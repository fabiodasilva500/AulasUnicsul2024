package AgendaTele;

/**
 *
 * @author Rodrigo Pereira
 */
public class ListaAgenda {


     private NoAgenda inicio;
     
     public ListaAgenda(){
         
         inicio = null;
     }
     
     public boolean isVazia(){
         
         return (inicio == null);
     }
     
     public void adiciona(Agenda e){
         NoAgenda novo = new NoAgenda(e);
         if(isVazia())
             inicio = novo;
         else{
             novo.prox = inicio;
             inicio = novo;
         }
         System.out.println("Contato adicionado na Agenda!");
     }

     public Agenda remover(String nome){
         Agenda e = null;
         if(isVazia())
             System.out.println("Erro! Lista Vazia!");
         else{
             if(inicio.dados.getNome().equals(nome)){
               e = inicio.dados;
               inicio = inicio.prox;
         }else
                 System.out.println("Erro! Não existe contato com esse Nome!");
        }
         return  e;
     }

     public void Percorrer(){

         NoAgenda aux;
         if(isVazia())
             System.out.println("Erro!Lista Vazia");
         else{
             aux = inicio;
             while(aux.prox != null){
                 System.out.println(aux.dados.getNome());
                 System.out.println(aux.dados.getTel());
             }

         }

     }

     public void recPercorre(NoAgenda aux){

         if(aux.prox != null){
             System.out.println(aux.dados.getNome());
             System.out.println(aux.dados.getTel());
             aux = aux.prox;
         }
             
     }//Fim da Recursiva

}//Fim da Classe
