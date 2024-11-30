package exercicio_revendaAutomoveis_BD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFrame_automoveis extends JFrame {

	private static final long serialVersionUID = 1L;
	static JFrame_automoveis frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JFrame_automoveis();
					frame = new JFrame_automoveis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame_automoveis() {
		initComponents();
		this.setContentPane(new JPanel_menuPrincipal());
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
