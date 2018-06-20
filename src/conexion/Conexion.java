/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.*;

/**
 *
 * @author intel
 */
public class Conexion {
    
    private String user;
    private String pass;
    private String driver;
    private String url;
    
    private Connection cnx;
    
    public static Conexion instance;
    
    public synchronized static Conexion conectar(){
        if (instance==null)
            instance= new Conexion();
        return instance;
    }
    
    private Conexion(){
        cargarCredenciales();
        
        try{
            Class.forName(this.driver);
            cnx= (Connection) DriverManager.getConnection(this.url,
                    this.user, this.pass);
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error de conexion");
        }
    }
    
    private void cargarCredenciales(){
        user="root";
        pass="";
        driver="com.mysql.jdbc.Driver";
        url="jdbc:mysql://localhost/filtros_aceite";
    }
    
    public Connection getCnx(){return cnx;}
    
    public void cerrarConexion(){instance=null;}
}
