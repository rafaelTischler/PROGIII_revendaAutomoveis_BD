package exercicio_revendaAutomoveis_BD;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
	private final JLabel lbl_infoCad = new JLabel(
			"<html>\r\n  <div style='text-align: left;'>\r\n    Preencha as informações abaixo para cadastrar um novo usuário no sistema. \r\n    Essas são informações essenciais para criar sua conta e acessar todas as funcionalidades da Revenda de Automóveis. \r\n    <br>Ao clicar em cadastrar, seu usuário será registrado e poderá realizar pedidos de forma rápida e prática.\r\n  </div>\r\n</html>\r\n\r\n\r\n\r\n\r\n\r\n");
	private final JLabel lbl_nome = new JLabel("Nome");
	private final JTextField edit_nome = new JTextField();
	private final JLabel lbl_email = new JLabel("E-mail");
	private final JTextField edit_email = new JTextField();
	private final JButton btn_cadastrar = new JButton("Cadastrar");
	private final JLabel lbl_telefone = new JLabel("Telefone");
	private final JTextField edit_telefone = new JTextField();
	private final JTextField edit_senha = new JTextField();
	private final JLabel lbl_senha = new JLabel("Senha ");
	private final JLabel lbl_homepage = new JLabel("Voltar para o login");

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon background = new ImageIcon(getClass().getResource("/img/bmw_login.png"));
		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

	public JPanel_cadastroUsuario() {
		initComponents();
		configurarEventos();
	}

	private void initComponents() {
		setBackground(new Color(192, 192, 192));
		setBounds(100, 100, 1280, 720);
		setLayout(new MigLayout("insets 0, gap 0", "[100px][150px][262px][grow]", "[grow]"));

		panel.setBackground(Color.WHITE);
		add(panel, "cell 0 0 3 1,grow");
		panel.setLayout(new MigLayout("", "[grow][40%,grow][grow]",
				"[grow][][20px][][grow][][35px][][35px][][35px][][35px][][35px][20px][35px][grow][][grow]"));
		lbl_cadastrar.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lbl_cadastrar, "cell 1 1,alignx center,aligny center");
		lbl_infoCad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(lbl_infoCad, "cell 1 3,alignx center");
		lbl_nome.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lbl_nome, "cell 1 5,alignx left");
		panel.add(edit_nome, "cell 1 6,grow");
		lbl_email.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lbl_email, "cell 1 7,alignx left");
		panel.add(edit_email, "cell 1 8,grow");
		lbl_telefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lbl_telefone, "cell 1 9");
		edit_telefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edit_telefone.setColumns(10);
		panel.add(edit_telefone, "cell 1 10,grow");
		lbl_senha.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lbl_senha, "cell 1 11");
		edit_senha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		edit_senha.setColumns(10);
		panel.add(edit_senha, "cell 1 12,grow");
		btn_cadastrar.setBackground(new Color(170, 60, 45));
		btn_cadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_cadastrar.setForeground(Color.WHITE);
		panel.add(btn_cadastrar, "cell 1 16,grow");
		lbl_homepage.setForeground(new Color(170, 60, 45));
		lbl_homepage.setFont(new Font("Tahoma", Font.BOLD, 11));

		panel.add(lbl_homepage, "cell 1 17,alignx center");
	}

	private void configurarEventos() {
		btn_cadastrar.addActionListener(e -> cadastrarUsuario());
		lbl_homepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirTelaLogin();
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
	}

	private void cadastrarUsuario() {
		String nome = edit_nome.getText().trim();
		String email = edit_email.getText().trim();
		String telefone = edit_telefone.getText().trim();
		String senha = edit_senha.getText().trim();

		if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || senha.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		telefone = telefone.replaceAll("[^0-9]", "");

		if (telefone.length() > 15) {
			JOptionPane.showMessageDialog(this, "Número de telefone muito longo!", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Usuario usuario = new Usuario(nome, email, telefone, senha);
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		if (usuarioDAO.inserir(usuario)) {
			JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário.", "Erro", JOptionPane.ERROR_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			abrirTelaLogin();
		}
	}

	protected void abrirTelaMenu() {
		JFrame_automoveis.frame.setContentPane(new JPanel_menuPrincipal());
		JFrame_automoveis.frame.setVisible(true);
	}

	private void abrirTelaLogin() {

		JFrame_automoveis.frame.setContentPane(new JPanel_telaLogin());
		JFrame_automoveis.frame.setVisible(true);
	}
}