package Exercicio3;
/**
 *
 * @author Fabio
 */
import javax.swing.JOptionPane;
public class TesteDasClasses {
	public static void main(String[]args){
		ListaLigada l=new ListaLigada();
		int op=0,pos=0; 
		double dado = 0;
		Aluno aluno;

		while(op!=99){
			op=Integer.parseInt(JOptionPane.showInputDialog("Lista de Alunos\n1-Adiciona Final\n2-Adiciona In�cio\n3-Adiciona Posi��o\n4-Remove Final\n5-Remove In�cio\n6-Remove Posi��o\n7-Exibir\n99-Sair"));
			switch(op){
			case 1:
				aluno = new Aluno();
				aluno.setRA(Integer.parseInt(JOptionPane.showInputDialog("Informe o RA aluno")));
				aluno.setNome(JOptionPane.showInputDialog("Informe o nome do aluno"));
				aluno.setSemestre(JOptionPane.showInputDialog("Informe o semestre"));
				aluno.setTurma(JOptionPane.showInputDialog("Informe a turma"));				
				l.AdicionaFinal(aluno);
				break;
			case 2:
				aluno = new Aluno();
				aluno.setRA(Integer.parseInt(JOptionPane.showInputDialog("Informe o RA aluno")));
				aluno.setNome(JOptionPane.showInputDialog("Informe o nome do aluno"));
				aluno.setSemestre(JOptionPane.showInputDialog("Informe o semestre"));
				aluno.setTurma(JOptionPane.showInputDialog("Informe a turma"));				
				l.AdicionaInicio(aluno);
				break;
			case 3:
				aluno = new Aluno();
				aluno.setRA(Integer.parseInt(JOptionPane.showInputDialog("Informe o RA aluno")));
				aluno.setNome(JOptionPane.showInputDialog("Informe o nome do aluno"));
				aluno.setSemestre(JOptionPane.showInputDialog("Informe o semestre"));
				aluno.setTurma(JOptionPane.showInputDialog("Informe a turma"));				
				pos = Integer.parseInt(JOptionPane.showInputDialog("Informe a posi��o"));
				l.escolhePosicao(aluno, pos);
				break;
			case 4:
				aluno = new Aluno();
				aluno = l.RemoveFinal();
				JOptionPane.showMessageDialog(null,"O aluno removido foi:\nRA:"+aluno.getRA()+
						"\nNome:"+aluno.getNome()+"\nSemestre:"+aluno.getSemestre()+" \nTurma:"+aluno.getTurma()); 
				break;
			case 5:
				aluno = new Aluno();
				aluno = l.RemoveInicio();
				JOptionPane.showMessageDialog(null,"O aluno removido foi:\nRA:"+aluno.getRA()+
						"\nNome:"+aluno.getNome()+"\nSemestre:"+aluno.getSemestre()+" \nTurma:"+aluno.getTurma()); 
				break;
			case 6:
				pos = Integer.parseInt(JOptionPane.showInputDialog("Informe a posi��o"));
				aluno = new Aluno();
				aluno = l.escolheRemove(pos);
				JOptionPane.showMessageDialog(null,"O aluno removido foi:\nRA:"+aluno.getRA()+
				"\nNome:"+aluno.getNome()+"\nSemestre:"+aluno.getSemestre()+" \nTurma:"+aluno.getTurma()); 
				break;
			case 7:
				JOptionPane.showMessageDialog(null,"Lista:"+l.percorre());
				break;
			case 99:
				JOptionPane.showMessageDialog(null,"Saindo");
				break;
			default:
				JOptionPane.showMessageDialog(null,"Valor inv�lido");
			}
		}

	}
}
