package Ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 350);
        setLocationRelativeTo(null);
        setTitle("Reservar Habitación");
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(235, 222, 207));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        //Título
        JLabel lblTitulo = new JLabel("RESERVAR HABITACIÓN");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setBounds(110, 10, 250, 35);
        contentPane.add(lblTitulo);

        //Número de habitación
        JLabel lblNumHabitacion = new JLabel("Número de habitación:");
        lblNumHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNumHabitacion.setBounds(158, 69, 138, 20);
        contentPane.add(lblNumHabitacion);

        // ComboBox con las 10 habitaciones
        String[] habitaciones = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        JComboBox<String> comboHabitacion = new JComboBox<>(habitaciones);
        comboHabitacion.setBounds(168, 100, 96, 25);
        contentPane.add(comboHabitacion);

        //Tipo de habitación
        JLabel lblTipoHabitacion = new JLabel("Tipo de habitación:");
        lblTipoHabitacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblTipoHabitacion.setBounds(158, 149, 118, 20);
        contentPane.add(lblTipoHabitacion);

        // ComboBox con los tipos de habitación
        String[] tipos = {"Suite", "Normal", "Doble"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);
        comboTipo.setBounds(168, 180, 96, 25);
        contentPane.add(comboTipo);

        //Botón Guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(255, 255, 255));
        btnGuardar.setBounds(175, 237, 89, 25);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String numHabitacion = (String) comboHabitacion.getSelectedItem();
                String tipoHabitacion = (String) comboTipo.getSelectedItem();

                try {
                    conexion.conectar();

                    String sentencia = "INSERT INTO Reservas (Numero_Habitacion, TipoHabitacion) VALUES ('"
                            + numHabitacion + "', '" + tipoHabitacion + "')";

                    int filas = conexion.ejecutarInsertDeleteUpdate(sentencia);

                    if (filas > 0) {
                        JOptionPane.showMessageDialog(null,
                                "Reserva guardada con éxito.\n"
                                + "Habitación nº " + numHabitacion
                                + " — Tipo: " + tipoHabitacion);
                    }

                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Error al guardar la reserva: " + e1.getMessage());
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
                new Ventana_1().setVisible(true); // Regresa al menú principal
                dispose();
            }
        });
        contentPane.add(btnVolver);
    }
}