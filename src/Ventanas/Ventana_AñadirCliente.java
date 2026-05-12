package Ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Ventana_AñadirCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_AñadirCliente frame = new Ventana_AñadirCliente();
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
	public Ventana_AñadirCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setBounds(100, 100, 450, 300);
	    setLocationRelativeTo(null);
	    setTitle("Añadir Cliente");
	    
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(null);
	    setContentPane(contentPane);
	    
	 // Título
	    JLabel lblTitulo = new JLabel("AÑADIR CLIENTE");
	    lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblTitulo.setBounds(140, 10, 200, 35);
	    contentPane.add(lblTitulo);

	    
	 // Nombre
	    JLabel lblNombre = new JLabel("Nombre:");
	    lblNombre.setBounds(20, 60, 80, 20);
	    contentPane.add(lblNombre);
	    
	    
	    JTextField txtNombre = new JTextField();
	    txtNombre.setBounds(110, 60, 200, 20);
	    contentPane.add(txtNombre);

	    // DNI
	    JLabel lblDni = new JLabel("DNI:");
	    lblDni.setBounds(20, 95, 80, 20);
	    contentPane.add(lblDni);

	    JTextField txtDni = new JTextField();
	    txtDni.setBounds(110, 95, 200, 20);
	    contentPane.add(txtDni);
	    
	    
	 // Teléfono
	    JLabel lblTelefono = new JLabel("Teléfono:");
	    lblTelefono.setBounds(20, 130, 80, 20);
	    contentPane.add(lblTelefono);

	    JTextField txtTelefono = new JTextField();
	    txtTelefono.setBounds(110, 130, 200, 20);
	    contentPane.add(txtTelefono);

	    // Botón Guardar
	    JButton btnGuardar = new JButton("Guardar");
	    btnGuardar.setBounds(150, 200, 120, 25);
	    btnGuardar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Aquí irá la lógica para guardar el cliente
	            System.out.println("Cliente guardado");
	        }
	    });
	    contentPane.add(btnGuardar);
	}

}
