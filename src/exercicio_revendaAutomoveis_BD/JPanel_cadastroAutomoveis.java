package exercicio_revendaAutomoveis_BD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JPanel_cadastroAutomoveis extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JLabel lbl_cadastrar = new JLabel("Cadastrar um veículo");
	private final JLabel lbl_infoCad = new JLabel("<html><div style='text-align: left;'>Preencha as informações abaixo para cadastrar um veículo no estoque. Essas são informações básicas para o controle do seu inventário veicular. <br>Ao clicar em cadastrar, o veículo estará disponível para consultas e gerenciamento em seu sistema.</div></html>");
	private final JLabel lbl_marca = new JLabel("Marca");
	private final JTextField edit_marca = new JTextField();
	private final JLabel lbl_modelo = new JLabel("Modelo");
	private final JTextField edit_modelo = new JTextField();
	private final JButton btn_cadVeiculo = new JButton("Cadastrar");
	private final JLabel lbl_homepage = new JLabel("Voltar para a tela inicial");
	private final JLabel lbl_ano = new JLabel("Ano de fabricação");
	private final JLabel lbl_combust = new JLabel("Tipo de combustível");
	private final JTextField edit_ano = new JTextField();
	private final JTextField edit_combust = new JTextField();
	private final JTextField edit_cor = new JTextField();
	private final JLabel lbl_cor = new JLabel("Cor");

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon background = new ImageIcon(getClass().getResource("/img/bmw_cad.png"));
		g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

	public JPanel_cadastroAutomoveis() {
		this.edit_modelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.edit_modelo.setColumns(10);
		this.edit_marca.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.edit_marca.setColumns(10);
		initComponents();
	}

	private void initComponents() {
		setBackground(new Color(192, 192, 192));
		setBounds(100, 100, 1280, 720);
		setLayout(new MigLayout("", "[40%][grow]", "[grow]"));
		this.panel.setBackground(Color.WHITE);
		add(this.panel, "cell 0 0,grow");
		this.panel.setLayout(new MigLayout("", "[grow][40%,grow][grow]", "[grow][][20px][][grow][][35px][][35px][][35px][][35px][][35px][20px][35px][grow][][grow]"));
		this.lbl_cadastrar.setFont(new Font("Tahoma", Font.BOLD, 30));
		this.panel.add(this.lbl_cadastrar, "cell 1 1,alignx center,aligny center");
		this.lbl_infoCad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.panel.add(this.lbl_infoCad, "cell 1 3,alignx center");
		this.lbl_marca.setFont(new Font("Tahoma", Font.BOLD, 12));

		this.panel.add(this.lbl_marca, "cell 1 5,alignx left");

		this.panel.add(this.edit_marca, "cell 1 6,grow");
		this.lbl_modelo.setFont(new Font("Tahoma", Font.BOLD, 12));

		this.panel.add(this.lbl_modelo, "cell 1 7,alignx left");

		this.panel.add(this.edit_modelo, "cell 1 8,grow");
		this.lbl_ano.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		this.panel.add(this.lbl_ano, "cell 1 9");
		this.edit_ano.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.edit_ano.setColumns(10);
		
		this.panel.add(this.edit_ano, "cell 1 10,grow");
		this.lbl_cor.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		this.panel.add(this.lbl_cor, "cell 1 11");
		this.edit_cor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.edit_cor.setColumns(10);
		
		this.panel.add(this.edit_cor, "cell 1 12,grow");
		this.lbl_combust.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		this.panel.add(this.lbl_combust, "cell 1 13");
		this.edit_combust.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.edit_combust.setColumns(10);
		
		this.panel.add(this.edit_combust, "cell 1 14,grow");
		this.btn_cadVeiculo.setBackground(new Color(184, 88, 71));
		this.btn_cadVeiculo.setFont(new Font("Tahoma", Font.BOLD, 12));
		this.btn_cadVeiculo.setForeground(Color.WHITE);

		this.panel.add(this.btn_cadVeiculo, "cell 1 16,grow");
		this.lbl_homepage.setForeground(new Color(184, 88, 71));
		this.lbl_homepage.setBackground(new Color(184, 88, 71));
		this.lbl_homepage.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		this.panel.add(this.lbl_homepage, "cell 1 18,alignx center");
		this.btn_cadVeiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarVeiculo();
            }
        });
	}
	 private void cadastrarVeiculo() {
	        String marca = edit_marca.getText();
	        String modelo = edit_modelo.getText();
	        String ano = edit_ano.getText();
	        String cor = edit_cor.getText();
	        String combustivel = edit_combust.getText();
	        if (marca.isEmpty() || modelo.isEmpty() || ano.isEmpty() || cor.isEmpty() || combustivel.isEmpty()) {
	            System.out.println("Todos os campos devem ser preenchidos.");
	            return;
	        }
	        Automovel automovel = new Automovel(marca, modelo, ano, cor, combustivel);
	        AutomovelDAO dao = new AutomovelDAO();
	        boolean sucesso = dao.inserir(automovel);
	        if (sucesso) {
	            System.out.println("Erro ao cadastrar veículo.");
	        } else {
	            System.out.println("Veículo cadastrado com sucesso.");
	        }
	    }
}