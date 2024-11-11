package exercicio_revendaAutomoveis_BD;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConsultaCombo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> combo;
	private JScrollPane scrollPane;
	private JTable saida;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaCombo frame = new TelaConsultaCombo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void preencherCombo() {
		combo.addItem("Selecione um nome: ");
		FuncionarioDAO dao = new FuncionarioDAO();
		LinkedList<String> nomes = dao.listarNomes();
		for (String nome : nomes) {
			combo.addItem(nome);
		}
	}

	private void acaoCombo() {
		FuncionarioDAO dao = new FuncionarioDAO();
		DefaultTableModel model = (DefaultTableModel) saida.getModel();
		if (!combo.getSelectedItem().equals("Selecione um nome: ")) {
			Funcionario f = dao.consultarNome(combo.getSelectedItem() + "");
			model.setRowCount(0);
			model.addRow(new String[] { f.getId() + "", f.getNome(), f.getEmail(), f.getCargo() });
		} else {
			model.setRowCount(0);
		}
	}

	public TelaConsultaCombo() {
		initComponents();
		preencherCombo();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 443);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);

		this.combo = new JComboBox();
		this.combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoCombo();
			}
		});

		this.scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(47).addComponent(
										this.scrollPane, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(194).addComponent(this.combo,
										GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(64, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGap(44)
						.addComponent(this.combo, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
						.addComponent(this.scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addGap(78)));

		this.saida = new JTable();
		this.saida.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "NOME", "EMAIL", "CARGO" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.saida.getColumnModel().getColumn(0).setResizable(false);
		this.saida.getColumnModel().getColumn(0).setPreferredWidth(46);
		this.saida.getColumnModel().getColumn(1).setResizable(false);
		this.saida.getColumnModel().getColumn(1).setPreferredWidth(103);
		this.saida.getColumnModel().getColumn(2).setResizable(false);
		this.saida.getColumnModel().getColumn(2).setPreferredWidth(181);
		this.saida.getColumnModel().getColumn(3).setResizable(false);
		this.saida.getColumnModel().getColumn(3).setPreferredWidth(111);
		this.scrollPane.setViewportView(this.saida);
		this.contentPane.setLayout(gl_contentPane);
	}
}
