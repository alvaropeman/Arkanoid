package codigo;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador extends GRect  {
	GLabel texto =new GLabel("");
	int puntuacion =0;
	public Marcador(double width, double height) {
		super(width, height);
		setFilled(true);
		setFillColor(Color.BLACK);
		texto.setLabel(" 0");
		texto.setColor(Color.WHITE);
		texto.setFont(new Font("Arial", Font.BOLD , 18));
	}


	//suma el numero de puntos al marcador
	public void incrementaMarcador (int puntos){
		puntuacion=puntuacion+puntos;//puntuacion+=puntos;
		texto.setLabel(""+puntuacion);
	}
	public void addMarcador(Arkanoid arkanoid){
		arkanoid.add(this, arkanoid.getWidth() -100, 20);
		arkanoid.add(texto, arkanoid.getWidth() -180, 200);
	}
}
