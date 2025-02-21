
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    //parametros para la conexion a la base de datos
    static public String url="jdbc:mysql://localhost:3306/bd_internet";
    static public String usuario="root";
    static public String password="";
    protected Connection conn = null;
    
    public ConexionDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            if(conn != null){
                System.out.println("Conexion Ok: " + conn);
            }
        }catch(SQLException ex){
            System.out.println("Error de SQL: " + ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Falta Driver:"+ex.getMessage());
         }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        System.out.println("Cerrando la BD:" + conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }
}
