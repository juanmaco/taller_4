import processing.core.PApplet;

import com.leapmotion.leap.Leap;

import de.voidplus.leapmotion.*;
import processing.core.PVector;

public class Puck {
	PApplet app;
	// SE CREA UNA INSTANCIA DE LA CLASE JUGADORES
	Jugador jugadores;
	LeapMotion leap;
	// SE CREAN LOS VECTORES QUE MANEJARAN EL MOVIMIENTO DEL PUCK
	public PVector location;
	public PVector velocidad;
	public PVector aceleracion;
	// VECTORES PARA LOS GOLPES
	public PVector golpeDerArriba, aceleraciongolpeDerArriba;
	public PVector golpeDerAbajo;
	public PVector golpeIzqArriba;
	public PVector golpeIzqAbajo;
	// SE CREA UNA VARIABLE QUE MANEJARA LA DIRECCION VERTICAL DE MANERA RANDOM
	private int direccion;
	// SE CREA UNA VARIABLE QUE MANEJA LA VELOCIDAD MAXIMA DE LA VELOCIDAD
	private int vMax = 10;

	// SE CREA UNA BOOLEANO PARA IDENFIFICAR QUE JUGADOR HA TOCADO EL PUCK
	private boolean jugador;
	// SE CREAN 1 VARIABLES QUE MANEJAN LA VELOCIDAD SEGÚN EL PODER QUE SE
	// ACTIVE
	private int poderVel = 0;
	// UNA VARIABLE PARA MANEJAR EL TIEMPO DE LOS PODERES
	private int tPoderes = 0;
	// DOS VARIABLES PARA LAS VIDAS DE LOS JUGADORES
	private int vidaI = 100;
	private int vidaD = 100;

	public Puck(PApplet app) {
		this.app = app;

		direccion = (int) app.random(5, 15);
		location = new PVector(app.width / 2, 200);
		velocidad = new PVector(0 + poderVel, 0);
		aceleracion = new PVector(5, 0);

		// VECTORES DEL GOLPE
		aceleraciongolpeDerArriba = new PVector (1,1);
		golpeDerArriba = new PVector(15, direccion);
		golpeDerAbajo = new PVector(-15, -direccion);
		golpeIzqArriba = new PVector(-15, direccion);
		golpeIzqAbajo = new PVector(-15, -direccion);

		leap = new LeapMotion(app);

	}

	// SE CREA UN PINTAR QUE CONTENDRA EL MOVER Y LOS LIMITES DEL MOVIMIENTO
	public void pintar() {
		app.fill(255);
		app.ellipse(location.x, location.y, 50, 50);
		mover();
		golpe();
		// golpeDerecho();
		// golpeIzquierdo();
	}

	public void mover() {
		if (location.y >= app.height) {
			velocidad.y *= -1;
			aceleracion.y *= -1;

		}
		if (location.y <= 0) {
			velocidad.y *= -1;
			aceleracion.y *= -1;
		}
		if (location.x >= app.width) {
			velocidad.x *= -1;
			aceleracion.x *= -1;
		}
		if (location.x <= 0) {
			velocidad.x *= -1;
			aceleracion.x *= -1;
		}

		velocidad.add(aceleracion);
		velocidad.limit(vMax);
		location.add(velocidad);

	}

	public void golpe() {
		if(app.mouseY>601){
		if (location.x >= app.mouseX) {
			velocidad.x *= -1;
			aceleracion.x *= -1;
		} }else {
			if (app.mouseX <= app.width - 600) {
				app.mouseX = app.width - 600;

			}
		}
		if (location.x >= app.mouseX) {
			if (app.mouseY < 600) {
				
				velocidad.add(aceleracion);
				velocidad.limit(vMax);
				
				velocidad.x*=-1;
				velocidad.y*=-1;
				
				aceleracion.x*=-1;
				aceleracion.y*=-1;
				
				aceleraciongolpeDerArriba.x*=-1;
				aceleraciongolpeDerArriba.y*=-1;
				
				
				golpeDerArriba.add(aceleraciongolpeDerArriba);
				
				
				location.add(golpeDerArriba);
			
				
				
			}
		}
	}

	public void golpeDerecho() {
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

			if (location.x > jugadores.getPosX2()) {
				velocidad.x *= -1;
				aceleracion.x *= -1;
			}
		}
	}

	public void golpeIzquierdo() {
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

			if (PApplet.dist(location.x, location.y, jugadores.getPosX1(), jugadores.getPosY1()) < 50) {
				velocidad.x *= -1;
				aceleracion.x *= -1;
			}
		}
	}

	// ---------------------------V A L I D A R J U G A D O
	// R-------------------------------------
	public void validarJugador() {
		if (PApplet.dist(location.x, location.y, jugadores.getPosX1(), jugadores.getPosY1()) < 50) {
			jugador = true;
		}
		if (PApplet.dist(location.x, location.y, jugadores.getPosX2(), jugadores.getPosY2()) < 50) {
			jugador = false;
		}
	}

	// --------------------------- P O D E R E
	// S--------------------------------------------
	public void masvel() {
		if (app.keyCode == '1') {
			tPoderes++;
			poderVel = 10;
		}
		if (tPoderes == 10) {
			poderVel = 0;
			tPoderes = 0;
		}
	}

	public void menosvel() {
		if (app.keyCode == '2') {
			tPoderes++;
			poderVel -= 5;
		}
		if (tPoderes == -5) {
			poderVel = 0;
			tPoderes = 0;
		}

	}

	public void masvida() {
		// FALTA LA LOGICA DE QUE JUGADOR ACTIVA EL PODER
		if (app.keyCode == '3') {
			vidaD += 5;
		}
	}

	public void masdano() {
		if (app.keyCode == '4') {
			vidaD -= 15;
		}
	}

	public PVector getLocation() {
		return location;
	}

	public void setLocation(PVector location) {
		this.location = location;
	}

	public PVector getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(PVector velocidad) {
		this.velocidad = velocidad;
	}

	public PVector getAceleracion() {
		return aceleracion;
	}

	public void setAceleracion(PVector aceleracion) {
		this.aceleracion = aceleracion;
	}

	// public PVector getGolpeDer() {
	// return golpeDer;
	// }
	//
	// public void setGolpeDer(PVector golpeDer) {
	// this.golpeDer = golpeDer;
	// }

	public int getvMax() {
		return vMax;
	}

	public void setvMax(int vMax) {
		this.vMax = vMax;
	}
}