package Ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Ventana_ReservarHabitacion extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public ConexionMySQL conexion = new ConexionMySQL("root", "", "hotel_reservas");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventana_ReservarHabitacion frame = new Ventana_ReservarHabitacion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Ventana_ReservarHabitacion() {
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Reservar Habitación");
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(235, 222, 207));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Título
        JLabel lblTitulo = new JLabel("RESERVAR HABITACIÓN");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setBounds(100, 10, 270, 35);
        contentPane.add(lblTitulo);

        // DNI Clientee
        JLabel lblCliente = new JLabel("DNI Cliente:");
        lblCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblCliente.setBounds(40, 60, 80, 20);
        contentPane.add(lblCliente);
        JTextField txtCliente = new JTextField();
        txtCliente.setBounds(140, 60, 200, 20);
        contentPane.add(txtCliente);

        // Nº Habitación
        JLabel lblHabitacion = new JLabel("Nº Habitación:");
        lblHabitacion.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblHabitacion.setBounds(40, 95, 90, 20);
        contentPane.add(lblHabitacion);
        String[] habitaciones = {"101", "102", "103", "201", "202", "203", "204", "301", "302", "303"};
        JComboBox<String> comboHabitacion = new JComboBox<>(habitaciones);
        comboHabitacion.setBounds(140, 95, 100, 25);
        contentPane.add(comboHabitacion);

        // Tipo (se rellena automáticamente)
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTipo.setBounds(40, 130, 80, 20);
        contentPane.add(lblTipo);
        JLabel lblTipoValor = new JLabel("-");
        lblTipoValor.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblTipoValor.setBounds(140, 130, 150, 20);
        contentPane.add(lblTipoValor);

        // Precio Noche (se rellena automáticamente)
        JLabel lblPrecio = new JLabel("Precio/Noche:");
        lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblPrecio.setBounds(40, 160, 90, 20);
        contentPane.add(lblPrecio);
        JLabel lblPrecioValor = new JLabel("-");
        lblPrecioValor.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblPrecioValor.setBounds(140, 160, 150, 20);
        contentPane.add(lblPrecioValor);

        // Fecha Entrada
        JLabel lblEntrada = new JLabel("Fecha Entrada:");
        lblEntrada.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEntrada.setBounds(40, 195, 95, 20);
        contentPane.add(lblEntrada);
        JTextField txtEntrada = new JTextField("YYYY-MM-DD");
        txtEntrada.setBounds(140, 195, 150, 20);
        contentPane.add(txtEntrada);

        // Fecha Salida
        JLabel lblSalida = new JLabel("Fecha Salida:");
        lblSalida.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblSalida.setBounds(40, 225, 95, 20);
        contentPane.add(lblSalida);
        JTextField txtSalida = new JTextField("YYYY-MM-DD");
        txtSalida.setBounds(140, 225, 150, 20);
        contentPane.add(txtSalida);


        // Cuando se cambia la habitación, actualizar tipo y precio
        comboHabitacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numHab = (String) comboHabitacion.getSelectedItem();
                try {
                    conexion.conectar();
                    java.sql.ResultSet rs = conexion.ejecutarSelect(
                        "SELECT Tipo, Precio_Noche FROM habitaciones WHERE Numero_Hab = " + numHab);
                    if (rs.next()) {
                        lblTipoValor.setText(rs.getString("Tipo"));
                        lblPrecioValor.setText(rs.getString("Precio_Noche") + " €");
                    }
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Error al cargar habitación: " + e1.getMessage());
                }
            }
        });

        // Cargar datos de la primera habitación al abrir
        try {
            conexion.conectar();
            java.sql.ResultSet rs = conexion.ejecutarSelect(
                "SELECT Tipo, Precio_Noche FROM habitaciones WHERE Numero_Hab = 101");
            if (rs.next()) {
                lblTipoValor.setText(rs.getString("Tipo"));
                lblPrecioValor.setText(rs.getString("Precio_Noche") + " €");
            }
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
        }

        // Botón Guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(255, 255, 255));
        btnGuardar.setBounds(160, 305, 120, 25);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (txtCliente.getText().isEmpty() ||
                        txtEntrada.getText().equals("YYYY-MM-DD") ||
                        txtSalida.getText().equals("YYYY-MM-DD")) {
                        JOptionPane.showMessageDialog(null, "Por favor, rellena todos los campos.");
                        return;
                    }

                    String dniCliente = txtCliente.getText();
                    String habitacion = (String) comboHabitacion.getSelectedItem();
                    String fechaEntrada = txtEntrada.getText();
                    String fechaSalida = txtSalida.getText();

                    try {
                        conexion.conectar();

                        // Verificar si el cliente existe
                        ResultSet rsCliente = conexion.ejecutarSelect(
                            "SELECT DNI FROM clientes WHERE DNI = '" + dniCliente + "'");
                        if (!rsCliente.next()) {
                            JOptionPane.showMessageDialog(null, "Error: El cliente con DNI " + dniCliente + " no existe.");
                            return;
                        }

                        // Verificar si la habitación está disponible
                        ResultSet rsHab = conexion.ejecutarSelect(
                            "SELECT Estado FROM habitaciones WHERE Numero_Hab = " + habitacion);
                        if (rsHab.next() && !rsHab.getString("Estado").equals("O")) {
                            JOptionPane.showMessageDialog(null, "Error: La habitación " + habitacion + " no está disponible.");
                            return;
                        }

                        // Verificar que la fecha de salida sea posterior a la entrada
                        if (fechaSalida.compareTo(fechaEntrada) <= 0) {
                            JOptionPane.showMessageDialog(null, "Error: La fecha de salida debe ser posterior a la de entrada.");
                            return;
                        }

                        // Insertar la reserva
                        String sentencia = "INSERT INTO reservas (FK_Cliente, FK_Habitacion, Fecha_Entrada, Fecha_Salida) VALUES ('"
                                + dniCliente + "', " + habitacion + ", '" + fechaEntrada + "', '" + fechaSalida + "')";
                        int filas = conexion.ejecutarInsertDeleteUpdate(sentencia);
                        if (filas > 0) {
                            // Actualizar estado de la habitación a Ocupada
                            conexion.ejecutarInsertDeleteUpdate(
                                "UPDATE habitaciones SET Estado = 'O' WHERE Numero_Hab = " + habitacion);
                            JOptionPane.showMessageDialog(null, "Reserva guardada con éxito.");
                        }

                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, "Error de conexión: " + e1.getMessage());
                    }
                }
            });
        contentPane.add(btnGuardar);

        // Botón Volver
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBackground(new Color(255, 255, 255));
        btnVolver.setBounds(0, 0, 89, 23);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Ventana_1().setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnVolver);
    }
}