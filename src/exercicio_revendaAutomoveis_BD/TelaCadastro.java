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
	private JTextField cor;
	private JTextField combustivel;
	private JButton botao;

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
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);

		this.lblNewLabel = new JLabel("<html><h1>Inserir Funcion\u00E1rios</h1></html>");

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
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(129)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(118).addComponent(this.lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(this.lblNewLabel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(this.lblNewLabel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(this.lblNewLabel_3, Alignment.TRAILING,
												GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(this.ano,
														GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING,
												gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(this.marca, GroupLayout.PREFERRED_SIZE,
																		334, GroupLayout.PREFERRED_SIZE)
																.addComponent(this.modelo, GroupLayout.PREFERRED_SIZE,
																		334, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(207).addComponent(this.botao)))
				.addContainerGap(183, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(45).addComponent(this.lblNewLabel).addGap(63)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(this.lblNewLabel_1).addComponent(this.marca, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(this.modelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(this.lblNewLabel_2))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(this.lblNewLabel_3).addComponent(this.ano, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(50).addComponent(this.botao).addContainerGap(79, Short.MAX_VALUE)));
		this.contentPane.setLayout(gl_contentPane);
	}
}
