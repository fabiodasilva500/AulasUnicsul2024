package Arvore;

/**
 *
 * @author Rodrigo Pereira
 */
public class Arvore {

    private NoArvore raiz;

    public Arvore(){

        raiz = null;
    }


    public void adicionar(int e){

        NoArvore aux1 = raiz;
        NoArvore aux2 = raiz;

        NoArvore novo = new NoArvore(e);
        if(raiz == null)
            raiz = novo;
        else
            while(aux1 != null){
                aux2 = aux1;
                if(e > aux1.dados)
                    aux1 = aux1.direito;
                else
                if(e < aux1.dados)
                    aux1 = aux1.esquerdo;
            }//Fim do while
           if(e > aux2.dados)
               aux2.direito = novo;
           else
           if(e < aux2.dados)
               aux2.esquerdo = novo;
           }

    public void percorrerPreOrdem(NoArvore a){

        a = raiz;
        if(a!=null){
            System.out.println(a.dados+" ");
            percorrerPreOrdem(a.esquerdo);
            percorrerPreOrdem(a.direito);
        }

    }

    public void percorerEmOrdem(NoArvore a){
        a = raiz;
        if(a!=null){
            percorrerPreOrdem(a.esquerdo);
            System.out.println(a.dados+" ");
            percorrerPreOrdem(a.direito);
        }
    }

    public void percorrerPosOrdem(NoArvore a){

         a = raiz;
        if(a!=null){
            percorrerPreOrdem(a.esquerdo);
            percorrerPreOrdem(a.direito);
            System.out.println(a.dados+" ");
        }
    }

}//Fim da Classe Árvore
