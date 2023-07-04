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
}
