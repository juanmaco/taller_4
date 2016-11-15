import processing.core.PApplet;
import processing.core.PVector;

public class Poder {
	private PApplet app;
	//SE CREAN LOS VECTORES PARA EL PODER DE VIDA
	private PVector locationVIDA, velocidadVIDA, aceleracionVIDA;
	//SE CREAN LOS VECTORES PARA EL PODER DE DANO
	private PVector locationDANO,velocidadDANO, aceleracionDANO;
	//SE CREAN LOS VECOTRES PARA EL PODER DE MAS VELOCIDAD
	private PVector locationMASVEL,velocidadMASVEL, aceleracionMASVEL;
	//SE CREAN LOS VECOTRES PARA EL PODER DE MENOS VELOCIDAD
	private PVector locationMENOSVEL,velocidadMENOSVEL, aceleracionMENOSVEL;
	
	
	
public Poder(PApplet app){
	this.app=app;
	
	//SE INICIALIZAN LOS VECTORES PARA VIDA
	locationVIDA = new PVector(app.width/2,1000);
	velocidadVIDA = new PVector(0,1);
	aceleracionVIDA = new PVector(0,1);
	
	//SE INICIALIZAN LOS VECTORES PARA MAS VELOCIDAD
	locationMASVEL = new PVector(app.width/2,700);
	velocidadMASVEL = new PVector(0,1);
	aceleracionMASVEL = new PVector(0,1);
	
	//SE INICIALIZAN LOS VECTORES PARA VIDA MENOS VELOCIDAD
	locationMENOSVEL = new PVector(app.width/2,0);
	velocidadMENOSVEL = new PVector(0,1);
	aceleracionMENOSVEL = new PVector(0,1);
	
	//SE INICIALIZAN LOS VECTORES PARA DANO
	locationDANO = new PVector(app.width/2,251);
	velocidadDANO = new PVector(0,1);
	aceleracionDANO = new PVector(0,1);
	
}
public void pintar(){
//	masVida();
//	masVel();
//	menosVel();
//	dano();
}
//------------------PODERES PARTE SUPERIOR---------------------------------------------------
public void dano(){
	app.fill(255,0,0);
	app.ellipse(locationDANO.x, locationDANO.y, 50, 50);
	app.noFill();
	
	velocidadDANO.add(aceleracionDANO);
	velocidadDANO.limit(10);
	locationDANO.add(velocidadDANO);
	
	//SE DEFINE EL RANGO LIMITE DE MOVIMIENTO..
	if(locationDANO.y<250){
		velocidadDANO.y*=-1;
		aceleracionDANO.y*=-1;
	}
	if(locationDANO.y>500){
		velocidadDANO.y*=-1;
		aceleracionDANO.y*=-1;
	}
}
public void menosVel(){
	app.fill(0,255,0);
	app.ellipse(locationMENOSVEL.x, locationMENOSVEL.y, 50, 50);
	app.noFill();
	
	velocidadMENOSVEL.add(aceleracionMENOSVEL);
	velocidadMENOSVEL.limit(10);
	locationMENOSVEL.add(velocidadMENOSVEL);
	
	//SE DEFINE EL RANGO LIMITE DE MOVIMIENTO
	if(locationMENOSVEL.y<0){
		velocidadMENOSVEL.y*=-1;
	aceleracionMENOSVEL.y*=-1;
	}
	if(locationMENOSVEL.y>250){
		velocidadMENOSVEL.y*=-1;
		aceleracionMENOSVEL.y*=-1;
	}
}



//------------------PODERES PARTE INFERIOR---------------------------------------------------
public void masVel(){
	app.fill(255,200,50);
	app.ellipse(locationMASVEL.x, locationMASVEL.y, 50, 50);
	app.noFill();
	
	velocidadMASVEL.add(aceleracionMASVEL);
	velocidadMASVEL.limit(10);
	locationMASVEL.add(velocidadMASVEL);
	
	//SE DEFINE EL RANGO LIMITE DE MOVIMIENTO
	if(locationMASVEL.y<app.height-500){
		velocidadMASVEL.y*=-1;
		aceleracionMASVEL.y*=-1;
	}
	if(locationMASVEL.y>app.height-250){
		velocidadMASVEL.y*=-1;
		aceleracionMASVEL.y*=-1;
	}
}
public void masVida(){
	
	app.fill(255,100,0);
	app.ellipse(locationVIDA.x, locationVIDA.y, 50, 50);
	app.noFill();
	
	velocidadVIDA.add(aceleracionVIDA);
	velocidadVIDA.limit(10);
	locationVIDA.add(velocidadVIDA);
	
	//SE DEFINE EL RANGO LIMITE DE MOVIMIENTO
	if(locationVIDA.y<app.height-250){
		velocidadVIDA.y*=-1;
		aceleracionVIDA.y*=-1;
	}
	if(locationVIDA.y>app.height){
		velocidadVIDA.y*=-1;
		aceleracionVIDA.y*=-1;
	}
	
}

}
