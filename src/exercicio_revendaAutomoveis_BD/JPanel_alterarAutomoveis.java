package exercicio_revendaAutomoveis_BD;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class JPanel_alterarAutomoveis extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image background;

	public JPanel_alterarAutomoveis() {
		try {
			background = ImageIO.read(getClass().getResource("/img/astommartin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
	}


}
