package Exercicio3;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabio
 */
public class ListaLigada {
	private NO inicio;

	public ListaLigada(){
		inicio=null;
	}

	public void AdicionaFinal(Aluno a){
		if (inicio==null){
			NO n=new NO(a);
			inicio=n;
		}
		else{
			NO aux=inicio;
			while(aux.prox!=null){
				aux=aux.prox;
			}
			NO n=new NO(a);
			aux.prox=n;
		}
	}

	public void AdicionaInicio(Aluno a){
		NO n=new NO(a);
		n.prox=inicio;
		inicio=n;
	}

	public Aluno RemoveFinal(){
		Aluno r= new Aluno();
		if (inicio==null){
			JOptionPane.showMessageDialog(null, "Lista V�zia");
		}
		else{
			if (inicio.prox==null){
				r=inicio.aluno;
				inicio=null;
			}
			else{
				NO aux1=inicio;
				NO aux2=inicio;

				while(aux1.prox!=null){
					aux2=aux1;
					aux1=aux1.prox;
				}

				r=aux1.aluno;
				aux2.prox=null;
			}
		}
		return r;
	}

	public Aluno RemoveInicio(){
		Aluno r=new Aluno();
		if (inicio==null){
			JOptionPane.showMessageDialog(null,"Lista V�zia");			
		}
		else{
			r=inicio.aluno;
			inicio=inicio.prox;
		}
		return r;
	}


	public void escolhePosicao(Aluno e, int pos){
		NO novo= new NO(e);

		if(pos==1){  /*CONDI��O DO COME�O DO M�TODO MUDOU, TENDO EM VISTA QUE
	             SEMPRE QUE A POSI��O FOR 1, O ITEM SER� ADICIONADO NO INICIO DA LISTA,
	             N�O IMPORTANDO SE A MESMA SE ENCONTRA VAZIA OU N�O*/            
			AdicionaInicio(e);
		}else{       
			NO aux=inicio;
			int count=1;

			while(aux.prox!=null && count<pos-1){
				aux=aux.prox;
				count++;
			}

			if(count==pos-1){  /*A CONSI��O PARA SE SABER SE � POSSIVEL ADICIONAR
	               O ITEM NA POSI��O DESEJADA PASSOU A SER FORA DO LA�O */
				novo.prox=aux.prox;
				aux.prox=novo;
			}else{
				JOptionPane.showMessageDialog(null,"Posi��o Inv�lida!");
			}            
		}
	}


	public Aluno escolheRemove(int pos){
		Aluno e=new Aluno();
		int i=1;
		NO aux=inicio;

		if(inicio==null){
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
			return e;
		}    
		if(pos==1){// NOVA CONDI��O. TODA VEZ QUE A POS FOR 1, O ITEM REMOVIDO SER� O PRIMEIRO
			e=RemoveInicio();
			return e;
		}else{           
			while(aux.prox!=null){
				aux=aux.prox;
				i++;
			}
			if(pos>i || pos==0){
				JOptionPane.showMessageDialog(null, "Posi��o Invalida!");
				return e;
			}else if(pos==i){
				e=RemoveFinal();
				return e;
			}else{
				aux=inicio;
				NO aux2=aux;

				while(pos>1){
					aux2=aux;
					aux=aux.prox;
					pos--;
				}
				e=aux.aluno;
				aux2.prox=aux.prox;
				return e;
			}
		}        
	}

	public String percorre(){
		NO aux=inicio;
		String aluno = "";
		while(aux!=null){
			aluno+="\nRA:"+aux.aluno.getRA()+" Nome:"+aux.aluno.getNome()+
					"Semestre:"+aux.aluno.getSemestre()+" Turma:"+aux.aluno.getTurma();
			aux=aux.prox;
		}
		return aluno;
	}
}
