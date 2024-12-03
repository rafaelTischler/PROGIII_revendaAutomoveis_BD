package exercicio_revendaAutomoveis_BD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JPanel_consultaAutomoveis extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel_logo = new JPanel();
	private final JPanel panel_usuario = new JPanel();
	private final JPanel panel_menu = new JPanel();
	private final JLabel lbl_logoPanel = new JLabel("LOGO");
	private final JLabel lblNewLabel = new JLabel("Bem-vindo, Usuário");
	private final JLabel lbl_menu = new JLabel("MENU");
	private final JLabel lbl_cadastrar = new JLabel("CADASTRAR");
	private final JLabel lbl_consultar = new JLabel("CONSULTAR");
	private final JLabel lbl_alterarRemover = new JLabel("ALTERAR OU REMOVER");
	private final JPanel panel_busca = new JPanel();
	private final JLabel lbl_marca = new JLabel("Marca");
	private final JTextField edit_marca = new JTextField();
	private final JButton btn_buscar = new JButton("Buscar");
	private final JPanel panel_buscaMarca = new JPanel();
	private final JLabel lbl_buscaMarca = new JLabel("Buscar por marca");
	private final JPanel panel_buscaModelo = new JPanel();
	private final JPanel panel_buscaAno = new JPanel();
	private final JLabel lbl_buscaModelo = new JLabel("Buscar por modelo");
	private final JLabel lbl_buscaAno = new JLabel("Buscar por ano\r\n");
	private final JPanel panel_tabela = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon background = new ImageIcon(getClass().getResource("/img/bmw_cons.png"));
		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

	public JPanel_consultaAutomoveis() {
		this.edit_marca.setColumns(10);
		this.edit_marca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		initComponents();
	}

	private void initComponents() {
		setFocusCycleRoot(true);
		setFocusTraversalKeysEnabled(false);
		setBackground(Color.GRAY);
		setBounds(100, 100, 1280, 720);
		setLayout(new MigLayout("insets 0, gap 0", "[100px][150px][grow][150px:n:150px][30px][150px:n:150px][30px][150px:n:150px][grow][250px]", "[25px][50px][100px][30px][][30px][grow]"));

		panel_logo.setBackground(new Color(170, 60, 45));
		panel_logo.setLayout(new MigLayout("insets 10, gap 10", "[grow][][grow]", "[grow][][grow]"));
		this.lbl_logoPanel.setForeground(Color.WHITE);
		lbl_logoPanel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_logo.add(lbl_logoPanel, "cell 1 1");
		add(panel_logo, "cell 0 0 2 2,grow");

		panel_usuario.setBackground(Color.DARK_GRAY);
		panel_usuario.setLayout(new MigLayout("insets 10, gap 10", "[][][grow]", "[]"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setForeground(Color.WHITE);
		panel_usuario.add(lblNewLabel, "cell 1 0,alignx center");
		add(panel_usuario, "cell 2 0 8 1,grow");

		panel_menu.setBackground(Color.WHITE);
		panel_menu.setLayout(new MigLayout("insets 10, gap 10", "[grow][][grow][][grow][][grow][][grow]", "[grow][][grow]"));
		this.lbl_menu.setForeground(Color.GRAY);
		lbl_menu.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_menu.add(lbl_menu, "cell 1 1");
		this.lbl_cadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirTelaCadastro();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_cadastrar.setForeground(new Color(170, 60, 45));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_cadastrar.setForeground(Color.GRAY);
			}
		});
		this.lbl_cadastrar.setForeground(Color.GRAY);
		lbl_cadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_menu.add(lbl_cadastrar, "cell 3 1");
		this.lbl_consultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirTelaConsulta();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_consultar.setForeground(new Color(170, 60, 45));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_consultar.setForeground(Color.GRAY);
			}
		});
		this.lbl_consultar.setForeground(Color.BLACK);
		lbl_consultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_menu.add(lbl_consultar, "cell 5 1");
		this.lbl_alterarRemover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirTelaAlterar();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_alterarRemover.setForeground(new Color(170, 60, 45));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_alterarRemover.setForeground(Color.GRAY);
			}
		});
		this.lbl_alterarRemover.setForeground(Color.GRAY);
		lbl_alterarRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_menu.add(lbl_alterarRemover, "cell 7 1");
		add(panel_menu, "cell 2 1 8 1,grow");
		this.panel_buscaMarca.setBackground(Color.WHITE);
		
		add(this.panel_buscaMarca, "cell 3 3,grow");
		this.panel_buscaMarca.setLayout(new MigLayout("", "[20px][][20px]", "[][15px][]"));
		this.lbl_buscaMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		this.panel_buscaMarca.add(this.lbl_buscaMarca, "cell 1 1,alignx left,aligny center");
		this.panel_buscaModelo.setBackground(new Color(170, 60, 45));
		
		add(this.panel_buscaModelo, "cell 5 3,grow");
		this.panel_buscaModelo.setLayout(new MigLayout("", "[20px][][20px]", "[][][]"));
		this.lbl_buscaModelo.setForeground(Color.WHITE);
		this.lbl_buscaModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		this.panel_buscaModelo.add(this.lbl_buscaModelo, "cell 1 1,alignx left,aligny center");
		this.panel_buscaAno.setBackground(new Color(170, 60, 45));
		
		add(this.panel_buscaAno, "cell 7 3,grow");
		this.panel_buscaAno.setLayout(new MigLayout("", "[20px][][20px]", "[][][]"));
		this.lbl_buscaAno.setForeground(Color.WHITE);
		this.lbl_buscaAno.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		this.panel_buscaAno.add(this.lbl_buscaAno, "cell 1 1,alignx left,aligny center");
		this.panel_busca.setBackground(Color.WHITE);

		add(this.panel_busca, "cell 3 4 5 1,grow");
		this.panel_busca.setLayout(new MigLayout("", "[30px][330px][30px:30px][150px][30px]", "[20px][][30px][20px]"));
		this.lbl_marca.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.panel_busca.add(this.lbl_marca, "cell 1 1");

		this.panel_busca.add(this.edit_marca, "cell 1 2,grow");
		this.btn_buscar.setBackground(new Color(170, 60, 45));
		this.btn_buscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btn_buscar.setForeground(Color.WHITE);
		this.panel_busca.add(this.btn_buscar, "cell 3 2,grow");
		this.panel_tabela.setBackground(Color.WHITE);
		
		add(this.panel_tabela, "cell 0 6 10 1,grow");
		this.panel_tabela.setLayout(new MigLayout("", "[30px][grow][30px]", "[30px][grow]"));
		
		this.panel_tabela.add(this.scrollPane, "cell 1 1,grow");
	}

	protected void abrirTelaCadastro() {
		JFrame_automoveis.frame.setContentPane(new JPanel_cadastroAutomoveis());
		JFrame_automoveis.frame.setVisible(true);
	}

	protected void abrirTelaConsulta() {
		JFrame_automoveis.frame.setContentPane(new JPanel_consultaAutomoveis());
		JFrame_automoveis.frame.setVisible(true);
	}

	protected void abrirTelaAlterar() {
		JFrame_automoveis.frame.setContentPane(new JPanel_alterarAutomoveis());
		JFrame_automoveis.frame.setVisible(true);
	}
}