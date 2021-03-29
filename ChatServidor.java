package chatservidor;

import controlador.ControladorServidor;
import modelo.ModeloServidor;
import vista.IVistaServidor;
import vista.VistaServidor;

public class ChatServidor {

	public static void main(String[] args) {
		IVistaServidor vista = new VistaServidor();
		ModeloServidor modelo= new ModeloServidor();
		
		ControladorServidor controlador = new ControladorServidor(vista, modelo);
		
		vista.setControlador(controlador);
		modelo.setControlador(controlador);
		
		controlador.arrancar();
	}
}
