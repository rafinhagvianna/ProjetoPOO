/*
Rafael de Godoy Vianna
R.A: 2649160
*/


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormRelatorioClientes extends JFrame {
    //MÉTODO SINGLETON
    private static FormRelatorioClientes instancia;
    public static FormRelatorioClientes getInstancia() {
        if (instancia == null) instancia = new FormRelatorioClientes();
        return instancia;
    }

    private JTable table;

    private FormRelatorioClientes() {
        setTitle("Relatório de Clientes");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        String[] colunas = {"Nome", "CPF", "Cidade", "Email", "Compras"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Cliente c : BDCliente.getInstancia().listar()) {
            StringBuilder sb = new StringBuilder();
            for (Compra cp : c.getCompras()) {
                sb.append(cp.getNomeItem())
                  .append(" x")
                  .append(cp.getQuantidade())
                  .append("; ");
            }
            String comprasStr = sb.toString().trim();
            if (comprasStr.endsWith(";")) {
                comprasStr = comprasStr.substring(0, comprasStr.length() - 1);
            }

            model.addRow(new Object[]{
                c.getNome(),
                c.getCpf(),
                c.getCidade(),
                c.getEmail(),
                comprasStr
            });
        }

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}