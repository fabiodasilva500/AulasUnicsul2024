package Agenda;

/**
 *
 * @author Rodrigo Pereira
 */
public class TabelaEsp {


private Lista ls[];

 public TabelaEsp(){
     ls = new Lista[26];
 }


  public int indice(char e){
      int ind;
       ind = (Character.toLowerCase(e)-97);
      return ind;
  }

  public void funcaoEspalhamento(){

  }

  public void adicionar(Agenda e){

      int indice = indice(e.getNome().charAt(0));
      if(ls[indice]==null)
          ls[indice] = new Lista();
      ls[indice].adiciona(e);
  }


  public void remover(String nome){
     Agenda e = null;
      int indice = indice(nome.charAt(0));
      if(ls[indice]==null)
       System.out.println("Não existe dados com esse letra inicial "+nome.substring(0,1));
      else
          ls[indice].remover(nome);
       
  }//Fim do método

  public void percorrer(){

      for(int i=0;i<ls.length;i++)
          ls[i].percorrer();
  }


}//Fim da Classe
