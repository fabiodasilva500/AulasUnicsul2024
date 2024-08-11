package Fila;
import javax.swing.JOptionPane;
/**
 *
 * @author Rodrigo Pereira
 */
public class TesteEstatica {
    
    public static void main(String[] args) {
        int opc=0, e, pos;
        FilaEstatica fila = new FilaEstatica();
    
        while(opc!=9){
            opc=Integer.parseInt(JOptionPane.showInputDialog("Menu:\n1-Adiciona"
                    + "\n2-Remove"
                    + "\n3-Percorre"
                    + "\n9-Sair"));
            
            switch(opc){
                case 1:
                    e=Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro:"));
                    fila.adiciona(e);
                    break;
                    
              
                case 2:
                    e=fila.remove();
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
