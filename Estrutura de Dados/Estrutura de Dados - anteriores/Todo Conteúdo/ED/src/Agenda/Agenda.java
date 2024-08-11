package Agenda;

/**
 *
 * @author Rodrigo Pereira
 */
public class Agenda {


    private String nome;
    private String num;

    public Agenda(String nome, String num) {
        this.nome = nome;
        this.num = num;
    }

    public String getNome() {
        return nome;
    }

    public String getNum() {
        return num;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNum(String num) {
        this.num = num;
    }


}
