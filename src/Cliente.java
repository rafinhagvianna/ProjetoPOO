/*
Rafael de Godoy Vianna
R.A: 2649160
*/

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private String cidade;
    private String email;
    private ArrayList<Compra> compras = new ArrayList<>();

    public Cliente() {}
    // Sobrecarga
    public Cliente(String nome, String cpf, String cidade,
                   String rua, int numero, String email) {
        super(nome, cpf, new Endereco(rua, numero));
        this.cidade = cidade;
        this.email  = email;
    }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public ArrayList<Compra> getCompras() { return compras; }

    public void adicionarCompra(String item, int quantidade)
        throws CompraInvalidaException {
        if (item == null || item.isBlank() || quantidade <= 0) {
            throw new CompraInvalidaException(
                "Compra inválida: nome vazio ou quantidade <= 0"
            );
        }
        compras.add(new Compra(item, quantidade));
    }

    @Override
    public String getDados() {
        return super.getDados()
             + ", Cidade: " + cidade
             + ", Email: " + email
             + ", Total compras: " + compras.size();
    }
}