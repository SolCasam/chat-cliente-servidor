package vista;

import controlador.ControladorServidor;

public interface IVistaServidor {
	final String enviar="Enviar";
	
	public void habilitarEnviar();
	public void deshabilitarEnviar();
	public void a�adirMensajeEnTrasiego(String mensaje);
	public void borrarTextoAEnviar();
	public void setControlador(ControladorServidor controlador);
	public void hacerVisible();
	public void inicializar();
	public String getMensajeAEnviar();
}
