/*
Rafael de Godoy Vianna
R.A: 2649160
*/

public class Compra {
    private String nomeItem;
    private int quantidade;

    public Compra() {}
    // Sobrecarga
    public Compra(String nomeItem, int quantidade) {
        this.nomeItem   = nomeItem;
        this.quantidade = quantidade;
    }

    public String getNomeItem() { return nomeItem; }
    public int getQuantidade() { return quantidade; }

    @Override
    public String toString() {
        return nomeItem + " (" + quantidade + ")";
    }
}