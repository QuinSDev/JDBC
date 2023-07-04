package tienda;

import tienda.services.ProductService;

public class Tienda {

    public static void main(String[] args) throws Exception {
        
        ProductService pService = new ProductService();
        pService.listProducts();
        
    }
    
}
