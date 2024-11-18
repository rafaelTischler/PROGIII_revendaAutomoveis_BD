package exercicio_revendaAutomoveis_BD;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class JPanel_cadastroAutomoveis extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JTextField marca;
    private JTextField modelo;
    private JTextField ano;
    private JButton botao;
    private final JTextField cor = new JTextField();
    private final JTextField comb = new JTextField();
    private final JLabel lblNewLabel_3_1 = new JLabel("Cor:");
    private final JLabel lblNewLabel_3_1_1 = new JLabel("Combustível");
    private JLabel lblNewLabel_4;

    public JPanel_cadastroAutomoveis() {
        this.comb.setColumns(10);
        this.cor.setColumns(10);
        initComponents();
    }

    private void acaoBotao() {
        Automovel f = new Automovel(marca.getText(), modelo.getText(), ano.getText(), cor.getText(),
                comb.getText());
        AutomovelDAO dao = new AutomovelDAO();
        if (!dao.inserir(f)) {
            JOptionPane.showMessageDialog(null, "Inserido");
        }
    }

    private void initComponents() {
        setBorder(new EmptyBorder(5, 5, 5, 5));

        this.lblNewLabel = new JLabel("<html><h1>Inserir Automóvel</h1></html>");

        this.lblNewLabel_1 = new JLabel("Marca:");
        this.lblNewLabel_2 = new JLabel("Modelo:");
        this.lblNewLabel_3 = new JLabel("Ano:");

        this.marca = new JTextField();
        this.marca.setColumns(10);

        this.modelo = new JTextField();
        this.modelo.setColumns(10);

        this.ano = new JTextField();
        this.ano.setColumns(10);

        this.botao = new JButton("Inserir");
        this.botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                acaoBotao();
            }
        });

        setLayout(new MigLayout("", "[grow][85px][200.00][41.00][grow]",
                "[grow][49px][20px][20px][20px][20px][20px][23px][grow]"));

        add(lblNewLabel, "cell 1 1 2 1,alignx center,growy");
        add(lblNewLabel_1, "cell 1 2,alignx right,aligny center");
        add(lblNewLabel_2, "cell 1 3,alignx right,aligny center");
        add(lblNewLabel_3, "cell 1 5,alignx right,aligny center");
        add(lblNewLabel_3_1_1, "cell 1 4,alignx right,aligny bottom");

        add(marca, "cell 2 2,growx,aligny top");
        add(modelo, "cell 2 3,growx,aligny top");
        add(ano, "flowx,cell 2 5,growx,aligny top");
        
        lblNewLabel_4 = new JLabel("Cor:");
        add(lblNewLabel_4, "cell 2 5");
        add(cor, "cell 2 5,growx,aligny top");
        add(comb, "cell 2 4,growx,aligny top");

        add(botao, "cell 2 7,alignx center,aligny top");
    }
}
