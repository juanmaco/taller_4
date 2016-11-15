import processing.core.PApplet;

public class Main extends PApplet {
	
	// metodo para poder exportarse como una aplicacipon, NO TOCAR
		static public void main(String[] passedArgs) {
			PApplet.main("Main");
		}
		
		public Logica logica;
		public void settings(){
			fullScreen();
		}
		public void setup(){
			logica= new Logica(this);
		}
		public void draw(){
			background(255);
			logica.pintar();
		}
}
