package AgendaTele;

/**
 *
 * @author Rodrigo Pereira
 */
public class Agenda {

    private String nome;
    private String tel;

    public Agenda(String nome, String tel) {
        this.nome = nome;
        this.tel = tel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }



}
