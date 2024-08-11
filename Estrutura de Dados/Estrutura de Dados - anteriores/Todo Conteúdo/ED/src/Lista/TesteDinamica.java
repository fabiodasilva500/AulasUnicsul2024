package Lista;
import javax.swing.JOptionPane;
/**
 *
 * @author Rodrigo Pereira
 */
public class TesteDinamica {
    
    public static void main(String[] args) {
        int opc=0, e, pos;
        ListaDinamica lista = new ListaDinamica();
    
        while(opc!=9){
            opc=Integer.parseInt(JOptionPane.showInputDialog("Menu:\n1-Adiciona Inicio"
                    + "\n2-Adiciona Final"
                    + "\n3-Remover Inicio"
                    + "\n4-RemoverFinal"
                    + "\n5-Escolhe Adiciona"
                    + "\n6-Escolhe Remove"
                    + "\n7-Percorre"
                    + "\n9-Sair"));
            switch(opc){
                case 1:
                    e=Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro:"));
                    lista.adicionaInicio(e);
                    break;
                    
                case 2:
                    e=Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro:"));
                    lista.adicionaFinal(e);
                    break;
                    
                case 3:
                    e=lista.removeInicio();
                    JOptionPane.showMessageDialog(null,"O numero removido foi :"+e);
                    break;
                    
                case 4:
                    e=lista.removeFinal();
                    JOptionPane.showMessageDialog(null,"O numero removido foi :"+e);
                    break;
                    
                case 5:
                    e=Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro:"));
                    pos=Integer.parseInt(JOptionPane.showInputDialog("Digite a posição:"));
                    lista.escolhePosicao(e, pos);
                    break;
                    
                case 6:
                    pos=Integer.parseInt(JOptionPane.showInputDialog("Digite a posição:"));
                    e=lista.escolheRemove(pos);
                    JOptionPane.showMessageDialog(null,"O numero removido foi : "+e);
                    break;
                                    
                case 7:
                    lista.percorre();
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
