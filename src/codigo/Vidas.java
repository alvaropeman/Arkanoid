package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Vidas extends GRect  {
	GLabel texto1 =new GLabel("");
	int vidas =3;
	public Vidas(double width, double height) {
		super(width, height);
		setFilled(true);
		setFillColor(Color.BLACK);
		texto1.setLabel(" 3");
		texto1.setColor(Color.WHITE);
		texto1.setFont(new Font("Arial", Font.BOLD , 18));
	}


	//suma el numero de puntos al marcador
	public void disminulleMarcadorDeVidas (int puntosDeVida){
		vidas=vidas-puntosDeVida;//puntuacion+=puntos;
		texto1.setLabel(""+vidas);
	}
	public void incrementaMarcadorDeVidas (int puntosDeVida){
		vidas=vidas+puntosDeVida;//puntuacion+=puntos;
		texto1.setLabel(""+vidas);
	}
	public void addVidas(Arkanoid arkanoid){
		arkanoid.add(this, arkanoid.getWidth() -90, 20);
		arkanoid.add(texto1, arkanoid.getWidth() -190, 300);
	}
}
