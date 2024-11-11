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

public class TelaInserir extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField nome;
	private JTextField email;
	private JTextField cargo;
	private JButton botao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInserir frame = new TelaInserir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void acaoBotao() {
		Funcionario f = new Funcionario(nome.getText(), email.getText(), cargo.getText());
		FuncionarioDAO dao = new FuncionarioDAO();
		if (!dao.inserir(f)) {
			JOptionPane.showMessageDialog(null, "Inserido");
		}
	}

	public TelaInserir() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 430);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);

		this.lblNewLabel = new JLabel("<html><h1>Inserir Funcion\u00E1rios</h1></html>");

		this.lblNewLabel_1 = new JLabel("Nome:");

		this.lblNewLabel_2 = new JLabel("Email:");

		this.lblNewLabel_3 = new JLabel("Cargo:");

		this.nome = new JTextField();
		this.nome.setColumns(10);

		this.email = new JTextField();
		this.email.setColumns(10);

		this.cargo = new JTextField();
		this.cargo.setColumns(10);

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
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(this.cargo,
														GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING,
												gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
																.addComponent(this.nome, GroupLayout.PREFERRED_SIZE,
																		334, GroupLayout.PREFERRED_SIZE)
																.addComponent(this.email, GroupLayout.PREFERRED_SIZE,
																		334, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(207).addComponent(this.botao)))
				.addContainerGap(183, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(45).addComponent(this.lblNewLabel).addGap(63)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(this.lblNewLabel_1).addComponent(this.nome, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(this.email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(this.lblNewLabel_2))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(this.lblNewLabel_3).addComponent(this.cargo, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(50).addComponent(this.botao).addContainerGap(79, Short.MAX_VALUE)));
		this.contentPane.setLayout(gl_contentPane);
	}
}
