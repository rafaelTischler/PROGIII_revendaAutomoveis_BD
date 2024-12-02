package exercicio_revendaAutomoveis_BD;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanel_telaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("Bem-vindo!");
	private final JLabel lblNewLabel_1 = new JLabel("<html><div style='text-align: left;'>Acesse sua conta e gerencie todo seu inventário de veículos de forma simples e rápida. Caso não possua uma conta, crie uma agora mesmo!</div></html>");
	private final JLabel lblNewLabel_2 = new JLabel("Login");
	private final JTextField edit_login = new JTextField();
	private final JLabel lblNewLabel_3 = new JLabel("Senha");
	private final JTextField edit_senha = new JTextField();
	private final JLabel lblNewLabel_4 = new JLabel("Esqueceu sua senha?");
	private final JButton btn_entrar = new JButton("Entrar");
	private final JLabel lbl_criar = new JLabel("Ainda não tem uma conta ? Cadastre-se");

	public static boolean usuarioLogado = false;
	public static String nomeUsuario;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon background = new ImageIcon(getClass().getResource("/img/bmw_login.png"));
		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

	public JPanel_telaLogin() {
		this.edit_senha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.edit_senha.setColumns(10);
		this.edit_login.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.edit_login.setColumns(10);
		initComponents();
	}

	private void initComponents() {
		setBackground(new Color(192, 192, 192));
		setBounds(100, 100, 1280, 720);
		setLayout(new MigLayout("", "[grow][40%]", "[grow]"));
		this.panel.setBackground(Color.WHITE);
		add(this.panel, "cell 1 0, grow");
		this.panel.setLayout(new MigLayout("", "[grow][50%][grow]", "[grow][][20px][][grow][][30px][][30px][][20px][30px][grow][][grow]"));
		this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		this.panel.add(this.lblNewLabel, "cell 1 1,alignx center,aligny center");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.panel.add(this.lblNewLabel_1, "cell 1 3,alignx center");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));

		this.panel.add(this.lblNewLabel_2, "cell 1 5,alignx left");

		this.panel.add(this.edit_login, "cell 1 6,grow");
		this.lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));

		this.panel.add(this.lblNewLabel_3, "cell 1 7,alignx left");

		this.panel.add(this.edit_senha, "cell 1 8,grow");
		this.lblNewLabel_4.setForeground(new Color(170, 60, 45));
		this.lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));

		this.panel.add(this.lblNewLabel_4, "cell 1 9,alignx right");
		this.btn_entrar.setBackground(new Color(170, 60, 45));
		this.btn_entrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btn_entrar.setForeground(Color.WHITE);

		this.btn_entrar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            realizarLogin();
	        }
	    });

		panel.add(btn_entrar, "cell 1 11,grow");

        lbl_criar.setFont(new Font("Tahoma", Font.BOLD, 12));
        lbl_criar.setForeground(new Color(170, 60, 45));
        lbl_criar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lbl_criar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirTelaCadastroUsuario();
            }
        });
        panel.add(lbl_criar, "cell 1 12,alignx center");
	}
	
	private void realizarLogin() {
	    String login = edit_login.getText();
	    String senha = edit_senha.getText();

	    if (login.isEmpty() || senha.isEmpty()) {
	        lblNewLabel.setText("Por favor, preencha ambos os campos de login e senha.");
	        return;
	    }

	    Connection conn = Conexao.getConexao();
	    if (conn != null) {
	        try {
	            String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, login);
	            stmt.setString(2, senha);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                nomeUsuario = rs.getString("nome"); 
	                usuarioLogado = true;
	                abrirMenuPrincipal(nomeUsuario);  

	            } else {
	                lblNewLabel.setText("Usuário ou senha inválidos.");
	            }

	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            lblNewLabel.setText("Erro na conexão com o banco de dados.");
	        }
	    } else {
	        lblNewLabel.setText("Erro na conexão com o banco de dados.");
	    }
	}

	
	private void abrirMenuPrincipal(String nomeUsuario) {
        if (usuarioLogado) { 
            JPanel_menuPrincipal menu = new JPanel_menuPrincipal();
            menu.setUsuario(nomeUsuario);
            JFrame_automoveis.frame.setContentPane(menu);
            JFrame_automoveis.frame.setVisible(true);
        } else {
            lblNewLabel.setText("Você precisa fazer login primeiro.");
        }
    }
	
	
	private void abrirTelaCadastroUsuario() {	   
	    JFrame_automoveis.frame.setContentPane(new JPanel_cadastroUsuario()); 
	    JFrame_automoveis.frame.setVisible(true);
	}
	
	protected void abrirTelaCadastroAutomoveis(String nomeUsuario) {
	    JPanel_cadastroAutomoveis panelCadastro = new JPanel_cadastroAutomoveis();
	    panelCadastro.setUsuario(nomeUsuario); 
	    JFrame_automoveis.frame.setContentPane(panelCadastro);
	    JFrame_automoveis.frame.setVisible(true);
	}
	
}
