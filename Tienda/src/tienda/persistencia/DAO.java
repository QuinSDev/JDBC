package tienda.persistencia;

import java.sql.*;

public abstract class DAO {
    
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    
    protected void conectarBase() throws ClassNotFoundException, SQLException {
        
        try {
            Class.forName(DRIVER);
            String urlBaseDatos = "jdbc:mysql://localhost:3306/" + DATABASE + 
                    "?useSSL=FALSE";
            conexion = DriverManager.getConnection(urlBaseDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        
    }
    
    protected void disconnectBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    protected void insertModifyEliminate(String sql) throws Exception {
        
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            disconnectBase();
        }
    }
    
    protected void consultDataBase(String sql) throws Exception {
        
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception e) {
            throw e;
        }
        
    }
    
}
