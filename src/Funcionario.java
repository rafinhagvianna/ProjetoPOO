/*
Rafael de Godoy Vianna
R.A: 2649160
*/

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario() {}
    // Sobrecarga
    public Funcionario(String nome, String cpf, Endereco endereco,
                       String cargo, double salario)
        throws SalarioInvalidoException {
        super(nome, cpf, endereco);
        if (salario < 0)
            throw new SalarioInvalidoException("Salário não pode ser negativo");
        this.cargo   = cargo;
        this.salario = salario;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) throws SalarioInvalidoException {
        if (salario < 0)
            throw new SalarioInvalidoException("Salário não pode ser negativo");
        this.salario = salario;
    }

    @Override
    public String getDados() {
        return super.getDados()
             + ", Cargo: " + cargo
             + ", Salário: R$" + salario;
    }

    public double calcularSalario() {
        return salario;
    }
}