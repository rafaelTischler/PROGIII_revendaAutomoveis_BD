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
import net.miginfocom.swing.MigLayout;

public class JPanel_menuPrincipal extends JPanel {

    private static final long serialVersionUID = 1L;
    private final JPanel panel_logo = new JPanel();
    private final JPanel panel_usuario = new JPanel();
    private final JPanel panel_menu = new JPanel();
    private final JLabel lbl_logoPanel = new JLabel("LOGO");
    private final JLabel lblNewLabel = new JLabel("Bem-vindo, Usuário");
    private final JLabel lblNewLabel_1 = new JLabel("MENU");
    private final JLabel lblNewLabel_2 = new JLabel("CADASTRAR");
    private final JLabel lblNewLabel_2_1 = new JLabel("CONSULTAR");
    private final JLabel lblNewLabel_2_1_1 = new JLabel("ALTERAR OU REMOVER");

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
        setBackground(Color.GRAY);
        setBounds(100, 100, 1280, 720);
        setLayout(new MigLayout("insets 0, gap 0", "[grow][grow][grow]", "[25px][50px][grow]"));

        panel_logo.setBackground(new Color(198, 68, 50));
        panel_logo.setLayout(new MigLayout("insets 10, gap 10", "[grow][][grow]", "[grow][][grow]"));
        this.lbl_logoPanel.setForeground(Color.WHITE);
        lbl_logoPanel.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel_logo.add(lbl_logoPanel, "cell 1 1");
        add(panel_logo, "cell 0 0 1 2,grow");

        panel_usuario.setBackground(Color.DARK_GRAY);
        panel_usuario.setLayout(new MigLayout("insets 10, gap 10", "[][grow]", "[]"));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel.setForeground(Color.WHITE);
        panel_usuario.add(lblNewLabel, "cell 0 0");
        add(panel_usuario, "cell 1 0 2 1,grow");

        panel_menu.setBackground(Color.WHITE);
        panel_menu.setLayout(new MigLayout("insets 10, gap 10", "[grow][][grow][][grow][][grow][][grow]", "[grow][][grow]"));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel_menu.add(lblNewLabel_1, "cell 1 1");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel_menu.add(lblNewLabel_2, "cell 3 1");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel_menu.add(lblNewLabel_2_1, "cell 5 1");
        lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel_menu.add(lblNewLabel_2_1_1, "cell 7 1");
        add(panel_menu, "cell 1 1 2 1,grow");
        
        addMouseListenerToLabel(lblNewLabel_2, this::abrirCadastroAutomoveis);
        addMouseListenerToLabel(lblNewLabel_2_1, this::abrirConsultaAutomoveis);
        addMouseListenerToLabel(lblNewLabel_2_1_1, this::abrirAlterarAutomoveis);
    }
    
    private void addMouseListenerToLabel(JLabel label, Runnable action) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                action.run();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(Color.BLUE); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(Color.BLACK);
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
