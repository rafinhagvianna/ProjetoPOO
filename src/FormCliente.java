/*
Rafael de Godoy Vianna
R.A: 2649160
*/

import javax.swing.*;
import java.awt.*;

public class FormCliente extends JFrame {
    //MÉTODO SINGLETON
    private static FormCliente instancia;
    public static FormCliente getInstancia() {
        if (instancia == null) instancia = new FormCliente();
        return instancia;
    }

    private JTextField tfNome, tfCpf, tfCidade, tfRua, tfNum, tfEmail;
    private JButton btSalvar, btBuscar, btExcluir, btLimpar;

    private FormCliente() {
        setTitle("Cadastro de Cliente");
        setSize(400,350);
        setLayout(new GridLayout(8,2,5,5));

        add(new JLabel("Nome:"));    tfNome   = new JTextField(); add(tfNome);
        add(new JLabel("CPF:"));     tfCpf    = new JTextField(); add(tfCpf);
        add(new JLabel("Cidade:"));  tfCidade = new JTextField(); add(tfCidade);
        add(new JLabel("Rua:"));     tfRua    = new JTextField(); add(tfRua);
        add(new JLabel("Número:"));  tfNum    = new JTextField(); add(tfNum);
        add(new JLabel("Email:"));   tfEmail  = new JTextField(); add(tfEmail);

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
                Cliente c = new Cliente(
                    tfNome.getText(),
                    tfCpf.getText(),
                    tfCidade.getText(),
                    tfRua.getText(),
                    Integer.parseInt(tfNum.getText()),
                    tfEmail.getText()
                );
                BDCliente bd = BDCliente.getInstancia();
                if (bd.consultar(c.getCpf()) == null) {
                    bd.inserir(c);
                    JOptionPane.showMessageDialog(this, "Cliente inserido");
                } else {
                    bd.atualizar(c);
                    JOptionPane.showMessageDialog(this, "Cliente atualizado");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número inválido");
            }
        });

        btBuscar.addActionListener(e -> {
            Cliente c = BDCliente.getInstancia().consultar(tfCpf.getText());
            if (c == null) {
                JOptionPane.showMessageDialog(this, "Não encontrado");
            } else {
                tfNome.setText(c.getNome());
                tfCidade.setText(c.getCidade());
                tfRua.setText(c.getEndereco().getRua());
                tfNum.setText("" + c.getEndereco().getNumero());
                tfEmail.setText(c.getEmail());
            }
        });

        btExcluir.addActionListener(e -> {
            if (BDCliente.getInstancia().excluir(tfCpf.getText()))
                JOptionPane.showMessageDialog(this, "Excluído");
            else
                JOptionPane.showMessageDialog(this, "Não encontrado");
        });

        btLimpar.addActionListener(e -> {
            tfNome.setText("");
            tfCpf.setText("");
            tfCidade.setText("");
            tfRua.setText("");
            tfNum.setText("");
            tfEmail.setText("");
        });
    }
}