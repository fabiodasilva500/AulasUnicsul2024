package Agenda;

/**
 *
 * @author Rodrigo Pereira
 */
public class Lista {

    public No inicio;

    public Lista() {

        inicio = null;
    }

    public boolean  isVazia(){

        return (inicio == null);
    }
    public void adiciona(Agenda e){
        No novo = new No(e);
        if(isVazia())
          inicio = novo;
        else
        {
            novo.prox = inicio;
            inicio = novo;
        }
    }

    public Agenda remover(String nome){
        Agenda e = null;
        e = inicio.dados;
        if(isVazia())
            System.out.println("Erro!Lista Vazia");
        else

         if(nome.equals(e.getNome()))
        {
            inicio = inicio.prox;
            System.out.println("Removido");
        }else
            System.out.println("Nome Inválido");
        return e;
    }

    public void percorrer(){

        No aux = inicio;
        while(aux.prox != null){
            System.out.println(aux.dados.getNome());
            System.out.println(aux.dados.getNum());
            aux  = aux.prox;
        }

    }



}
