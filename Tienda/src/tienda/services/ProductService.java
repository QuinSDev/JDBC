package tienda.services;

import java.util.Collection;
import tienda.entidades.Product;
import tienda.persistencia.ProductDAO;

public class ProductService {
    
    private ProductDAO pDao;

    public ProductService() {
        pDao = new ProductDAO();
    }
    
    public void printProducts() throws Exception {
        
        try {
            
            Collection<Product> products = pDao.consultProducts();
            
            if (products.isEmpty()) {
                throw new Exception("No hay productos para imprimi");
            } else {
                System.out.println("Nombre");
                for (Product product : products) {
                    System.out.println(product.getName());
                }
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    
}
