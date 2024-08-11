package Pilha;

/**
 *
 * @author Rodrigo Pereira
 */
public class PilhaDinamica {
    private No inicio;
    
    public PilhaDinamica(){
        inicio=null;
    }
    
    public boolean vazia(){
        if(inicio==null){
            return true;
        }return false;
    }
    
    public void empilha(int e){
        No novo = new No(e);
        if(vazia()){
            inicio=novo;
        }else{
            No aux=inicio;
            
            while(aux.prox!=null){
                aux=aux.prox;
            }
            aux.prox=novo;
        }
    }
    
    public int desempilha(){
        int e=-1;
        
        if(vazia()){
            System.out.println("Pilha Vazia!");
            return e;
        }
        if(inicio.prox==null){
            e=inicio.dados;
            inicio=null;
            return e;
        }
        
        No aux=inicio;
        No aux2=inicio;
        
        while(aux.prox!=null){
            aux2=aux;
            aux=aux.prox;
        }
        
        e=aux.dados;
        aux2.prox=null;        
        return e;
    }
    
    public void percorre(){
        String g="";
        if(vazia()){
            System.out.println("Fila Vazia");
        }else{
            No aux=inicio;
            while(aux.prox!=null){                
                g+=aux.dados+" - ";
                aux=aux.prox;
            }
            g+=aux.dados;
            System.out.println(g+"\n");
        }
    }
}
