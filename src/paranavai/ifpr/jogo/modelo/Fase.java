package paranavai.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener, KeyListener{
	private Image fundo;
	private Personagem personagem;
	private Timer timer;
	
	public Fase(){
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon carregando = new ImageIcon("recursos\\fundo.jpg");
		fundo = carregando.getImage();
		
		personagem = new Personagem();
		personagem.carregar();
		
		addKeyListener(this);
		
		timer = new Timer(5, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		//graficos.drawImage(personagem.getImagem(), personagem.getX(), personagem.getY(), this);
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		personagem.atualizar();
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
	
	//https://www.youtube.com/watch?v=fyxwEWfQifE&list=PLlW3qrNjsvBwUmUk9kio7bNT3GR554FH5&index=7
}