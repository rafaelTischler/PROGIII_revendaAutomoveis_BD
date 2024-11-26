package exercicio_revendaAutomoveis_BD;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class JPanel_menuPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel txtMenu = new JLabel("Menu Principal");
	private final JButton btn_cadastrar = new JButton("Cadastrar");
	private final JButton btn_consultar = new JButton("Consultar");
	private final JButton btn_alterar = new JButton("Alterar/Excluir");
	private final JButton btn_sair = new JButton("Sair");
	private final JLabel lblNewLabel = new JLabel(
			"<html>\r\n\t<div style='text-align: center;'>\r\n\t\t<p>REVENDA DE</p>\r\n\t\t<h1>AUTOMÓVEIS</h1>\r\n\t<div>\r\n<html>");

	public JPanel_menuPrincipal() {
		initComponents();
		
	}

	private void initComponents() {
		setBounds(100, 100, 800, 600);
		setLayout(new MigLayout("", "[]", "[]"));
		setBackground(new Color(0, 51, 102));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new MigLayout("", "[][150.00][][grow]", "[][grow][]"));
		this.panel.setBackground(new Color(61, 64, 91));
		add(this.panel, "cell 1 1,grow");
		this.panel.setLayout(new MigLayout("", "[][grow][]", "[][][][][grow][][][][][grow][][]"));
		this.lblNewLabel.setForeground(Color.WHITE);
		this.lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		this.panel.add(this.lblNewLabel, "cell 1 1,alignx left,aligny center");
		this.txtMenu.setBorder(null);
		this.txtMenu.setForeground(new Color(255, 255, 255));
		this.txtMenu.setBackground(new Color(255, 255, 255));
		this.txtMenu.setFont(new Font("Segoe UI", Font.BOLD, 16));
		this.panel.add(this.txtMenu, "cell 1 3,alignx center,aligny center");
		this.btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro();
			}
		});
		this.btn_cadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.btn_consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaConsulta();
			}
		});
		this.btn_consultar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.btn_alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaAlterar();
			}
		});
		this.btn_alterar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btn_cadastrar, "cell 1 5,growx");
		this.panel.add(this.btn_consultar, "cell 1 6,growx");
		this.panel.add(this.btn_alterar, "cell 1 7,growx");
		this.btn_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.btn_sair.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		this.panel.add(this.btn_sair, "cell 1 10,growx");
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
