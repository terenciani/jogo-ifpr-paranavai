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
	
	public void atualizar() {
		this.x = this.x + velocidade;
	}

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public static int getVelocidade() {
		return velocidade;
	}

	public static void setVelocidade(int velocidade) {
		Tiro.velocidade = velocidade;
	}
}