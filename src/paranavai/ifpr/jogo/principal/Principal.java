package paranavai.ifpr.jogo.principal;

import javax.swing.JFrame;

import paranavai.ifpr.jogo.modelo.Fase;

public class Principal extends JFrame {
	Principal(){
		Fase fase = new Fase();
		add(fase);
		setTitle("Jogo IFPR - Campus Paranavaí");
		setSize(1024, 728);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Principal();
	}
}
