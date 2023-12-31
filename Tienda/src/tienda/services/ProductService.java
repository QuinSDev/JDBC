package tienda.services;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Product;
import tienda.persistencia.ProductDAO;

public class ProductService {

    private ProductDAO pDao;
    Product product;
    Scanner read = new Scanner(System.in);

    public ProductService() {
        pDao = new ProductDAO();
    }

    public void printProducts() throws Exception {
        System.out.println("");

        try {

            Collection<Product> products = pDao.consultProducts();

            if (products.isEmpty()) {
                throw new Exception("No hay productos para imprimir");
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
        System.out.println("");
        try {
            Collection<Product> products = pDao.consultNamePrice();

            if (products.isEmpty()) {
                throw new Exception("No hay productos para imprimir");
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
        System.out.println("");
        try {
            Collection<Product> products = pDao.consultPriceRange();

            if (products.isEmpty()) {
                throw new Exception("No hay productos para imprimir");
            } else {
                System.out.println("Codigo/Nombre/Precio/Codigo_fabricante");
                for (Product product : products) {
                    System.out.println(product);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void productPortatil() throws Exception {
        System.out.println("");
        try {
            Collection<Product> products = pDao.consultProductPortatil();

            if (products.isEmpty()) {
                throw new Exception("Lista vac�a");
            } else {
                for (Product product : products) {
                    System.out.println(product);
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }

    public void priceMin() throws Exception {
        System.out.println("");
        try {
            Collection<Product> products = pDao.consultProductMin();

            if (products.isEmpty()) {
                throw new Exception("No hay productos");
            } else {
                System.out.println("Nombre/Precio minimo:");
                for (Product product : products) {
                    System.out.println(product.getName() + "    "
                            + product.getPrice());
                }
            }

        } catch (Exception e) {
            throw e;
        }

    }

    public void crateProducts() throws Exception {

        do {

            try {
                product = new Product();
                System.out.print("\nEnter the product name: ");
                product.setName(read.nextLine());
                System.out.print("Enter the price of the product: ");
                String p = read.nextLine();
                System.out.print("Enter the manufacturer code of the product: ");
                String c = read.nextLine();

                try {
                    product.setPrice(Double.parseDouble(p));
                    product.setManufacturerCode(Integer.parseInt(c));
                } catch (NumberFormatException e) {
                    System.out.println("\nPlease enter a valid integer.");
                    continue;
                }

                if (product.getName() == null || product.getName().isEmpty()) {
                    throw new IllegalArgumentException("\nYou must indicate "
                            + "the name!");
                }

                if (product.getPrice() <= 0) {
                    throw new IllegalArgumentException("\nYou must indicate "
                            + "the price!");
                }

                pDao.saveProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (product.getName() == null || product.getName().isEmpty()
                || product.getPrice() <= 0);

    }

    public void modifyProduct(String cp) throws Exception {
        int code = 0;
        double newPrice = 0;
        do {
            newPrice = 0;
            try {

                code = Integer.parseInt(cp);

                product.setCode(code);
                System.out.print("Enter the price: ");
                String price = read.nextLine();
                newPrice = Double.parseDouble(price);

                if (newPrice <= 0) {
                    throw new IllegalArgumentException("\nYou must indicate a valid price!");
                }

                product.setPrice(newPrice);
                pDao.modifyProduct(product);

            } catch (NumberFormatException e) {
                throw new Exception("\nPlease enter a valid integer.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (newPrice <= 0);
    }

    public void searchProductForCode() throws Exception {
        String cp = "";
        do {
            product = null;
            try {
                System.out.print("Enter the code of the product you want to modify: ");
                cp = read.nextLine();

                if (cp.isEmpty()) {
                    throw new Exception("You must indicate the code!");
                }

                product = pDao.searchProductForCode(cp);
                if (product == null) {
                    throw new Exception("\nThe code entered does not exist!");
                }

                modifyProduct(cp);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (cp.isEmpty() || product == null);

    }

}
