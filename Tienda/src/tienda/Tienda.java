package tienda;

import tienda.services.MenuService;
import tienda.services.ProductService;

public class Tienda {

    public static void main(String[] args) throws Exception {
        
        MenuService menuS = new MenuService();
        menuS.menuMain();
        
    }
    
}
