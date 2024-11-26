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
import net.miginfocom.swing.MigLayout;

public class JPanel_consultaAutomoveis extends JPanel {

    private static final long serialVersionUID = 1L;
    private JComboBox<String> comboMarca;
    private JScrollPane scrollPane;
    private JTable tabela;
    private final JComboBox<String> comboModelo = new JComboBox<String>();
    private final JComboBox<String> comboAno = new JComboBox<String>();
    private final JLabel lblNewLabel = new JLabel("Consultar Automóveis");

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

        this.tabela = new JTable();
        this.tabela.setModel(new DefaultTableModel(
                new Object[][] { { null, null, null, null, null, null }, },
                new String[] { "id", "marca", "modelo", "ano", "cor", "combustivel" }));
        this.scrollPane.setViewportView(this.tabela);
        setLayout(new MigLayout("", "[70.00,grow][154.00px][17px][210.00px][18px][181px][grow]", "[grow][25px][37px][226.00px][grow]"));
        add(comboMarca, "cell 1 2,grow");
        add(comboModelo, "cell 3 2,grow");
        add(comboAno, "cell 5 2,alignx left,growy");
        add(scrollPane, "cell 1 3 5 1,grow");
        add(lblNewLabel, "cell 3 1,alignx center,growy");
    }
}
