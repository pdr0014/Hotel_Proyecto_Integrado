package Clases_Hotel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		ConexionMySQL X=new ConexionMySQL("root","","dam");
		try {
			X.conectar();
			/*
			String nombre="Juanillo";
			int edad=0;
			
			String sentencia="INSERT INTO EMPLEADOS (NOMBRE,EDAD) VALUES ('"+nombre+"',"+edad+")";
			
			X.ejecutarInsertDeleteUpdate(sentencia);
			*/
			
			String busqueda="SELECT * FROM EMPLEADOS";
			ResultSet datos= X.ejecutarSelect(busqueda);
			
			while(datos.next())
			{
				String nombre=datos.getString("nombre");
				int edad=datos.getInt("edad");
				System.out.print(nombre+" "+(edad+100)+"\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
