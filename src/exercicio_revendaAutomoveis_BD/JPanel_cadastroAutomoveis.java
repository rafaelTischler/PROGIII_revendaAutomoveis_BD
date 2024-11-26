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
import java.awt.Color;
import java.awt.Panel;
import java.awt.Font;

public class JPanel_cadastroAutomoveis extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("cadastroAutomoveis");
	private final JLabel lblNewLabel_1 = new JLabel("Marca:");
	private final JLabel lblNewLabel_2 = new JLabel("Modelo:");
	private final JLabel lblNewLabel_3 = new JLabel("Ano:");
	private final JLabel lblNewLabel_4 = new JLabel("Cor:");
	private final JLabel lblNewLabel_5 = new JLabel("Combustível:");
	private final JTextField edit_marca = new JTextField();
	private final JTextField edit_modelo = new JTextField();
	private final JTextField edit_ano = new JTextField();
	private final JTextField edit_cor = new JTextField();
	private final JTextField edit_combustivel = new JTextField();

	public JPanel_cadastroAutomoveis() {
		this.edit_combustivel.setColumns(10);
		this.edit_cor.setColumns(10);
		this.edit_ano.setColumns(10);
		this.edit_modelo.setColumns(10);
		this.edit_marca.setColumns(10);
		initComponents();
	}

	private void initComponents() {
		setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 800, 600);
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		add(this.panel, "cell 1 1,grow");
		this.panel.setLayout(new MigLayout("", "[grow][][grow][grow]", "[grow][][][][][][][][grow]"));
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.panel.add(this.lblNewLabel, "cell 1 1");
		this.panel.add(this.lblNewLabel_1, "cell 1 3,alignx trailing");
		this.panel.add(this.edit_marca, "cell 2 3,growx");
		this.panel.add(this.lblNewLabel_2, "cell 1 4,alignx trailing");
		this.panel.add(this.edit_modelo, "cell 2 4,growx");
		this.panel.add(this.lblNewLabel_3, "cell 1 5,alignx trailing");
		this.panel.add(this.edit_ano, "cell 2 5,growx");
		this.panel.add(this.lblNewLabel_4, "cell 1 6,alignx trailing");
		this.panel.add(this.edit_cor, "cell 2 6,growx");
		this.panel.add(this.lblNewLabel_5, "cell 1 7,alignx trailing,aligny center");
		this.panel.add(this.edit_combustivel, "cell 2 7,growx");
	}
}
