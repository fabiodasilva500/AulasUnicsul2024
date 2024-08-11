package TabelaAgenda;

/**
 *
 * @author Rodrigo Pereira
 */
public class No {


    public Contato dado;
    public No prox;
    
    public No(Contato c){
        dado = c;
        prox = null;        
    }
}
