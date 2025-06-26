/*
Rafael de Godoy Vianna
R.A: 2649160
*/

import javax.swing.*;
import java.awt.*;

public class FormCompras extends JFrame {
    //MÉTODO SINGLETON
    private static FormCompras instancia;
    public static FormCompras getInstancia() {
        if (instancia == null) instancia = new FormCompras();
        return instancia;
    }

    private JTextField tfNome, tfCpf, tfQtd;
    private JComboBox<String> cbProduto;
    private JButton btAdicionar, btLimpar;

    private FormCompras() {
        setTitle("Realizar Compras");
        setSize(350,250);
        setLayout(new GridLayout(5,2,5,5));

        add(new JLabel("Nome do Cliente:")); tfNome = new JTextField(); add(tfNome);
        add(new JLabel("CPF do Cliente:"));  tfCpf  = new JTextField(); add(tfCpf);

        add(new JLabel("Produto:"));
        cbProduto = new JComboBox<>(new String[]{
            "Dipirona","Neosaldina","Paracetamol","Dorflex","Ibuprofeno"
        });
        add(cbProduto);

        add(new JLabel("Quantidade:")); tfQtd = new JTextField(); add(tfQtd);

        btAdicionar = new JButton("Adicionar Compra");
        btLimpar    = new JButton("Limpar");
        add(btAdicionar); add(btLimpar);

        btAdicionar.addActionListener(e -> {
            String nome = tfNome.getText(), cpf = tfCpf.getText();
            Cliente c = BDCliente.getInstancia().consultar(cpf);
            if (c == null || !c.getNome().equalsIgnoreCase(nome)) {
                JOptionPane.showMessageDialog(this, "Cliente não cadastrado");
                return;
            }
            try {
                int qt = Integer.parseInt(tfQtd.getText());
                c.adicionarCompra(cbProduto.getSelectedItem().toString(), qt);
                JOptionPane.showMessageDialog(this, "Compra adicionada");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Quantidade inválida");
            } catch (CompraInvalidaException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btLimpar.addActionListener(e -> {
            tfNome.setText(""); tfCpf.setText("");
            tfQtd.setText(""); cbProduto.setSelectedIndex(0);
        });
    }
}