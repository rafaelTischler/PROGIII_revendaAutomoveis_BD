package exercicio_revendaAutomoveis_BD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField marca;
	private JTextField modelo;
	private JTextField ano;
	private JButton botao;
	private JTextField combustivel;
	private JTextField cor;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void acaoBotao() {
		Automovel f = new Automovel(marca.getText(), modelo.getText(), ano.getText(), cor.getText(), combustivel.getText());
		AutomovelDAO dao = new AutomovelDAO();
		if (!dao.inserir(f)) {
			JOptionPane.showMessageDialog(null, "Inserido");
		}
	}

	public TelaCadastro() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 430);
		this.contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);

		this.lblNewLabel = new JLabel("             Inserir Automóvel");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

		this.lblNewLabel_1 = new JLabel("Marca:");

		this.lblNewLabel_2 = new JLabel("Modelo:");

		this.lblNewLabel_3 = new JLabel("Ano:");

		this.marca = new JTextField();
		marca.setBackground(new Color(255, 255, 255));
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
		contentPane.setLayout(new MigLayout("", "[grow][85px][200.00][41.00][grow]", "[grow][49px][20px][20px][20px][20px][20px][23px][grow]"));
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Combustivel:");
		contentPane.add(lblNewLabel_3_1_1, "cell 1 4,alignx right,aligny bottom");
		
		combustivel = new JTextField();
		combustivel.setColumns(10);
		contentPane.add(combustivel, "cell 2 4,growx,aligny top");
		contentPane.add(botao, "cell 2 7,alignx center,aligny top");
		contentPane.add(lblNewLabel, "cell 1 1 2 1,alignx center,growy");
		contentPane.add(lblNewLabel_1, "cell 1 2,alignx right,aligny center");
		contentPane.add(lblNewLabel_3, "cell 1 5,alignx right,aligny center");
		contentPane.add(lblNewLabel_2, "cell 1 3,alignx right,aligny center");
		contentPane.add(ano, "flowx,cell 2 5,growx,aligny top");
		contentPane.add(modelo, "cell 2 3,growx,aligny top");
		contentPane.add(marca, "cell 2 2,growx,aligny top");
		
		JLabel lblNewLabel_3_1 = new JLabel("Cor:");
		contentPane.add(lblNewLabel_3_1, "cell 2 5,alignx right,aligny center");
		
		cor = new JTextField();
		cor.setColumns(10);
		contentPane.add(cor, "cell 2 5,growx,aligny top");
	}
}
