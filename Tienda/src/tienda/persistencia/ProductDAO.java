package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Product;

public final class ProductDAO extends DAO{
    
    public Collection<Product> consultProducts() throws Exception {
        
        try {
            
            String sql = "SELECT nombre FROM producto";
            consultDataBase(sql);
            Product product = null;
            Collection<Product> products = new ArrayList();
            
            while (resultado.next()) {                
                product = new Product();
                product.setName(resultado.getString("nombre"));
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
            consultDataBase(sql);
            Product product = null;
            Collection<Product> products = new ArrayList();
            
            while (resultado.next()) {                
                product = new Product();
                product.setName(resultado.getString(1));
                product.setPrice(resultado.getDouble(2));
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
    
     public Collection<Product> consultPriceRange() throws Exception {
        
        try {
            String sql = "SELECT * FROM producto "
                    + "WHERE precio BETWEEN 120 AND 202";
            consultDataBase(sql);
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
     
     public Collection<Product> consultProductPortatil() throws Exception {
         
         try {
             String sql = "SELECT * FROM producto WHERE nombre LIKE '%Portatil%'";
             consultDataBase(sql);
             Product produc = null;
             Collection<Product> products = new ArrayList();
             
             while (resultado.next()) {                 
                 produc = new Product();
                 produc.setCode(resultado.getInt(1));
                 produc.setName(resultado.getString(2));
                 produc.setPrice(resultado.getInt(3));
                 produc.setManufacturerCode(resultado.getInt(4));
                 products.add(produc);
             }
             disconnectBase();
             return products;
         } catch (Exception e) {
             e.printStackTrace();
             disconnectBase();
             throw new Exception("Errpr sistema");
         }
         
     }
     
     public Collection<Product> consultProductMin() throws Exception {
         
         try {
             
             String sql = "SELECT p.nombre, p.precio FROM producto p "
                     + "WHERE p.precio = (SELECT MIN(precio) FROM producto)";
             
             consultDataBase(sql);
             Product product = null;
             Collection<Product> products = new ArrayList();
             
             while (resultado.next()) {                 
                 product = new Product();
                 product.setName(resultado.getString(1));
                 product.setPrice(resultado.getDouble(2));
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
     
     public void saveProduct(Product product) throws Exception {
         
         try {
             
             if (product == null) {
                 throw new Exception("You must indicate a product");
             }
             
             String sql = "INSERT INTO producto (nombre, precio, "
                     + "codigo_fabricante) VALUES ('"+ product.getName() + "' , '" 
                     + product.getPrice() + "' , "
                     + "'" + product.getManufacturerCode() + "');";
             
             insertModifyEliminate(sql);
             
         } catch (Exception e) {
             throw e;
         } finally {
             disconnectBase();
         }
         
     }
     
     public void modifyProduct(Product product) throws Exception {
         
         try {
             
             if (product == null) {
                 throw new Exception("You must indicate the product you want "
                         + "to modify!");
             }
             
             String sql = "UPDATE Producto SET precio = '" + product.getPrice() +
                     "' WHERE codigo = '" + product.getCode() + "'";
             
             insertModifyEliminate(sql);
             
         } catch (Exception e) {
             throw e;
         } finally {
             disconnectBase();
         }
         
     }
     
     public Product searchProductForCode(String code) throws Exception {
         
         try {
             
             String sql = "SELECT * FROM producto WHERE codigo = '" + code + "'";
             
             consultDataBase(sql);
             
             Product product = null;
             while (resultado.next()) {                 
                 product = new Product();
                 product.setCode(resultado.getInt(1));
                 product.setName(resultado.getString(2));
                 product.setPrice(resultado.getDouble(3));
                 product.setManufacturerCode(resultado.getInt(4));
             }
             disconnectBase();
             return product;
         } catch (Exception e) {
             disconnectBase();
             throw e;
         }
         
     }
}
