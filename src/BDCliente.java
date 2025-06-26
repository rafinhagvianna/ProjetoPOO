/*
Rafael de Godoy Vianna
R.A: 2649160
*/

import java.util.ArrayList;

public class BDCliente {
    //MÉTODO SINGLETON
    private static BDCliente instancia; 
    private ArrayList<Cliente> lista = new ArrayList<>();

    private BDCliente() {}
    public static BDCliente getInstancia() {
        if (instancia == null) instancia = new BDCliente();
        return instancia;
    }

    
    public void inserir(Cliente c) { lista.add(c); }

    public Cliente consultar(String cpf) {
        for (Cliente c : lista)
            if (c.getCpf().equals(cpf)) return c;
        return null;
    }

    public boolean atualizar(Cliente novo) {
        Cliente old = consultar(novo.getCpf());
        if (old == null) return false;
       
        old.setCidade(novo.getCidade());
     
        old.setEmail(novo.getEmail());
        return true;
    }

    public boolean excluir(String cpf) {
        Cliente c = consultar(cpf);
        if (c == null) return false;
        return lista.remove(c);
    }

    public ArrayList<Cliente> listar() { return lista; }
}