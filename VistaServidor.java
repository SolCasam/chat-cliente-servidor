package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorServidor;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class VistaServidor extends JFrame implements IVistaServidor{

	private JPanel contentPane;
	private JTextField txtTextoEnviar;
	private JButton btnEnviar;
	private JTextArea textAreaTrasiego;
	private ControladorServidor controlador;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaServidor frame = new VistaServidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaServidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textAreaTrasiego = new JTextArea();
		textAreaTrasiego.setBounds(45, 46, 437, 312);
		contentPane.add(textAreaTrasiego);
		
		JLabel lblTextoAEnviar = new JLabel("Texto a enviar:");
		lblTextoAEnviar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTextoAEnviar.setBounds(45, 386, 92, 21);
		contentPane.add(lblTextoAEnviar);
		
		txtTextoEnviar = new JTextField();
		txtTextoEnviar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTextoEnviar.setBounds(136, 387, 346, 19);
		contentPane.add(txtTextoEnviar);
		txtTextoEnviar.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(397, 416, 85, 21);
		contentPane.add(btnEnviar);
	}

	@Override
	public void habilitarEnviar() {
		btnEnviar.enable();
	}

	@Override
	public void deshabilitarEnviar() {
		btnEnviar.disable();
	}

	@Override
	public void añadirMensajeEnTrasiego(String mensaje) {
		textAreaTrasiego.append(mensaje + "\n");
	}

	@Override
	public void borrarTextoAEnviar() {
		txtTextoEnviar.setText("");
	}

	@Override
	public void setControlador(ControladorServidor controlador) {
		this.controlador=controlador;
	}

	@Override
	public void hacerVisible() {
		setVisible(true);
	}
	
	@Override
	public void inicializar() {
		btnEnviar.setActionCommand(enviar);
		btnEnviar.addActionListener(controlador);
	}

	@Override
	public String getMensajeAEnviar() {
		return txtTextoEnviar.getText();
	}
}
