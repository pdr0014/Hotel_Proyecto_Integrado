package Ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class Ventana_EstadoHabitacion extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public ConexionMySQL conexion = new ConexionMySQL("root", "", "hotel_reservas");

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ventana_EstadoHabitacion frame = new Ventana_EstadoHabitacion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Ventana_EstadoHabitacion() {
        setSize(472, 435);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Estado de Habitaciones");
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(235, 222, 207));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        //Título
        JLabel lblTitulo = new JLabel("ESTADO DE HABITACIONES");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setBounds(98, 21, 259, 35);
        contentPane.add(lblTitulo);

        //Leyenda
        JLabel lblLeyenda = new JLabel("D = Disponible   |   O = Ocupada   |   M = Mantenimiento");
        lblLeyenda.setFont(new Font("Tahoma", Font.ITALIC, 10));
        lblLeyenda.setBounds(92, 53, 272, 15);
        contentPane.add(lblLeyenda);

        //Tabla
        String[] columnas = {"Nº Habitación", "Tipo", "Estado"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabla = new JTable(modeloTabla);
        tabla.setFont(new Font("Tahoma", Font.PLAIN, 12));
        tabla.setRowHeight(24);
        tabla.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        tabla.getTableHeader().setBackground(new Color(200, 185, 170));

        // Centrar contenido de todas las columnas
        javax.swing.table.DefaultTableCellRenderer centrado =
            new javax.swing.table.DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        for (int i = 0; i < columnas.length; i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(50, 79, 355, 255);
        contentPane.add(scrollPane);

        //Cargar datos desde la base de datos
        cargarEstados(modeloTabla);

        //Botón Volver 
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

    private void cargarEstados(DefaultTableModel modelo) {
        try {
            conexion.conectar();

            String sql =
                "SELECT h.Numero_Hab, h.Tipo, " +
                "  CASE " +
                "    WHEN h.Estado = 'M' THEN 'M' " +
                "    WHEN r.FK_Habitacion IS NOT NULL THEN 'O' " +
                "    ELSE 'D' " +
                "  END AS Estado " +
                "FROM habitaciones h " +
                "LEFT JOIN reservas r " +
                "  ON h.Numero_Hab = r.FK_Habitacion " +
                "  AND CURDATE() BETWEEN r.Fecha_Entrada AND r.Fecha_Salida " +
                "ORDER BY h.Numero_Hab";

            ResultSet rs = conexion.ejecutarSelect(sql);

            while (rs.next()) {
                String numHab = rs.getString("Numero_Hab");
                String tipo   = rs.getString("Tipo");
                String estado = rs.getString("Estado");
                modelo.addRow(new Object[]{numHab, tipo, estado});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar estados: " + e.getMessage());
        }
    }
}