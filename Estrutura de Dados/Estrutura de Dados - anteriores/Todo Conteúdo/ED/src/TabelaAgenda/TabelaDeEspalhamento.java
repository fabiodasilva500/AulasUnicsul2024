package TabelaAgenda;

/**
 *
 * @author Rodrigo Pereira
 */
public class TabelaDeEspalhamento {

    private ListaContatos lista[];

    public TabelaDeEspalhamento(){

        lista = new ListaContatos[26];
    }

    public int funcaoEspalhamentoEspalhamento(char letra){

        int a = Character.toLowerCase(letra)-97;
        return a;

    }

    public void adiciona(Contato novo){

        char letra = novo.getNome().charAt(0);
        int  indice = funcaoEspalhamentoEspalhamento(letra);
        if(lista[indice]==null)
            lista[indice]= new ListaContatos();
         lista[indice].adiciona(novo);
    }

    public Contato remove(String nome){
        char letra = nome.charAt(0);
        int indice = funcaoEspalhamentoEspalhamento(letra);
        if(lista[indice]==null){
            System.out.println("Não há Lista para Este Contato");
            return null;
        }
        return lista[indice].remove(nome);

    }
    
    public String percorre(){
        
        String r="";
        for(int i=0; i<lista.length; i++)
            if(lista[i] != null)
                r = r+lista[i].percorre()+"\n";
        
        return r;
    }


}
