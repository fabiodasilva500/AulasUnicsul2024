package TabelaAgenda;

/**
 *
 * @author Rodrigo Pereira
 */
public class ListaContatos {


    private  No inicio;

    public ListaContatos() {

        inicio=null;

    }

    public boolean  isVazia(){

        return(inicio==null);
    }

    public String percorre(){

        No n = inicio;
        String r="";
        while(n != null){
            System.out.println(" "+n.dado.toString());
            r =r+n.toString();
            n = n.prox;
        }
        System.out.println(" ");
        return r;
        
    }

    public void adiciona(Contato e){

        No novoNo = new No(e);
        No aux = inicio;
        if(isVazia())
            inicio = novoNo;
        else{
            while(aux.prox != null)
                aux = aux.prox;
        }



    }

  public Contato remove(String n){

     No aux1=inicio;
     No aux2=null;
     if(!isVazia())
     {
         while(!aux1.dado.getNome().equals(n) && aux1.prox != null){

             aux2.prox=aux1.prox;
                     return aux1.dado;

         }
     }
 else{
         System.out.println("Lista Vazia");
    }
     return null;
  }
}
