package paranavai.ifpr.jogo.modelo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Personagem {
	private int x;
	private int y;
	private int dx;
	private int dy;
	private Image imagem;
	private int altura;
	private int largura;

	public Personagem() {
		this.x = 100;
		this.y = 100;
	}

	public void carregar() {
		ImageIcon carregando = new ImageIcon("recursos\\espaconave.png");
		imagem = carregando.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}

}