package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ModeloCliente;
import vista.IVistaCliente;

public class ControladorCliente implements ActionListener{
	IVistaCliente vista;
	ModeloCliente modelo;
	
	public ControladorCliente(IVistaCliente vista, ModeloCliente modelo) {
		this.vista=vista;
		this.modelo=modelo;
	}

	public void arrancar() {
		vista.hacerVisible();
		vista.inicializar();
		vista.aņadirMensajeEnTrasiego("Conectando con el Servidor...");
		modelo.conectarConElServidor();
		vista.aņadirMensajeEnTrasiego("Esperando al Servidor...");
		modelo.crearFlujos();
		modelo.start();
	}
	
	public IVistaCliente getVista() {
		return vista;
	}

	public void setVista(IVistaCliente vista) {
		this.vista = vista;
	}

	public ModeloCliente getModelo() {
		return modelo;
	}

	public void setModelo(ModeloCliente modelo) {
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case IVistaCliente.enviar:
			vista.aņadirMensajeEnTrasiego("Enviando mensaje al Servidor...");
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
