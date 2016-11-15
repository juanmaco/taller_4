import processing.core.PApplet;

public class Logica {
PApplet app;
Puck puck;
Jugador jugadores;
Poder poderes;
// UN ENTERO PARA MANEJAR EL CAMBIO DE PANTALLAS
private int pantallas=0;
private PImage;

public Logica(PApplet app){
	this.app=app;
	puck = new Puck(app);
	jugadores= new Jugador(app);
	poderes = new Poder(app);
}
public void pintar(){
	puck.pintar();
	jugadores.pintar();
	poderes.pintar();
	//posicionMouse();
	
}

public void posicionMouse(){
	if(app.mousePressed==true){
		System.out.println(app.mouseX +" "+ app.mouseY);
	}
}

public void pantallas(){
	switch(pantallas){
	//PANTALLA QUE EXPLICA COMO SE SELECCIONAN LAS OPCIONES
	case 0:
		break;
	//PANTALLA DE INICIO
	case 1:
		break;
	//INSTRUCCIONES 1
	case 2:
		break;
	//INSTRUCCIONES 2
	case 3:
		break;
	//INSTRUCCIONES 3
	case 4:
		break;
	//INSTRUCCIONES 4
	case 5:
		break;
	//PANTALLA DONDE SE JUEGA
	case 6:
		break;
	
	//PANTALLA DEL GANADOR
	case 7:
		break;
	}
}
}