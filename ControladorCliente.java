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
		vista.añadirMensajeEnTrasiego("Conectando con el Servidor...");
		modelo.conectarConElServidor();
		vista.añadirMensajeEnTrasiego("Esperando al Servidor...");
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
			vista.añadirMensajeEnTrasiego("Enviando mensaje al Servidor...");
			modelo.enviarMensaje(vista.getMensajeAEnviar());
			vista.añadirMensajeEnTrasiego("Mensaje enviando");
			vista.borrarTextoAEnviar();
			break;
		}
	}
	
	public void añadirMensajeEnTrasiego(String mensaje) {
		vista.añadirMensajeEnTrasiego(mensaje);
	}
	
}
