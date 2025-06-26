import java.util.ArrayList;

public class BDFuncionario {
    //MÉTODO SINGLETON
    private static BDFuncionario instancia; 
    private ArrayList<Funcionario> lista = new ArrayList<>();

    private BDFuncionario() {}
    public static BDFuncionario getInstancia() {
        if (instancia == null) instancia = new BDFuncionario();
        return instancia;
    }

    public void inserir(Funcionario f) { lista.add(f); }
    public Funcionario consultar(String cpf) {
        for (Funcionario f : lista)
            if (f.getCpf().equals(cpf)) return f;
        return null;
    }
    public boolean atualizar(Funcionario nf) {
        Funcionario old = consultar(nf.getCpf());
        if (old == null) return false;

        old.setCargo(nf.getCargo());
        try { old.setSalario(nf.getSalario()); } catch (Exception e) {}
        return true;
    }
    public boolean excluir(String cpf) {
        Funcionario f = consultar(cpf);
        if (f == null) return false;
        return lista.remove(f);
    }
    public ArrayList<Funcionario> listar() { return lista; }
}