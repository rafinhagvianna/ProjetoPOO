/*
Rafael de Godoy Vianna
R.A: 2649160

Versão do netBeans:
Product Version: Apache NetBeans IDE 24
*/

import javax.swing.*;

public class FormPrincipal extends JFrame {
    //MÉTODO SINGLETON
    private static FormPrincipal instancia;
    public static FormPrincipal getInstancia() {
        if (instancia == null) instancia = new FormPrincipal();
        return instancia;
    }

    private FormPrincipal() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Sistema Farma");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);

        JMenuBar mb = new JMenuBar();

        JMenu mCad = new JMenu("Cadastros");
        JMenuItem miCli = new JMenuItem("Cliente");
        JMenuItem miFun = new JMenuItem("Funcionário");
        mCad.add(miCli);
        mCad.add(miFun);

        JMenu mComp = new JMenu("Compras");
        JMenuItem miRealizar = new JMenuItem("Realizar Compra");
        mComp.add(miRealizar);

        JMenu mRel = new JMenu("Relatórios");
        JMenuItem miRCli = new JMenuItem("Clientes");
        JMenuItem miRFun = new JMenuItem("Funcionários");
        mRel.add(miRCli);
        mRel.add(miRFun);

        mb.add(mCad);
        mb.add(mComp);
        mb.add(mRel);
        setJMenuBar(mb);

        miCli.addActionListener(e -> FormCliente.getInstancia().setVisible(true));
        miFun.addActionListener(e -> FormFuncionario.getInstancia().setVisible(true));
        miRealizar.addActionListener(e -> FormCompras.getInstancia().setVisible(true));
        miRCli.addActionListener(e -> FormRelatorioClientes.getInstancia().setVisible(true));
        miRFun.addActionListener(e -> FormRelatorioFuncionarios.getInstancia().setVisible(true));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
            FormPrincipal.getInstancia().setVisible(true)
        );
    }
}