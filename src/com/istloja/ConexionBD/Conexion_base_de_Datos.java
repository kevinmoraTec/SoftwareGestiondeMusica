package com.istloja.ConexionBD;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ConnectionImpl;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;

/**
 *
 * @author danielmora
 */
public class Conexion_base_de_Datos {
    
    // static = pertenece a la  clase y no tiene objetos .
    
    
    private static final String url ="jdbc:mysql://localhost:8889/gestionMusica?autoReconnect=true&useSSL=false";
    private static final String usuario = "root";
    private static final String contraseña ="root";
    
    public static Connection conexionMysql(){
    
        Connection conexion= null;// Creamos un objeto de tipo Connection
        try{// manejador de errore para evitar que nsustras aplicaciones se rompan 
            Class.forName("com.mysql.jdbc.Driver");//  Class.forName ·"registra el driver de conexión para la base de datos. "
            conexion = (Connection) DriverManager.getConnection(url,usuario,contraseña);// llamamos a driver manager y realizamos la conexion;
            System.out.println("Conexion Exitosa !");
        }catch(Exception e){
            System.out.println("Error Conexion Base de datos"+e.getMessage());
        }
        return conexion;
        
    }
    
    
}
