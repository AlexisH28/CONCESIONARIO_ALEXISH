package MODELO.CONEXION;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String name = "Vehiculos";
    private static final String url = "jdbc:postgresql://localhost:5432/" + name;
    private static final String user = "campus2023";
    private static final String password = "campus2023";

    private static Connection conexion;
    private static Conexion instancia;

    private Conexion(){}

    public Connection getConexion(){
        try{
            conexion = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
}

