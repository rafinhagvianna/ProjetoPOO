/*
Rafael de Godoy Vianna
R.A: 2649160
*/

public class Endereco {
    private String rua;
    private int numero;

    public Endereco() {}
    public Endereco(String rua, int numero) {
        this.rua    = rua;
        this.numero = numero;
    }

    public String getRua() { return rua; }
    public int getNumero() { return numero; }
}