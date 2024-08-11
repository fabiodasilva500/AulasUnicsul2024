package Arvore;

/**
 *
 * @author Rodrigo Pereira
 */
public class No {
    public int dados;
    public No dir;
    public No esq;
    
    public No(int e){
        dados=e;
        dir=null;
        esq=null;
    }
    
}
