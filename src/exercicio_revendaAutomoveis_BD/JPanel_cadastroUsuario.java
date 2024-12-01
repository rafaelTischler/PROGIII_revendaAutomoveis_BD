package exercicio_revendaAutomoveis_BD;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPanel_cadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel lbl_cadastrar = new JLabel("Cadastrar Usuário");
	private final JLabel lbl_infoCad = new JLabel("<html>\n  <div style='text-align: left;'>\n    Preencha as informações abaixo para cadastrar um novo usuário no sistema. \n    Essas são informações essenciais para criar sua conta e acessar todas as funcionalidades do Ifome. \n    <br>Ao clicar em cadastrar, seu usuário será registrado e poderá realizar pedidos de forma rápida e prática.\n  </div>\n</html>\n\n\n\n\n\n");
	private final JLabel lbl_marca = new JLabel("Nome");
	private final JTextField edit_marca = new JTextField();
	private final JLabel lbl_modelo = new JLabel("E-mail");
	private final JTextField edit_modelo = new JTextField();
	private final JButton btn_cadVeiculo = new JButton("Cadastrar");
	private final JLabel lbl_homepage = new JLabel("Voltar para a tela inicial");
	private final JLabel lbl_ano = new JLabel("Telefone");
	private final JTextField edit_ano = new JTextField();
	private final JTextField edit_cor = new JTextField();
	private final JLabel lbl_cor = new JLabel("Senha ");

	private final JPanel panel_logo = new JPanel();
	private final JPanel panel_usuario = new JPanel();
	private final JPanel panel_menu = new JPanel();
	private final JLabel lbl_logoPanel = new JLabel("LOGO");
	private final JLabel lbl_usuario = new JLabel("Bem-vindo, Usuário");

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon background = new ImageIcon(getClass().getResource("/img/bmw_cad.png"));
		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

	public JPanel_cadastroUsuario() {
		this.edit_modelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.edit_modelo.setColumns(10);
		this.edit_marca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.edit_marca.setColumns(10);
		initComponents();
	}

	private void initComponents() {
		setBackground(new Color(192, 192, 192));
		setBounds(100, 100, 1280, 720);
		setLayout(new MigLayout("insets 0, gap 0", "[100px][150px][262px][grow]", "[25px][50px][grow]"));

		panel_logo.setBackground(new Color(170, 60, 45));
		panel_logo.setLayout(new MigLayout("insets 10, gap 10", "[grow][][grow]", "[grow][][grow]"));
		lbl_logoPanel.setForeground(Color.WHITE);
		lbl_logoPanel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_logo.add(lbl_logoPanel, "cell 1 1");
		add(panel_logo, "cell 0 0 2 2,grow");

		panel_usuario.setBackground(Color.DARK_GRAY);
		panel_usuario.setLayout(new MigLayout("insets 10, gap 10", "[][][grow]", "[]"));
		lbl_usuario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_usuario.setForeground(Color.WHITE);
		panel_usuario.add(lbl_usuario, "cell 1 0,alignx center");
		add(panel_usuario, "cell 2 0 2 1,grow");

		panel_menu.setBackground(Color.WHITE);
		panel_menu.setLayout(new MigLayout("insets 10, gap 10", "[grow][][grow][][grow][][grow][][grow]", "[grow][][grow]"));

		add(panel_menu, "cell 2 1 2 1,grow");

		panel.setBackground(Color.WHITE);
		add(panel, "cell 0 2 3 1,grow");
		panel.setLayout(new MigLayout("", "[grow][40%,grow][grow]", "[grow][][20px][][grow][][35px][][35px][][35px][][35px][][35px][20px][35px][grow][][grow]"));
		lbl_cadastrar.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lbl_cadastrar, "cell 1 1,alignx center,aligny center");
		lbl_infoCad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(lbl_infoCad, "cell 1 3,alignx center");
		lbl_marca.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lbl_marca, "cell 1 5,alignx left");
		panel.add(edit_marca, "cell 1 6,grow");
		lbl_modelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lbl_modelo, "cell 1 7,alignx left");
		panel.add(edit_modelo, "cell 1 8,grow");
		lbl_ano.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lbl_ano, "cell 1 9");
		edit_ano.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edit_ano.setColumns(10);
		panel.add(edit_ano, "cell 1 10,grow");
		lbl_cor.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lbl_cor, "cell 1 11");
		edit_cor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edit_cor.setColumns(10);
		panel.add(edit_cor, "cell 1 12,grow");
		btn_cadVeiculo.setBackground(new Color(170, 60, 45));
		btn_cadVeiculo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_cadVeiculo.setForeground(Color.WHITE);
		panel.add(btn_cadVeiculo, "cell 1 16,grow");
		this.lbl_homepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirTelaMenu();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_homepage.setForeground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbl_homepage.setForeground(new Color(170, 60, 45));
			}
		});
		lbl_homepage.setForeground(new Color(170, 60, 45));
		lbl_homepage.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lbl_homepage, "cell 1 18,alignx center");
	}

	protected void abrirTelaMenu() {
		JFrame_automoveis.frame.setContentPane(new JPanel_menuPrincipal());
		JFrame_automoveis.frame.setVisible(true);
	}

	protected void abrirTelaCadastro() {
		JFrame_automoveis.frame.setContentPane(new JPanel_cadastroAutomoveis());
		JFrame_automoveis.frame.setVisible(true);
	}
}