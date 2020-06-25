package paranavai.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener, KeyListener{
	private Image fundo;
	private Personagem personagem;
	private Timer timer;
	private ArrayList<Inimigo> inimigos;
	
	private static int QTDE_DE_INIMIGOS = 40;
	private static final int LARGURA_DA_TELA = 938;
	
	public Fase(){
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon carregando = new ImageIcon("recursos\\fundo.jpg");
		fundo = carregando.getImage();
		
		personagem = new Personagem();
		personagem.carregar();
		
		inicializaInimigos();
		
		addKeyListener(this);
		
		timer = new Timer(5, this);
		timer.start();
	}
	
	public void inicializaInimigos() {
		inimigos = new ArrayList<Inimigo>();
		
		for (int i = 0; i < QTDE_DE_INIMIGOS; i++) {
			int x = (int)(Math.random() * 8000 + 1024);
			int y = (int)(Math.random() * 650 + 30);
			Inimigo inimigo = new Inimigo(x, y);
			inimigos.add(inimigo);
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(personagem.getImagem(), personagem.getX(), personagem.getY(), this);
		
		ArrayList<Tiro> tiros = personagem.getTiros();
		
		for (int i = 0; i < tiros.size(); i++) {
			Tiro tiro = tiros.get(i);
			tiro.carregar();
			graficos.drawImage(tiro.getImagem(), tiro.getX(), tiro.getY(), this);
		}
		
		for (int i = 0; i < inimigos.size(); i++) {
			Inimigo inimigo = inimigos.get(i);
			inimigo.carregar();
			graficos.drawImage(inimigo.getImagem(), inimigo.getX(), inimigo.getY(), this);
		}
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		personagem.atualizar();
		
		ArrayList<Tiro> tiros = personagem.getTiros();
		
		for (int i = 0; i < tiros.size(); i++) {
			Tiro tiro = tiros.get(i);
			if(tiro.getX() > LARGURA_DA_TELA) {
				tiros.remove(tiro);
			}else {
				tiro.atualizar();
			} 
		}
		
		for (int i = 0; i < inimigos.size(); i++) {
			Inimigo inimigo = inimigos.get(i);
			if(inimigo.getX() < 0) {
				inimigos.remove(inimigo);
			}else {
				inimigo.atualizar();
			} 
		}
		
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		personagem.mover(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		personagem.parar(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}