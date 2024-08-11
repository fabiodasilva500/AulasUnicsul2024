package Fila;

/**
 *
 * @author Rodrigo Pereira
 */
public class FilaDinamica {
    private No inicio;
    
    public FilaDinamica(){
        inicio=null;
    }
    
    public boolean vazia(){
        if(inicio==null){
            return true;
        }return false;
    }
    
    public void adiciona(int e){
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
    
    public int remove(){
        int e=-1;
        
        if(vazia()){
            System.out.println("Fila Vazia!");
        }else{
            e=inicio.dados;
            inicio=inicio.prox;
        }
        
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
