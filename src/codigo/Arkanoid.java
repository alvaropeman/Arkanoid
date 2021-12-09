package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Arkanoid extends GraphicsProgram {

	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 19;
	static final int ANCHO_PANTALLA = 520;
	//int ANCHO_LADRILLO2 = 50;
	//static final int ALTO_LADRILLO2 = 30;

	Cursor2 miCursor = new Cursor2("fotos/colchoneta .png",0,400);
	Bola2 Bola2 = new Bola2 ("fotos/homero.png",10,10);
	
	GImage fondo = new GImage("fotos/turismo-espacio-viajes.jpg");
	GImage cabeceraMarc = new GImage("fotos/marcado1.jpg");
	GImage marcador2 = new GImage("fotos/marcador2.jpg");
	GImage pantalladeinicio = new GImage("fotos/introArkanoid.png");
	GImage start = new GImage ("fotos/presiona.jpg",200,125);
	GImage gameOver = new GImage ("fotos/GameOver.png");
	GImage reStart = new GImage("fotos/reStart.jpg");
	GImage nivel1 = new GImage ("fotos/nestLevel.jpg");
	GImage victory = new GImage ("Fotos/winerChikenDiner.png");
	GImage corazon1 =new GImage ("fotos/vida.jpg");
	GImage corazon2 =new GImage ("fotos/vida.jpg");
	GImage corazon3 =new GImage ("fotos/vida.jpg");
	GImage lives =new GImage ("fotos/lives.jpg");
	Vidas mivida = new Vidas (20,60);
	GRect fondoMarcador = new GRect(300, 600);
	Marcador miMarcador = new Marcador(20,40);
	GRect foto1 = new GRect(20, 15);
	public void init(){


		add(fondo);
		fondoMarcador.setFilled(true);
		add(fondoMarcador, ANCHO_PANTALLA- 30,0);
		
		add(marcador2,530,185);
		add(corazon1,530,275);
		add(corazon2,560,275);
		add(corazon3,590,275);
		add(lives,530,240);
		addMouseListeners();
		add(Bola2,40,100);
		add(miCursor);
		add(mivida);
		add(pantalladeinicio);
		add(start);
		add(cabeceraMarc,500,10);
		setSize(ANCHO_PANTALLA + 300 ,500);
	}

	public void run() {
		waitForClick();

		remove(pantalladeinicio);
		remove(start);
		creaPiramide();
		creaPiramide2();
		miMarcador.addMarcador(this);
		mivida.addVidas(this);
		while (true){
			if (mivida.vidas <3){
				remove(corazon1);
			}
			if (mivida.vidas <2){
				remove(corazon2);
			}
			if (mivida.vidas <1){
				remove(corazon3);
			}
			if( Bola2.getY()-40>miCursor.getY()){
				if(mivida.vidas<0){
				remove(Bola2);
				remove(miCursor);
				mivida.vidas=3;
				miMarcador.puntuacion=0;
				add(gameOver);
				add(reStart,150,200);
				waitForClick();
				init();
				run();}
			}
			
			if(miMarcador.puntuacion==1465){
				remove(Bola2);
				remove(miCursor);
				miMarcador.puntuacion=0;
				add(gameOver);
				add(reStart,150,200);
				victory.setSize(200,100);
				add(victory,550,300);
				waitForClick();
				init();
				run();
			}
			if( miMarcador.puntuacion==995){
				remove(Bola2);
				nivel1.setSize(ANCHO_PANTALLA,500);
				add(nivel1);
				waitForClick();
				remove(nivel1);
				creaPiramide3();
				miMarcador.incrementaMarcador(10);
				add(Bola2);
			}
			Bola2.muevete(this); //paso el objeto arkanoid que se esta ejecutando
			pause(0);
			miCursor.muevete(ANCHO_PANTALLA -30, (int) Bola2.getX());
		}}
	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(ANCHO_PANTALLA - 30, evento.getX());
	}
	RandomGenerator aleatorio = new RandomGenerator();

	int numero1 = aleatorio.nextInt(1,2);
	

	private void creaPiramide(){

		int numeroLadrillos = 13;
		int desplazamiento_inicial_X = 15;
		int desplazamiento_inicial_Y = 15;

		for (int j=0; j<numeroLadrillos; j++){

			for (int i=j; i<numeroLadrillos; i++){
				Ladrillo2 miLadrillo = new Ladrillo2 ("fotos/hamburguesa2.png");
				miLadrillo.setSize(ANCHO_LADRILLO , ALTO_LADRILLO);

				add(miLadrillo,ANCHO_LADRILLO*i-ANCHO_LADRILLO /2*j+desplazamiento_inicial_X,ALTO_LADRILLO*j+desplazamiento_inicial_Y);

			}
		}
		
		Bonus miBonus = new Bonus ("fotos/burro.png");
		miBonus.setSize(ANCHO_LADRILLO +10 , ALTO_LADRILLO+10);
		add(miBonus,300,300);
		
	
	}
	private void creaPiramide2(){

		int numeroLadrillos = 9;
		int desplazamiento_inicial_X = 15;
		int desplazamiento_inicial_Y = 15;

		for (int j=0; j<numeroLadrillos; j++){

			for (int i=j; i<numeroLadrillos; i++){
				LadrilloDuro miLadrilloDuro = new LadrilloDuro ("fotos/hamburguesa.jpg");
				miLadrilloDuro.setSize(ANCHO_LADRILLO , ALTO_LADRILLO);
				add(miLadrilloDuro,ANCHO_LADRILLO*i-ANCHO_LADRILLO /2*j+desplazamiento_inicial_X+70,ALTO_LADRILLO*j+desplazamiento_inicial_Y);

			}
		}
	
	}
	private void creaPiramide3(){

		int numeroLadrillos = 9;
		int desplazamiento_inicial_X = 15;
		int desplazamiento_inicial_Y = 15;

		for (int j=0; j<numeroLadrillos; j++){

			for (int i=j; i<numeroLadrillos; i++){
				LadrilloDuro miLadrilloDuro = new LadrilloDuro ("fotos/spaceinvaders.png");
				miLadrilloDuro.setSize(ANCHO_LADRILLO , ALTO_LADRILLO);
				add(miLadrilloDuro,ANCHO_LADRILLO*i-ANCHO_LADRILLO /2*j+desplazamiento_inicial_X+70,ALTO_LADRILLO*j+desplazamiento_inicial_Y);	
		
			}
		}}
}


