package codigo;



import acm.graphics.GImage;
import acm.graphics.GObject;


public class Bola2 extends GImage {
	int dx = 1; //velocidad en el eje x
	int dy = 1; //velocidad en el eje y

	public Bola2(String name, double x, double y) {
		super(name);

	}public void muevete(Arkanoid ark){
		//rebote con el suelo y rebote con el techo
		if (getY() > ark.getHeight() || getY() < 10){
			if(getY()>ark.getHeight()) {
				
				ark.mivida.disminulleMarcadorDeVidas(1); 
			}
			dy = dy * -1;
		}


		//rebote con la pared derecha y rebote con la pared izquierda
		if (getX()+getWidth() > ark.ANCHO_PANTALLA - 30 || getX() < 10){
			dx = dx * -1;
		}

		//chequeo la esquina superior izquierda de la bola
		if (chequeaColision(getX(),	getY(), ark) ){
			if (chequeaColision(getX() + getWidth(), getY(), ark) ){
				if (chequeaColision(getX(),	getY()+getHeight(), ark) ){
					if (chequeaColision(getX()+getWidth(), getY()+getHeight(), ark) ){

					}
				}
			}
		}

		//mueve la bola en la direccion correcta
		this.move(dx,dy);
	}
	private boolean chequeaColision(double posx, double posy, Arkanoid ark){
		boolean noHaChocado = true;
		GObject auxiliar;

		auxiliar = ark.getElementAt(posx, posy);

		if (auxiliar == ark.miCursor){ //si entra aqui es que choca con el cursor
			dy = dy * -1;
			noHaChocado = false;
		}else if (auxiliar == null){ //si vale null es que no habia nada ahi

		}else if (auxiliar instanceof Ladrillo2){ //si es un ladrillo
			if (auxiliar.getX() + getWidth() >= posx || auxiliar.getY() <= posx){
				dx = dx * -1;
			}
			if (auxiliar.getY() + getHeight() >= posy || auxiliar.getY() <= posy){
				dy = dy * -1;
			}
			{
				ark.miMarcador.incrementaMarcador(5); 
			}

			ark.remove(auxiliar);//borro el ladrillo
			noHaChocado = false;
		}
		if (auxiliar instanceof LadrilloDuro){ //si es un ladrillo
			if (auxiliar.getX() + getWidth() >= posx || auxiliar.getY() <= posx){
				dx = dx * -1;
			}
			if (auxiliar.getY() + getHeight() >= posy || auxiliar.getY() <= posy){
				dy = dy * -1;
			}
			{
				ark.miMarcador.incrementaMarcador(10); 
			}
			ark.remove(auxiliar);
			noHaChocado = false;
		}
		if (auxiliar instanceof Bonus){ //si es un ladrillo
			if (auxiliar.getX() + getWidth() >= posx || auxiliar.getY() <= posx){
				dx = dx * -1;
			}
			if (auxiliar.getY() + getHeight() >= posy || auxiliar.getY() <= posy){
				dy = dy * -1;
			}
			{
				ark.miMarcador.incrementaMarcador(100); 
			}
			ark.remove(auxiliar);
			noHaChocado = false;
		}
		return noHaChocado;
	}
	

		
		

		
}

