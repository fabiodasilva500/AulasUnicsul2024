package Lista;

/**
 *
 * @author Rodrigo Pereira
 */
public class ListaDinamica {
    private No inicio;
    
    public ListaDinamica(){
        inicio=null;
    }
    
    public boolean vazia(){
        if(inicio==null){
            return true;
        }return false;
    }
    
    public void adicionaInicio(int e){
        No novo = new No(e);
        novo.prox=inicio;
        inicio=novo;        
    }
    
    public void adicionaFinal(int e){
        No novo = new No(e);
        No aux=inicio;
        
        if(vazia()){
            adicionaInicio(e);
        }else{
            while(aux.prox!=null){
              aux=aux.prox;  
            }
            aux.prox=novo;
        }
        
        
    }
    
    public int removeInicio(){
        int e=-1;
        
        if(vazia()){
            System.out.println("Lista Vazia!");
            return e;
        }
        
        e=inicio.dados;
        inicio=inicio.prox;
        
        return e;
    }
    
    public int removeFinal(){
        int e=-1;
        No aux=inicio;
        No aux2=inicio;
        
        if(vazia()){
            System.out.println("Lista Vazia!");
            return e;
        }
        
        if(inicio.prox==null){
            e=inicio.dados;
            inicio=null;
            return e;
        }
        
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
        No aux=inicio;
        int r=0;

        while(aux.prox!=null){
            r=aux.dados;
            g+=r+" - ";
            aux=aux.prox;
        }

        r=aux.dados;
        g+=r;
        System.out.println(g+"\n");

    }
    
    public void escolhePosicao(int e, int pos){
        No novo= new No(e);

        if(pos==1){  /*CONDIÇÃO DO COMEÇO DO MÉTODO MUDOU, TENDO EM VISTA QUE
             SEMPRE QUE A POSIÇÃO FOR 1, O ITEM SERÁ ADICIONADO NO INICIO DA LISTA,
             NÃO IMPORTANDO SE A MESMA SE ENCONTRA VAZIA OU NÃO*/            
            adicionaInicio(e);
        }else{       
            No aux=inicio;
            int count=1;
            
            while(aux.prox!=null && count<pos-1){
                aux=aux.prox;
                count++;
            }
            
            if(count==pos-1){  /*A CONSIÇÃO PARA SE SABER SE É POSSIVEL ADICIONAR
               O ITEM NA POSIÇÃO DESEJADA PASSOU A SER FORA DO LAÇO */
                novo.prox=aux.prox;
                aux.prox=novo;
            }else{
                System.out.println("Posição Inválida!");
            }            
        }
    }
    
    public int escolheRemove(int pos){
        int e=-1;
        int i=1;
        No aux=inicio;
        
        
        if(vazia()){
            System.out.println("Lista Vazia!");
            return e;
        }    
        if(pos==1){// NOVA CONDIÇÃO. TODA VEZ QUE A POS FOR 1, O ITEM REMOVIDO SERÁ O PRIMEIRO
            e=removeInicio();
            return e;
        }else{           
            while(aux.prox!=null){
                aux=aux.prox;
                i++;
            }
            if(pos>i){
                System.out.println("Posição Invalida!");
                return e;
            }else if(pos==i){
                e=removeFinal();
                return e;
            }else{
                aux=inicio;
                No aux2=aux;
                
                while(pos>1){
                    aux2=aux;
                    aux=aux.prox;
                    pos--;
                }
                e=aux.dados;
                aux2.prox=aux.prox;
                return e;
            }
        }        
    }
    
    
}
