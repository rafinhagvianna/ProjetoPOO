/*
Rafael de Godoy Vianna
R.A: 2649160
*/

import javax.swing.*;
import java.awt.*;

public class FormFuncionario extends JFrame {
    //MÉTODO SINGLETON
    private static FormFuncionario instancia;
    public static FormFuncionario getInstancia() {
        if (instancia == null) instancia = new FormFuncionario();
        return instancia;
    }

    private JTextField tfNome, tfCpf, tfRua, tfNum, tfSalario;
    private JComboBox<String> cbCargo;
    private JButton btSalvar, btBuscar, btExcluir, btLimpar;

    private FormFuncionario() {
        setTitle("Cadastro de Funcionário");
        setSize(400,350);
        setLayout(new GridLayout(8,2,5,5));

        add(new JLabel("Nome:"));    tfNome   = new JTextField(); add(tfNome);
        add(new JLabel("CPF:"));     tfCpf    = new JTextField(); add(tfCpf);
        add(new JLabel("Rua:"));     tfRua    = new JTextField(); add(tfRua);
        add(new JLabel("Número:"));  tfNum    = new JTextField(); add(tfNum);
        add(new JLabel("Cargo:"));   cbCargo  = new JComboBox<>(new String[]{"Atendente","Caixa","Farmacêutico"}); add(cbCargo);
        add(new JLabel("Salário:")); tfSalario= new JTextField(); add(tfSalario);

        btSalvar  = new JButton("Salvar");
        btBuscar  = new JButton("Buscar");
        btExcluir = new JButton("Excluir");
        btLimpar  = new JButton("Limpar");
        add(btSalvar);
        add(btBuscar);
        add(btExcluir);
        add(btLimpar);

        btSalvar.addActionListener(e -> {
            try {
                Funcionario f = new Funcionario(
                    tfNome.getText(),
                    tfCpf.getText(),
                    new Endereco(tfRua.getText(), Integer.parseInt(tfNum.getText())),
                    cbCargo.getSelectedItem().toString(),
                    Double.parseDouble(tfSalario.getText())
                );
                BDFuncionario bd = BDFuncionario.getInstancia();
                if (bd.consultar(f.getCpf()) == null) {
                    bd.inserir(f);
                    JOptionPane.showMessageDialog(this, "Funcionário inserido");
                } else {
                    bd.atualizar(f);
                    JOptionPane.showMessageDialog(this, "Funcionário atualizado");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número/salário inválido");
            } catch (SalarioInvalidoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btBuscar.addActionListener(e -> {
            Funcionario f = BDFuncionario.getInstancia().consultar(tfCpf.getText());
            if (f == null) {
                JOptionPane.showMessageDialog(this, "Não encontrado");
            } else {
                tfNome.setText(f.getNome());
                tfRua.setText(f.getEndereco().getRua());
                tfNum.setText("" + f.getEndereco().getNumero());
                cbCargo.setSelectedItem(f.getCargo());
                tfSalario.setText("" + f.getSalario());
            }
        });

        btExcluir.addActionListener(e -> {
            if (BDFuncionario.getInstancia().excluir(tfCpf.getText()))
                JOptionPane.showMessageDialog(this, "Excluído");
            else
                JOptionPane.showMessageDialog(this, "Não encontrado");
        });

        btLimpar.addActionListener(e -> {
            tfNome.setText("");
            tfCpf.setText("");
            tfRua.setText("");
            tfNum.setText("");
            cbCargo.setSelectedIndex(0);
            tfSalario.setText("");
        });
    }
}