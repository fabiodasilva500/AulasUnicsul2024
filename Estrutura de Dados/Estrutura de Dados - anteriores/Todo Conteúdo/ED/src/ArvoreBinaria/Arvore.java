package ArvoreBinaria;

/**
 *
 * @author Rodrigo Pereira
 */
public class Arvore {

private No raiz;

 public Arvore(){
     
     raiz = null;
 }

/**
   	Método que adiciona novo elemento em árvore de busca não
		balanceada.
   	Mantém em ordem (e-v-d)
   	*/
      public void adicionaElemento(int e){
         No novo = new No(e);
         No aux1=raiz;
         No aux2=raiz;
         if (aux1 != null){
         //busca posição para incluir até chegar em um nó folha
         //ou entrar o elemento já incluído
            while (aux1 != null && aux1.dados != e){
            //marca um nó anterior ao aux1
               aux2=aux1;
            //se parâmetro é menor que elemento
            //do nó atual, vai para a esquerda
               if (e<aux1.dados)
                  aux1=aux1.esquerda;
               //se parâmetro é maior que elemento
               //do nó atual, vai para a direita
               else if (e>aux1.dados)
                  aux1=aux1.direita;
            }
         //se o elemento já existe, não o inclui
            if (e == aux2.dados)
               System.out.println("Elemento já existe");
            else{
             //se o parâmetro é menor que o elemento do nó folha,
             //inclui à esquerda
               if (e < aux2.dados)
                  aux2.esquerda = novo;
             //se o parâmetro é maior que o elemento do nó folha,
             //inclui à direita
               if (e > aux2.dados)
                  aux2.direita = novo;
               System.out.println(e+" Incluído");
               //raiz = aux2;
            }
         }
         else{
			 raiz=novo;
			 System.out.println(e+" Incluído");
			}
      }

      /* Percorrer em pré-ordem
   @param a subarvore a percorrer
   */
      public void preOrdem(No a){
          a = raiz;
         if(a != null){
            System.out.print(a.dados + "  ");
            preOrdem(a.esquerda);
            preOrdem(a.direita);
         }
      }


   /**
   Percorrer em ordem
   @param a subarvore a percorrer
   */
      public void emOrdem(No a){
          a = raiz;
         if(a != null){
            emOrdem(a.esquerda);
            System.out.print(a.dados+"  ");
            emOrdem(a.direita);
         }
      }

   /**
   Percorrer em pós-ordem
   @param a subarvore a percorrer
   */
      public void posOrdem(No a){
          a = raiz;
         if(a != null){
            posOrdem(a.esquerda);
            posOrdem(a.direita);
            System.out.print(a.dados+"  ");
         }
      }


 

}
