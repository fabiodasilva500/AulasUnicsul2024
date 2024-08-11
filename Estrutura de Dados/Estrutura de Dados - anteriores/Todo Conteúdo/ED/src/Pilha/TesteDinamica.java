package Pilha;
import javax.swing.JOptionPane;
/**
 *
 * @author Rodrigo Pereira
 */
public class TesteDinamica {
    
    public static void main(String[] args) {
        int opc=0, e, pos;
        PilhaDinamica fila = new PilhaDinamica();
    
        while(opc!=9){
            opc=Integer.parseInt(JOptionPane.showInputDialog("Menu:\n1-Empilha"
                    + "\n2-Desempilha"
                    + "\n3-Percorre"
                    + "\n9-Sair"));
            
            switch(opc){
                case 1:
                    e=Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro:"));
                    fila.empilha(e);
                    break;
                    
              
                case 2:
                    e=fila.desempilha();
                    JOptionPane.showMessageDialog(null,"O numero removido foi :"+e);
                    break;
                    
                       
                case 3:
                    fila.percorre();
                    break;
                
                case 9:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção Inválida");
                    break;
            }
            
            
        }
    
    
    }
    
    
    
    
}
