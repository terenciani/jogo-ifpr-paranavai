package paranavai.ifpr.jogo.modelo;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Personagem {
	private int x;
	private int y;
	private int dx;
	private int dy;
	private Image imagem;
	private int altura;
	private int largura;

	private ArrayList<Tiro> tiros;

	public Personagem() {
		this.x = 100;
		this.y = 100;
		this.tiros = new ArrayList<Tiro>();
	}

	public void carregar() {
		ImageIcon carregando = new ImageIcon("recursos\\espaconave.png");
		imagem = carregando.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}

	public void atualizar() {
		x = x + dx;
		y = y + dy;
	}

	public void atirar() {
		int frenteDaNave = this.x + this.largura;
		int meioDaNave = this.y + (this.altura / 2);
		Tiro tiro = new Tiro(frenteDaNave, meioDaNave);
		this.tiros.add(tiro);
	}

	public void mover(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		switch (codigo) {
		case KeyEvent.VK_UP:
			dy = -3;
			break;
		case KeyEvent.VK_DOWN:
			dy = 3;
			break;
		case KeyEvent.VK_LEFT:
			dx = -3;
			break;
		case KeyEvent.VK_RIGHT:
			dx = 3;
			break;
		case KeyEvent.VK_SPACE:
			atirar();
			break;
		default:
			break;
		}
	}

	public void parar(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		switch (codigo) {
		case KeyEvent.VK_UP:
			dy = 0;
			break;
		case KeyEvent.VK_DOWN:
			dy = 0;
			break;
		case KeyEvent.VK_LEFT:
			dx = 0;
			break;
		case KeyEvent.VK_RIGHT:
			dx = 0;
			break;
		default:
			break;
		}
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

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public ArrayList<Tiro> getTiros() {
		return tiros;
	}

	public void setTiros(ArrayList<Tiro> tiros) {
		this.tiros = tiros;
	}

}
