package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ModeloServidor;
import vista.IVistaServidor;

public class ControladorServidor implements ActionListener{
	IVistaServidor vista;
	ModeloServidor modelo;
	
	public ControladorServidor(IVistaServidor vista, ModeloServidor modelo) {
		this.vista=vista;
		this.modelo=modelo;
	}

	public void arrancar() {
		vista.hacerVisible();
		vista.inicializar();
		vista.aņadirMensajeEnTrasiego("Abriendo el puerto");
		modelo.abrirPuerto();
		vista.aņadirMensajeEnTrasiego("Esperando al cliente...");
		modelo.esperarAlCliente();
		modelo.crearFlujos();
		modelo.start();
	}
	
	public IVistaServidor getVista() {
		return vista;
	}

	public void setVista(IVistaServidor vista) {
		this.vista = vista;
	}

	public ModeloServidor getModelo() {
		return modelo;
	}

	public void setModelo(ModeloServidor modelo) {
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case IVistaServidor.enviar:
			vista.aņadirMensajeEnTrasiego("Enviando mensaje al cliente...");
			modelo.enviarMensaje(vista.getMensajeAEnviar());
			vista.aņadirMensajeEnTrasiego("Mensaje enviando");
			vista.borrarTextoAEnviar();
			break;
		}
	}
	
	public void aņadirMensajeEnTrasiego(String mensaje) {
		vista.aņadirMensajeEnTrasiego(mensaje);
	}
	
}
