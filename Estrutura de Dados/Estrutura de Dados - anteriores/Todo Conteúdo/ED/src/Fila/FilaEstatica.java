package Fila;

/**
 *
 * @author Rodrigo Pereira
 */
public class FilaEstatica {
    private int fila[];
    private int tamanho;
    
    public FilaEstatica(){
        fila= new int[10];
        tamanho=0;
    }
    
    public boolean vazia(){
        if(tamanho==0){
            return true;
        }return false;
    }
    
    public boolean cheia(){
        if(tamanho==fila.length){
            return true;
        }return false;
    }
    
    public void adiciona(int e){
        if(cheia()){
            System.out.println("Fila Cheia!");
        }else{
            fila[tamanho]=e;
            tamanho++;
        }
    }
    
    public int remove(){
        int e=-1;
        
        if(vazia()){
            System.out.println("Fila Vazia!");
            return e;
        }
        e=fila[0];
        
        for(int i=0;i<tamanho-1;i++){
            fila[i]=fila[i+1];
        }
        
        tamanho--;        
        return e;
        
    }
    
    public void percorre(){
        String g="";
        if(vazia()){
            System.out.println("Lista Vazia!");
        }else{
            for(int i=0;i<tamanho;i++){
                g+=fila[i]+" - ";
            }
            System.out.println(g+"\n");
        }
    }
    
    
}
