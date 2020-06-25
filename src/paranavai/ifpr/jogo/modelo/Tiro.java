package paranavai.ifpr.jogo.modelo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tiro {
	private int x;
	private int y;
	private Image imagem;
	private int largura;
	private int altura;
	
	private static int velocidade = 2;
	
	public Tiro(int xPersonagem, int yPersonagem) {
		this.x = xPersonagem;
		this.y = yPersonagem;
	}
	
	public void carregar() {
		ImageIcon carregando = new ImageIcon("recursos\\tiro.png");
		this.imagem = carregando.getImage();
		
		this.altura = imagem.getHeight(null);
		this.largura = imagem.getWidth(null);
	}	
}