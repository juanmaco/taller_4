import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import de.voidplus.leapmotion.*;

public class Jugador {
	PApplet app;
	LeapMotion leap;
	Puck puck;

	// Se crea un PImage que dependiendo del brazo, sera una imagen distinta
	private PImage imagen;
	// SE CREAN CUATRO VARIABLES QUE SERAN LAS POSICIONES DE LOS JUGADORES

	private float posX1, posY1, posX2, posY2;
	private float pposX1, pposY1, pposX2, pposY2;

	public Jugador(PApplet app) {
		this.app = app;
		leap = new LeapMotion(app);
		puck = new Puck(app);

	}

	public void pintar() {
		app.fill(255, 0, 0);
		app.ellipse(app.mouseX, app.mouseY, 10, 10);
		mano();
	}

	public void mano() {

		int fps = leap.getFrameRate();
		for (Hand hand : leap.getHands()) {

			// ==================================================
			// 2. Hand

			int handId = hand.getId();
			PVector handPosition = hand.getPosition();
			PVector handStabilized = hand.getStabilizedPosition();
			PVector handDirection = hand.getDirection();
			PVector handDynamics = hand.getDynamics();
			float handRoll = hand.getRoll();
			float handPitch = hand.getPitch();
			float handYaw = hand.getYaw();
			boolean handIsLeft = hand.isLeft();
			boolean handIsRight = hand.isRight();
			float handGrab = hand.getGrabStrength();
			float handPinch = hand.getPinchStrength();
			float handTime = hand.getTimeVisible();
			PVector spherePosition = hand.getSpherePosition();
			float sphereRadius = hand.getSphereRadius();

			posX1 = hand.getPosition().x;
			posY1 = hand.getPosition().y;

			posX2 = hand.getPosition().x;
			posY2 = hand.getPosition().y;
			
			pposX1 = hand.getPosition().x-1;
			pposY1 = hand.getPosition().y-1;

			pposX2 = hand.getPosition().x-1;
			pposY2 = hand.getPosition().y-1;

			// hand.draw();
			/*
			 * SI LA MANO ES IZQUIERDA VA A EJECUTAR LO SIGUIENTES VA A PINTAR
			 * UNA ELLIPSE EN LA POSICION DE LA MANO Y SI ESTA POSICION ES MAYOR
			 * A 600, LA POSICION DE LA ELLIPSE SERA IGUAL A 600 PARA DELIMITAR
			 * EL LIMITE DE MOVIMIENTO
			 */
			if (hand.isLeft()) {
				if (posX1 < 600) {
					app.fill(255, 0, 0);
					app.ellipse(posX1, posY1, 50, 50);
					
					if (PApplet.dist(puck.getLocation().x, puck.getLocation().y, posX1,posY1)<50) {
						puck.getVelocidad().x *= -1;
						puck.getAceleracion().x *= -1;

				}
			}
			}
			/*
			 * SI LA MANO ES DERECHA VA A EJECUTAR LO SIGUIENTES VA A PINTAR UNA
			 * ELLIPSE EN LA POSICION DE LA MANO Y SI ESTA POSICION ES MAYOR A
			 * 600, LA POSICION DE LA ELLIPSE SERA IGUAL A 600 PARA DELIMITAR EL
			 * LIMITE DE MOVIMIENTO
			 */

			if (hand.isRight()) {
				if (posX2 > app.width - 600) {
					app.fill(0, 255, 0);
					app.ellipse(posX2, posY2, 50, 50);

//					if (puck.location.x < posX2) {
//						puck.velocidad.x *= -1;
//						puck.aceleracion.x *= -1;
//					}
				}
			}
		}

	}

	public float getDx() {
		float posManox = 0;
		for (Hand hand : leap.getHands()) {

			// ==================================================
			// 2. Hand

			int handId = hand.getId();
			PVector handPosition = hand.getPosition();
			PVector handStabilized = hand.getStabilizedPosition();
			PVector handDirection = hand.getDirection();
			PVector handDynamics = hand.getDynamics();
			float handRoll = hand.getRoll();
			float handPitch = hand.getPitch();
			float handYaw = hand.getYaw();
			boolean handIsLeft = hand.isLeft();
			boolean handIsRight = hand.isRight();
			float handGrab = hand.getGrabStrength();
			float handPinch = hand.getPinchStrength();
			float handTime = hand.getTimeVisible();
			PVector spherePosition = hand.getSpherePosition();
			float sphereRadius = hand.getSphereRadius();
			posManox = posManox + hand.getPosition().x;

			posX1 = hand.getPosition().x;
			posY1 = hand.getPosition().y;
		}
		return posManox;
	}

	public float getPosX1() {
		return posX1;
	}

	public void setPosX1(float posX1) {
		this.posX1 = posX1;
	}

	public float getPosY1() {
		return posY1;
	}

	public void setPosY1(float posY1) {
		this.posY1 = posY1;
	}

	public float getPosX2() {
		return posX2;
	}

	public void setPosX2(float posX2) {
		this.posX2 = posX2;
	}

	public float getPosY2() {
		return posY2;
	}

	public void setPosY2(float posY2) {
		this.posY2 = posY2;
	}

	public float getPposX1() {
		return pposX1;
	}

	public void setPposX1(float pposX1) {
		this.pposX1 = pposX1;
	}

	public float getPposY1() {
		return pposY1;
	}

	public void setPposY1(float pposY1) {
		this.pposY1 = pposY1;
	}

	public float getPposX2() {
		return pposX2;
	}

	public void setPposX2(float pposX2) {
		this.pposX2 = pposX2;
	}

	public float getPposY2() {
		return pposY2;
	}

	public void setPposY2(float pposY2) {
		this.pposY2 = pposY2;
	}

}
