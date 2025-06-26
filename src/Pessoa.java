/*
Rafael de Godoy Vianna
R.A: 2649160
*/

public class Pessoa implements Operacoes {
    protected String nome;
    protected String cpf;
    protected Endereco endereco;

    public Pessoa() {}
    public Pessoa(String nome, String cpf, Endereco endereco) {
        this.nome     = nome;
        this.cpf      = cpf;
        this.endereco = endereco;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public Endereco getEndereco() { return endereco; }

    @Override
    public String getDados() {
        return "Nome: " + nome + ", CPF: " + cpf;
    }
    @Override
    public void exibirResumo() {
        System.out.println(getDados());
    }
}