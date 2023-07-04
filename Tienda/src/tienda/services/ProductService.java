package tienda.services;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Product;
import tienda.persistencia.ProductDAO;

public class ProductService {

    private ProductDAO pDao;
    private Product product;
    Scanner read = new Scanner(System.in);

    public ProductService() {
        pDao = new ProductDAO();
    }

    public void printProducts() throws Exception {
        System.out.println("");

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
        System.out.println("");
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
        System.out.println("");
        try {
            Collection<Product> products = pDao.consultPridceRange();

            if (products.isEmpty()) {
                throw new Exception("No hay productos para imprimir");
            } else {
                System.out.println("Nombre/Precio");
                for (Product product : products) {
                    System.out.println(product.getCode() + "\n"
                            + product.getName() + "\n"
                            + product.getPrice());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void productPortatil() {
        System.out.println("");
        try {
            Collection<Product> products = pDao.consultProductPortatil();

            if (products.isEmpty()) {
                System.out.println("Lista vacía");
            } else {
                for (Product product : products) {
                    System.out.println(product);
                }
            }
        } catch (Exception e) {
        }

    }

    public void priceMin() throws Exception {
        System.out.println("");
        try {
            Collection<Product> products = pDao.consultProductMin();

            if (products.isEmpty()) {
                System.out.println("No hay productos");
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

                if (product.getPrice() == 0) {
                    throw new IllegalArgumentException("\nYou must indicate "
                            + "the price!");
                }

                pDao.saveProduct(product);
            } catch (IllegalArgumentException e) {
                if (e instanceof IllegalArgumentException) {
                    System.out.println(e.getMessage());
                } else {
                    System.out.println("Invalid!");
                }

            }
        } while (product.getName() == null || product.getName().isEmpty()
                || product.getPrice() == 0);

    }

}
