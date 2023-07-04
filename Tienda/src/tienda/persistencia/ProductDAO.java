package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Product;

public final class ProductDAO extends DAO{
    
    public Collection<Product> consultProducts() throws Exception {
        
        try {
            
            String sql = "SELECT nombre FROM producto";
            consulteDataBase(sql);
            Product product = null;
            Collection<Product> products = new ArrayList();
            
            while (resultado.next()) {                
                product = new Product();
                product.setName(resultado.getString(1));
                products.add(product);
            }
            disconnectBase();
            return products;
            
        } catch (Exception e) {
            e.printStackTrace();
            disconnectBase();
            throw new Exception("Error de sistema");
        }
    }
    
    public Collection<Product> consultNamePrice() throws Exception {
        
        try {
            String sql = "SELECT nombre, precio FROM producto";
            consulteDataBase(sql);
            Product product = null;
            Collection<Product> products = new ArrayList();
            
            while (resultado.next()) {                
                product = new Product();
                product.setName(resultado.getString(1));
                product.setPrice(resultado.getInt(2));
                products.add(product);
            }
            disconnectBase();
            return products;
            
        } catch (Exception e) {
            e.printStackTrace();
            disconnectBase();
            throw new Exception("Error de sistema");
        }
        
    }
    
     public Collection<Product> consultPridceRange() throws Exception {
        
        try {
            String sql = "SELECT * FROM producto "
                    + "WHERE precio BETWEEN 120 AND 202";
            consulteDataBase(sql);
            Product product = null;
            Collection<Product> products = new ArrayList();
            
            while (resultado.next()) {                
                product = new Product();
                product.setCode(resultado.getInt(1));
                product.setName(resultado.getString(2));
                product.setPrice(resultado.getInt(3));
                product.setManufacturerCode(resultado.getInt(4));
                products.add(product);
            }
            disconnectBase();
            return products;
            
        } catch (Exception e) {
            e.printStackTrace();
            disconnectBase();
            throw new Exception("Error de sistema");
        }
        
    }
}
