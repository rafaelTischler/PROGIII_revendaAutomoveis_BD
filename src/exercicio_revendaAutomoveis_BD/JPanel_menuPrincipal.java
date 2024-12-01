package exercicio_revendaAutomoveis_BD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.UIManager;

public class JPanel_menuPrincipal extends JPanel {

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
	private final JLabel lbl_titulo = new JLabel("<html><div style='text-align: left;'>A maneira mais fácil de <br>encontrar e gerenciar <br> seus veículos</div></html>");
	private final JLabel lbl_texto = new JLabel("<html><div style='text-align: left;'>Aqui você pode cadastrar, consultar e atualizar o seu estoque de<br>carros de forma rápida e prática. Gerencie informações como marca,<br>modelo, cor, ano e tipo de combustível com facilidade. Acesse<br>sua conta e aproveite para manter seu inventário sempre atualizado!</div></html>");
	private final JLabel lblDireitosAutorais = new JLabel();
	private final JPanel panel = new JPanel();
	private final JButton btn_comecar = new JButton("Começar");

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon background = new ImageIcon(getClass().getResource("/img/bmw_menu.png"));
		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

	public JPanel_menuPrincipal() {
		initComponents();
	}

	private void initComponents() {
		setFocusCycleRoot(true);
		setFocusTraversalKeysEnabled(false);
		setBackground(Color.GRAY);
		setBounds(100, 100, 1280, 720);
		setLayout(new MigLayout("insets 0, gap 0", "[100px][150px][grow][grow]", "[25px][50px][150px][][30px][][30px][30px][grow][]"));

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
		add(panel_usuario, "cell 2 0 2 1,grow");

		panel_menu.setBackground(Color.WHITE);
		panel_menu.setLayout(new MigLayout("insets 10, gap 10", "[grow][][grow][][grow][][grow][][grow]", "[grow][][grow]"));
		lbl_menu.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_menu.add(lbl_menu, "cell 1 1");
		this.lbl_cadastrar.setForeground(Color.GRAY);
		lbl_cadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_menu.add(lbl_cadastrar, "cell 3 1");
		this.lbl_consultar.setForeground(Color.GRAY);
		lbl_consultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_menu.add(lbl_consultar, "cell 5 1");
		this.lbl_alterarRemover.setForeground(Color.GRAY);
		lbl_alterarRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_menu.add(lbl_alterarRemover, "cell 7 1");
		add(panel_menu, "cell 2 1 2 1,grow");

		addMouseListenerToLabel(lbl_cadastrar, this::abrirCadastroAutomoveis);
		addMouseListenerToLabel(lbl_consultar, this::abrirConsultaAutomoveis);
		addMouseListenerToLabel(lbl_alterarRemover, this::abrirAlterarAutomoveis);
		this.lbl_titulo.setForeground(Color.WHITE);
		this.lbl_titulo.setFont(new Font("Tahoma", Font.BOLD, 30));

		add(this.lbl_titulo, "cell 1 3 2 1,alignx left,aligny center");
		this.lbl_texto.setForeground(Color.WHITE);
		this.lbl_texto.setFont(new Font("Tahoma", Font.PLAIN, 12));

		add(this.lbl_texto, "cell 1 5 2 1");
		this.btn_comecar.setFocusPainted(false);
		this.btn_comecar.setBorder(UIManager.getBorder("Button.border"));
		this.btn_comecar.setBackground(new Color(170, 60, 45));
		this.btn_comecar.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btn_comecar.setForeground(Color.WHITE);
		add(this.btn_comecar, "cell 1 7,grow");
		this.panel.getLayout();
		this.panel.setBackground(Color.DARK_GRAY);

		add(this.panel, "cell 0 9 4 1,grow");
		this.panel.add(this.lblDireitosAutorais);

		lblDireitosAutorais.setText("© 2024 Direitos Autorais - Carolini Bassan Carlé e Rafael Müller Tischler | ADS 19 | IFFar - Campus São Vicente do Sul");
		lblDireitosAutorais.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblDireitosAutorais.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireitosAutorais.setForeground(Color.WHITE);
	}

	private void addMouseListenerToLabel(JLabel label, Runnable action) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				action.run();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label.setForeground(new Color(170, 60, 45));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label.setForeground(Color.GRAY);
			}
		});
	}

	private void abrirCadastroAutomoveis() {
		JPanel_cadastroAutomoveis cadastroPanel = new JPanel_cadastroAutomoveis();
		atualizarTela(cadastroPanel);
	}

	private void abrirConsultaAutomoveis() {
		JOptionPane.showMessageDialog(this, "Funcionalidade de consulta não implementada.");
	}

	private void abrirAlterarAutomoveis() {
		JPanel_alterarAutomoveis alterarPanel = new JPanel_alterarAutomoveis();
		atualizarTela(alterarPanel);
	}

	private void atualizarTela(JPanel novoPainel) {
		removeAll();
		add(novoPainel, "grow");
		revalidate();
		repaint();
	}

}
