package Lista;

/**
 *
 * @author Rodrigo Pereira
 */
public class ListaEstatica {
    private int lista[];
    private int tamanho;
    
    public ListaEstatica(){
        lista=new int[10];
        tamanho=0;
    }
    
    public boolean vazia(){
        if(tamanho==0){
            return true;
        }return false;
    }
    
    public boolean cheia(){
        if(tamanho==lista.length){
            return true;
        }return false;
    }
    
    public void adicionaInicio(int e){
        if(cheia()){
            System.out.println("Lista Cheia!");
        }else if(vazia()){
            adicionaFinal(e);
        }else{       
            for(int i=tamanho; i>0; i--){
                lista[i]=lista[i-1];
            }        
            lista[0]=e;
            tamanho++;
        }
    }
    
    public void adicionaFinal(int e){
        if(cheia()){
            System.out.println("Lista Cheia!");
        }else{
            lista[tamanho]=e;
            tamanho++;
        }
    }
    
    public int removeInicio(){
        int e=-1;
        
        if(vazia()){
            System.out.println("Lista Vazia!");
            return e;
        }
        e=lista[0];
        
        for(int i=0;i<tamanho-1;i++){
            lista[i]=lista[i+1];
        }
        
        tamanho--;        
        return e;        
    }
    
    public int removeFinal(){
        int e=-1;
        
        if(vazia()){
            System.out.println("Lista Vazia!");
            return e;
        }
        
        e=lista[tamanho-1];
        tamanho--;
        return e;
    }
    
    public void escolheLugar(int e, int pos){
        if(cheia()){
            System.out.println("Lista Cheia!");
        }else if(pos-1>tamanho){
            System.out.println("Posição Inválida!");
        }else{
            for (int i=tamanho;i>pos-1;i--){
                lista[i]=lista[i-1];
            }
            lista[pos-1]=e;
            tamanho ++;
        }
    }
    
    public int escolheRemove(int pos){
        int e=-1;
        
        if(vazia()){
            System.out.println("Lista Vazia!");
        }else if (pos>tamanho){
            System.out.println("Posição Inválida");
        }else{
            e=lista[pos-1];
            for(int i=pos-1;i<tamanho-1;i++){  // LAÇO VAI ATÉ TAMANHO-1 E NÃO ATÉ TAMANHO
                lista[i]=lista[i+1];                
            }
            tamanho--; /*DECREMENTO DE TAMANHO PASSA A ESTAR DENTRO DO ELSE IF. 
            ANTES, MESMO QUANDO DAVA POSIÇÃO INVALIDA, ELE FAZIA O TAMANHO--, E
            DESSA FORMA SE PERDIA O ITEM DO FIM DA LISTA.             
             */
        }
        
        
        return e;
    }
    
    public void percorre(){
        String g="";
        if(vazia()){
            System.out.println("Lista Vazia!");
        }else{
            for(int i=0; i<tamanho; i++){
                g+=lista[i]+" - ";
            }
            System.out.println(g+"\n");
        }
    }
    
    
    
}
