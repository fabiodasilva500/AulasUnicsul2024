package Pilha;

/**
 *
 * @author Rodrigo Pereira
 */
public class PilhaEstatica {
    private int pilha[];
    private int tamanho;
    
    public PilhaEstatica(){
        pilha=new int[10];
        tamanho=0;
    }
    
    public boolean vazia(){
        if(tamanho==0){
            return true;
        }return false;
    }
    
    public boolean cheia(){
        if(tamanho==pilha.length){
            return true;
        }return false;
    }
    
    public void adiciona(int e){
        if(cheia()){
            System.out.println("Lista Cheia!");
        }else{       
            pilha[tamanho]=e;
            tamanho++;    
        }
    }
    
    public int remove(){
        int e=-1;
        
        if(vazia()){
            System.out.println("Pilha Vazia!");
            return e;
        }
        e=pilha[tamanho-1];
        tamanho--;
        
        return e;        
    }
    
    public void percorre(){
        String g="";
        if(vazia()){
            System.out.println("Lista Vazia!");
        }else{
            for(int i=0;i<tamanho;i++){
                g+=pilha[i]+" - ";
            }
            System.out.println(g+"\n");
        }
    }
    
}
