package Ventanas;

import java.awt.Color;
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


public class Ventana_EliminarReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ConexionMySQL conexion = new ConexionMySQL("root", "", "hotel_reservas");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_EliminarReserva frame = new Ventana_EliminarReserva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Ventana_EliminarReserva() {
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setSize(650, 400);
	    setLocationRelativeTo(null);
	    setTitle("Eliminar Reserva");

	    contentPane = new JPanel();
	    contentPane.setBackground(new Color(235, 222, 207));
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(null);
	    setContentPane(contentPane);

	    // Título
	    JLabel lblTitulo = new JLabel("ELIMINAR RESERVA");
	    lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblTitulo.setBounds(230, 10, 174, 35);
	    contentPane.add(lblTitulo);

	    // Tabla
	    String[] columnas = {"ID", "FK_Cliente", "FK_Habitacion", "Fecha Entrada", "Fecha Salida", "Estado Pago"};
	    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
	    JTable tabla = new JTable(modelo);
	    JScrollPane scrollPane = new JScrollPane(tabla);
	    scrollPane.setBounds(12, 55, 610, 250);
	    contentPane.add(scrollPane);

	    // Cargar datos de la base de datos
	    try {
	        conexion.conectar();
	        ResultSet rs = conexion.ejecutarSelect("SELECT * FROM reservas");
	        while (rs.next()) {
	            Object[] fila = {
	                rs.getString("ID_Reserva"),
	                rs.getString("FK_Cliente"),
	                rs.getString("FK_Habitacion"),
	                rs.getString("Fecha_Entrada"),
	                rs.getString("Fecha_Salida"),
	                rs.getString("Estado_Pago")
	            };
	            modelo.addRow(fila);
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error al cargar reservas: " + e.getMessage());
	    }

	    // Botón Eliminar
	    JButton btnEliminar = new JButton("Eliminar Reserva");
	    btnEliminar.setBackground(new Color(255, 255, 255));
	    btnEliminar.setBounds(242, 315, 150, 25);
	    btnEliminar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int filaSeleccionada = tabla.getSelectedRow();
	            if (filaSeleccionada == -1) {
	                JOptionPane.showMessageDialog(null, "Selecciona una reserva para eliminar.");
	                return;
	            }
	            String idReserva = modelo.getValueAt(filaSeleccionada, 0).toString();
	            try {
	                conexion.ejecutarInsertDeleteUpdate("DELETE FROM reservas WHERE ID_Reserva = " + idReserva);
	                modelo.removeRow(filaSeleccionada);
	                JOptionPane.showMessageDialog(null, "Reserva eliminada con éxito.");
	            } catch (SQLException e1) {
	                JOptionPane.showMessageDialog(null, "Error al eliminar: " + e1.getMessage());
	            }
	        }
	    });
	    contentPane.add(btnEliminar);

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

	    setResizable(false);
	}
}
