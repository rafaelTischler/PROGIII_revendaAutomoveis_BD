package exercicio_revendaAutomoveis_BD;

import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

public class JPanel_consultaAutomoveis extends JPanel {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> comboMarca;
    private JScrollPane scrollPane;
    private JTable tabela;
    private final JComboBox<String> comboModelo = new JComboBox<String>();
    private final JComboBox<String> comboAno = new JComboBox<String>();
    private final JLabel lblNewLabel = new JLabel("Consultar automóveis");

    public JPanel_consultaAutomoveis() {
        this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        this.comboAno.setModel(new DefaultComboBoxModel<>(new String[] { "Selecione um ano de fabricação:" }));
        this.comboModelo.setModel(new DefaultComboBoxModel<>(new String[] { "Selecione um modelo:" }));
        initComponents();
        preencherComboMarcas();
    }

    private void preencherComboMarcas() {
        AutomovelDAO dao = new AutomovelDAO();
        LinkedList<String> marcas = dao.listarMarcas();
        for (String marca : marcas) {
            comboMarca.addItem(marca);
        }
    }

    private void acaoCombo() {
        AutomovelDAO dao = new AutomovelDAO();
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        LinkedList<Automovel> automoveis = dao.listar();
        model.setRowCount(0);
        if (!comboMarca.getSelectedItem().equals("Selecione uma marca: ")) {
            String marcaSelecionada = comboMarca.getSelectedItem().toString();
            for (Automovel auto : automoveis) {
                if (auto.getMarca().equals(marcaSelecionada)) {
                    model.addRow(new String[] { auto.getId() + "", auto.getMarca(), auto.getModelo(), auto.getAno(),
                            auto.getCor(), auto.getCombustivel() });
                }
            }
        }
    }

    private void initComponents() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBounds(100, 100, 800, 600);

        this.comboMarca = new JComboBox<>();
        comboMarca.setModel(new DefaultComboBoxModel<>(new String[] { "Selecione uma marca:" }));
        this.comboMarca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acaoCombo();
            }
        });

        this.scrollPane = new JScrollPane();

        GroupLayout layout = new GroupLayout(this);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(47)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(comboMarca, GroupLayout.PREFERRED_SIZE, 139,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(30)
                                                .addComponent(this.comboModelo, GroupLayout.PREFERRED_SIZE, 180,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(18).addComponent(this.comboAno, 0, GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 548,
                                                GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup().addGap(203).addComponent(this.lblNewLabel,
                                GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(78, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup().addContainerGap(58, Short.MAX_VALUE).addComponent(this.lblNewLabel)
                        .addGap(18)
                        .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(comboMarca, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                .addComponent(this.comboModelo, GroupLayout.PREFERRED_SIZE, 33,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(this.comboAno, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                        .addGap(18).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                        .addGap(78)));

        this.tabela = new JTable();
        this.tabela.setModel(new DefaultTableModel(
                new Object[][] { { null, null, null, null, null, null }, },
                new String[] { "id", "marca", "modelo", "ano", "cor", "combustivel" }));
        this.scrollPane.setViewportView(this.tabela);
        this.setLayout(layout);
    }
}
