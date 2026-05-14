package Ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(442, 384);
        setLocationRelativeTo(null);
        setTitle("Añadir Cliente");

        contentPane = new JPanel();
        contentPane.setBackground(new Color(235, 222, 207));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Título
        JLabel lblTitulo = new JLabel("AÑADIR CLIENTE");
        lblTitulo.setForeground(new Color(0, 0, 0));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setBounds(125, 10, 176, 35);
        contentPane.add(lblTitulo);

        // Nombre
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNombre.setForeground(new Color(0, 0, 0));
        lblNombre.setBounds(57, 55, 60, 20);
        contentPane.add(lblNombre);
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(113, 55, 200, 20);
        contentPane.add(txtNombre);

        // Apellidos
        JLabel lblApellidos = new JLabel("Apellidos:");
        lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblApellidos.setBounds(52, 86, 60, 20);
        contentPane.add(lblApellidos);
        JTextField txtApellidos = new JTextField();
        txtApellidos.setBounds(113, 85, 200, 20);
        contentPane.add(txtApellidos);

        // Teléfonoo
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTelefono.setBounds(52, 116, 65, 20);
        contentPane.add(lblTelefono);
        JTextField txtTelefono = new JTextField();
        txtTelefono.setBounds(113, 115, 200, 20);
        contentPane.add(txtTelefono);

        // DNI
        JLabel lblDni = new JLabel("DNI:");
        lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblDni.setBounds(75, 146, 37, 20);
        contentPane.add(lblDni);
        JTextField txtDni = new JTextField();
        txtDni.setBounds(113, 145, 200, 20);
        contentPane.add(txtDni);

        // Email
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEmail.setBounds(70, 177, 37, 20);
        contentPane.add(lblEmail);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(113, 175, 200, 20);
        contentPane.add(txtEmail);

        // Dirección
        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblDireccion.setBounds(52, 208, 59, 20);
        contentPane.add(lblDireccion);
        JTextField txtDireccion = new JTextField();
        txtDireccion.setBounds(113, 205, 200, 20);
        contentPane.add(txtDireccion);

        // Código Postal
        JLabel lblCodPostal = new JLabel("Cód. Postal:");
        lblCodPostal.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCodPostal.setBounds(40, 235, 71, 20);
        contentPane.add(lblCodPostal);
        JTextField txtCodPostal = new JTextField();
        txtCodPostal.setBounds(113, 235, 200, 20);
        contentPane.add(txtCodPostal);

        // Ciudad
        JLabel lblCiudad = new JLabel("Ciudad:");
        lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCiudad.setBounds(62, 266, 55, 20);
        contentPane.add(lblCiudad);
        JTextField txtCiudad = new JTextField();
        txtCiudad.setBounds(113, 265, 200, 20);
        contentPane.add(txtCiudad);

        // Botón Guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(255, 255, 255));
        btnGuardar.setBounds(153, 316, 120, 25);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() ||
                    txtDni.getText().isEmpty() || txtTelefono.getText().isEmpty() ||
                    txtEmail.getText().isEmpty() || txtDireccion.getText().isEmpty() ||
                    txtCiudad.getText().isEmpty() || txtCodPostal.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos.");
                    return;
                }

                String nombre = txtNombre.getText();
                String apellidos = txtApellidos.getText();
                String dni = txtDni.getText();
                int telefono = Integer.parseInt(txtTelefono.getText());
                String email = txtEmail.getText();
                String direccion = txtDireccion.getText();
                String ciudad = txtCiudad.getText();
                String codPostal = txtCodPostal.getText();

                try {
                    conexion.conectar();
                    String sentencia = "INSERT INTO Clientes (DNI, Nombre, Apellidos, Email, Telefono, Dir_Calle, Dir_Ciudad, Dir_CP) VALUES ('"
                        + dni + "', '" + nombre + "', '" + apellidos + "', '" + email + "', '"
                        + telefono + "', '" + direccion + "', '" + ciudad + "', '" + codPostal + "')";
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

        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(255, 255, 255));
        btnVolver.setBounds(0, 0, 89, 23);
        btnVolver.addActionListener(new ActionListener() {
        	
        	//VOLVER A VENTANA PRINCIPAL
            public void actionPerformed(ActionEvent e) {
                new Ventana_1().setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVolver);

        setResizable(false);
        
    }
} 