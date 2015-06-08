package util;

import general.MysqlConnect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class BaseDatos {
	
	// S�lo vale para consultas del tipo SELECT * FROM
	// Par�metros:  String - la consulta de la que queremos saber el n�mero de registros
	//                       que devolver�.
	// Devuelve:	int    - n�mero de registros de la consulta.
	
	public static int countRows(String consulta){
		ResultSet rs = null;
		MysqlConnect m = null;   
		int rowCount = -1;
                String sqlQueryCount;

		m = MysqlConnect.getDbCon();
                
                if(consulta.startsWith("SELECT *") == true)
                    sqlQueryCount = consulta.replaceFirst("\\*", "COUNT(*)");
                else
                    sqlQueryCount = consulta;
                
		try {
                    if (consulta.startsWith("SELECT *") == true) {
                        rs = m.query(sqlQueryCount);
                        rs.first();
                        // La primera y �nica columna que devuelve es el n�mero de registros.
                        rowCount = rs.getInt(1);
                    }else{
                        rs = m.query(sqlQueryCount);
                        rowCount = rs.getMetaData().getColumnCount();
                    }
                    rs.close();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,
					"Error en recuento registros (countRows)!!!");

				e.printStackTrace();
		}
                

		return rowCount;
	}
	
	public static int borraRegistro(String strSqlDelete){
		ResultSet rs = null;
		MysqlConnect m = null;   
		int rowCount = -1;

		m = MysqlConnect.getDbCon();
		

		try {
			rowCount = m.insert(strSqlDelete);
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,
					"Error en borrado de registros (borraRegistro)!!!");
				e.printStackTrace();
		}

		return rowCount;
	}
	
	public static ResultSet sqlToRecordSet(String consulta){
		ResultSet rs = null;
		MysqlConnect m = null;   

		m = MysqlConnect.getDbCon();
		String strSql = consulta;

		try {
			rs = m.query(strSql);			
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,
					"Error en sqlToRecordSet!!!");
                        e.printStackTrace();
		}

		return rs;
	}
}
