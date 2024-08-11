package tabelaEspalhamento;
import java.awt.Color;

/**
 *
 * @author Rodrigo Pereira
 */
public class Eletronico {

    private int cod;
    private String tipo;
    private String capacidade;
    private Color cor;
    private boolean status;

    public Eletronico(int cod, String tipo, String capacidade, Color cor, boolean status) {
        this.cod = cod;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.cor = cor;
        this.status = status;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEletronico(){

      return "Código: " + cod + "Tipo: " + tipo + "Capacidade: " + capacidade  + "Cor: "+ cor + "Status: "+ status;
    }


}//Fim da Classe Eletronico
