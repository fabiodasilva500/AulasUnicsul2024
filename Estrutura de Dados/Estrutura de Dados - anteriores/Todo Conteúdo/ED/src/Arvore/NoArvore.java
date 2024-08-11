package Arvore;

/**
 *
 * @author Rodrigo Pereira
 */
public class NoArvore {

    public NoArvore esquerdo;
    public NoArvore direito;
    public int dados;

    public NoArvore(int e){

        dados = e;
        esquerdo = null;
        direito = null;
    }

}
