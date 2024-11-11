package exercicio_revendaAutomoveis_BD;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class TelaConsulta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton consultar;
	private JScrollPane scrollPane;
	private JTextArea saida;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					TelaConsulta frame = new TelaConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaConsulta() {
		initComponents();
	}

	public void consultarAutomovel() {
		AutomovelDAO AutoDao = new AutomovelDAO();
		LinkedList<Automovel> automoveis = AutoDao.listar();
		for (Automovel automovel : automoveis) {
			saida.append(automovel.toString());
		}
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 408);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);

		this.consultar = new JButton("<html><h1>Listar Funcion\u00E1rios</h1></html>");
		this.consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarAutomovel();
			}
		});

		this.scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap(203, Short.MAX_VALUE)
								.addComponent(this.consultar).addGap(200))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(94)
						.addComponent(this.scrollPane, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(94, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(24).addComponent(this.consultar)
						.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
						.addComponent(this.scrollPane, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addGap(41)));

		this.saida = new JTextArea();
		this.saida.setForeground(Color.BLUE);
		this.saida.setEditable(false);
		this.saida.setFont(new Font("Monospaced", Font.BOLD, 22));
		this.saida.setLineWrap(true);
		this.scrollPane.setViewportView(this.saida);
		this.contentPane.setLayout(gl_contentPane);
	}
}
