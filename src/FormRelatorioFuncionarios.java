/*
Rafael de Godoy Vianna
R.A: 2649160
*/

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class FormRelatorioFuncionarios extends JFrame {
    //MÉTODO SINGLETON
    private static FormRelatorioFuncionarios instancia;
    public static FormRelatorioFuncionarios getInstancia() {
        if (instancia == null) instancia = new FormRelatorioFuncionarios();
        return instancia;
    }

    private JTable table;

    private FormRelatorioFuncionarios() {
        setTitle("Relatório de Funcionários");
        setSize(500,300);

        String[] col = {"Nome","CPF","Cargo","Salário"};
        DefaultTableModel model = new DefaultTableModel(col,0);
        for (Funcionario f : BDFuncionario.getInstancia().listar()) {
            model.addRow(new Object[]{
                f.getNome(), f.getCpf(), f.getCargo(), f.getSalario()
            });
        }

        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}