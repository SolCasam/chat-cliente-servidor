package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import controlador.ControladorServidor;

public class ModeloServidor extends Thread{
	private ControladorServidor controlador;
	final int puerto = 40080;
	ServerSocket sk;
	Socket socket;
	BufferedReader br;
	BufferedWriter bw;

	public ControladorServidor getControlador() {
		return controlador;
	}

	public void setControlador(ControladorServidor controlador) {
		this.controlador = controlador;
	}
	
	public void abrirPuerto() {
		try {
			sk = new ServerSocket(puerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void esperarAlCliente() {
		try {
			socket = sk.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void crearFlujos() {
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			br= new BufferedReader(isr);

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osr = new OutputStreamWriter(os);
			bw= new BufferedWriter(osr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enviarMensaje(String mensaje) {
		try {
			bw.write(mensaje);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String recibirMensaje() {
		try {
			String mensaje = br.readLine();
			return mensaje;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public void run() {
		while(true) {
			String mensaje = recibirMensaje();
			controlador.añadirMensajeEnTrasiego("El Cliente dice: " + mensaje);
		}
	}
}
