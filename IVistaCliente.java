package vista;

import controlador.ControladorCliente;

public interface IVistaCliente {
	final String enviar="Enviar";
	
	public void habilitarEnviar();
	public void deshabilitarEnviar();
	public void a�adirMensajeEnTrasiego(String mensaje);
	public void borrarTextoAEnviar();
	public void setControlador(ControladorCliente controlador);
	public void hacerVisible();
	public void inicializar();
	public String getMensajeAEnviar();
}
