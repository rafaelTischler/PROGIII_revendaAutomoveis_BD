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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaConsultaCombo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboMarca;
	private JScrollPane scrollPane;
	private JTable tabela;
	private final JComboBox comboModelo = new JComboBox();
	private final JComboBox comboAno = new JComboBox();
	private final JLabel lblNewLabel = new JLabel("Consultar automóveis");

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	
	private void preencherCombo() {
		comboMarca.addItem("Selecione um nome: ");
		AutomovelDAO dao = new AutomovelDAO(); 
		LinkedList<String> nomes = dao.listarNomes();
		for(String nome : nomes) {
			comboMarca.addItem(nome);
		}
	}
	
	private void acaoCombo() {
		AutomovelDAO dao = new AutomovelDAO();
		DefaultTableModel model = (DefaultTableModel)tabela.getModel();
		if(!comboMarca.getSelectedItem().equals("Selecione um nome: ")) {
			Automovel a = dao.consultarMarca(comboMarca.getSelectedItem()+"");
			model.setRowCount(0);
			model.addRow(new String[] {a.getId()+"", a.getMarca(), a.getModelo(), a.getCor(), a.getCombustivel()});
		}else {
			model.setRowCount(0);
		}
	}
	
	public TelaConsultaCombo() {
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.comboAno.setModel(new DefaultComboBoxModel(new String[] {"Selecione um ano de fabricação:"}));
		this.comboModelo.setModel(new DefaultComboBoxModel(new String[] {"Selecione um modelo:"}));
		initComponents();
		preencherCombo();
	}
	
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 443);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(this.contentPane);
		
		this.comboMarca = new JComboBox();
		comboMarca.setModel(new DefaultComboBoxModel(new String[] {"Selecione uma marca:"}));
		this.comboMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoCombo();
			}
		});
		
		this.scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboMarca, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
									.addGap(32)
									.addComponent(this.comboModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(29)
									.addComponent(this.comboAno, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 548, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(203)
							.addComponent(this.lblNewLabel, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(58, Short.MAX_VALUE)
					.addComponent(this.lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboMarca, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(this.comboModelo, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(this.comboAno, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(78))
		);
		
		this.tabela = new JTable();
		this.tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "EMAIL", "CARGO"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.tabela.getColumnModel().getColumn(0).setResizable(false);
		this.tabela.getColumnModel().getColumn(0).setPreferredWidth(46);
		this.tabela.getColumnModel().getColumn(1).setResizable(false);
		this.tabela.getColumnModel().getColumn(1).setPreferredWidth(103);
		this.tabela.getColumnModel().getColumn(2).setResizable(false);
		this.tabela.getColumnModel().getColumn(2).setPreferredWidth(181);
		this.tabela.getColumnModel().getColumn(3).setResizable(false);
		this.tabela.getColumnModel().getColumn(3).setPreferredWidth(111);
		this.scrollPane.setViewportView(this.tabela);
		this.contentPane.setLayout(gl_contentPane);
	}
}
