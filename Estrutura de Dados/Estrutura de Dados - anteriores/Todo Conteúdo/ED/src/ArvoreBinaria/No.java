package ArvoreBinaria;


/**
 *
 * @author Rodrigo Pereira
 */
  public class No{
      public int dados;
      public No esquerda;
      public No direita;
     /**
     Construtor do nó. Inicia elemento por parâmetro e
     atributos esquerda e direita com null.
     @param e elemento do nó
     */
      public No(int e){
         dados = e;
         esquerda = null;
         direita = null;
      }
   }
