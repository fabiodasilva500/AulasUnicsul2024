package ArvoreBinaria;

import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo Pereira
 */
public class TestArvoreBin {


    public static void main(String[] args) {
        No a = null;
        Arvore ar = new  Arvore();
        int num = 0;
       int op = -1;
     while(op!=0){
       op = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção\n"
               + "(1) Adicionar\n"
               + "(2) Percorrer em Pré Ordem\n"
               + "(3) Percorrer em Em Ordem\n"
               + "(4) Percorrer em Pós Ordem\n"
               + "(5) Sair"));

       switch(op){
           case 1: {
                num = Integer.parseInt(JOptionPane.showInputDialog("Informe um número"));
                ar.adicionaElemento(num);
           }break;
           case 2: {
                ar.preOrdem(a);
           }break;
           case 3:{
                ar.emOrdem(a);
           }break;
           case 4:{
                ar.posOrdem(a);
           }break;
           case 5:{
                op = 0;
                JOptionPane.showMessageDialog(null, "Saindo...");
           }break;
       }

      }
    }


}
