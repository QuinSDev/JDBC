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
    
    public void namePriceProducts() throws Exception {
        
        try {
            Collection<Product> products = pDao.consultNamePrice();
            
            if (products.isEmpty()) {
                throw new Exception("No hay productos para imprimi");
            } else {
                System.out.println("Nombre/Precio");
                for (Product product : products) {
                    System.out.println(product.getName() + "        " 
                            + product.getPrice());
                }
            }
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public void listProducts() throws Exception {
        try {
            Collection<Product> products = pDao.consultPridceRange();
            
            if (products.isEmpty()) {
                throw new Exception("No hay productos para imprimir");
            } else {
                System.out.println("Nombre/Precio");
                for (Product product : products) {
                    System.out.println(product.getCode() + "\n" + 
                            product.getName() + "\n" 
                            + product.getPrice()); 
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void productPortatil() {
        
        try {
            Collection<Product> products = pDao.consultProductPortatil();
            
            if (products.isEmpty()) {
                System.out.println("Lista vac�a");
            } else {
                for (Product product : products) {
                    System.out.println(product);
                }
            }
        } catch (Exception e) {
        }
        
    }
    
    public void priceMin() throws Exception {
        
        try {
            Collection<Product> products = pDao.consultProductMin();
            
            if (products.isEmpty()) {
                System.out.println("No hay productos");
            } else {
                System.out.println("Nombre/Precio minimo:");
                for (Product product : products) {
                    System.out.println(product.getName() + "    " + 
                            product.getPrice());
                }
            }
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
}
