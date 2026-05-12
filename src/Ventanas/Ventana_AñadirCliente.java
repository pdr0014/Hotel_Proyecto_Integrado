package Ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

public class Ventana_AñadirCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public ConexionMySQL conexion=new ConexionMySQL("root","","hotel_reservas");
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    
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

    public Ventana_AñadirCliente() {
    	setSize(450, 350); //TAMAÑO DE LA VENTANA 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setTitle("Añadir Cliente");

        contentPane = new JPanel();
        contentPane.setBackground(new Color(235, 222, 207));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Título
        JLabel lblTitulo = new JLabel("AÑADIR CLIENTE");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setBounds(141, 10, 152, 35);
        contentPane.add(lblTitulo);

        // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(71, 49, 41, 20);
        contentPane.add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(117, 49, 200, 20);
        contentPane.add(txtNombre);

        // DNI
        JLabel lblDni = new JLabel("DNI:");
        lblDni.setBounds(90, 140, 22, 20);
        contentPane.add(lblDni);

        JTextField txtDni = new JTextField();
        txtDni.setBounds(117, 109, 200, 20);
        contentPane.add(txtDni);

        // Teléfono
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(66, 109, 46, 20);
        contentPane.add(lblTelefono);

        JTextField txtTelefono = new JTextField();
        txtTelefono.setBounds(117, 140, 200, 20);
        contentPane.add(txtTelefono);

        // Botón Guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(255, 255, 255));
        btnGuardar.setBounds(345, -1, 89, 25);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Comprobamos que los campos no estén vacíos
                if (txtNombre.getText().isEmpty() || txtDni.getText().isEmpty()
                        || txtTelefono.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos.");
                    return;
                }

                //Recogemos los datos de los campos
                String nombre = txtNombre.getText();
                String dni = txtDni.getText();
                int telefono = Integer.parseInt(txtTelefono.getText());


                try {
                    conexion.conectar();
                    
                    String sentencia = "INSERT INTO Clientes (DNI, Nombre, Apellidos, Email, Telefono) VALUES ('"
                        + dni + "', '" + nombre + "', '', '', '" + telefono + "')";
                    
                    int filas = conexion.ejecutarInsertDeleteUpdate(sentencia);
                    
                    if (filas > 0) {
                        JOptionPane.showMessageDialog(null, "Cliente " + nombre + " guardado con éxito.");
                    }
                    
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Error al guardar: " + e1.getMessage());
                }
            }
        });
        contentPane.add(btnGuardar);

        // BOTON VOLVER
        JButton btnNewButton = new JButton("Volver");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(0, 0, 89, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new Ventana_1().setVisible(true);//REGRESA A LA VENTANA
                dispose();//ESTO CIERA LA VENTANA
            }
        });
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Apellidos:");
        lblNewLabel.setBounds(66, 80, 46, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Email:");
        lblNewLabel_1.setBounds(84, 174, 28, 14);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Dirección:");
        lblNewLabel_2.setBounds(65, 205, 47, 14);
        contentPane.add(lblNewLabel_2);
        
        textField = new JTextField();
        textField.setBounds(117, 78, 200, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(117, 171, 200, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(117, 202, 200, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField();
        textField_3.setBounds(178, 233, 86, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Ciudad");
        lblNewLabel_3.setBounds(343, 158, 46, 14);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Codigo Postal");
        lblNewLabel_4.setBounds(28, 236, 84, 14);
        contentPane.add(lblNewLabel_4);

        setResizable(false);
    }
} 