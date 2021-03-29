package chatservidor;

import controlador.ControladorCliente;
import modelo.ModeloCliente;
import vista.IVistaCliente;
import vista.VistaCliente;

public class ChatCliente {

	public static void main(String[] args) {
		IVistaCliente vista = new VistaCliente();
		ModeloCliente modelo= new ModeloCliente();
		
		ControladorCliente controlador = new ControladorCliente(vista, modelo);
		
		vista.setControlador(controlador);
		modelo.setControlador(controlador);
		
		controlador.arrancar();
	}
}
