package tienda.services;

import java.util.Scanner;

public class MenuService {

    int option = 0;
    Scanner read = new Scanner(System.in);
    ProductService productS = new ProductService();

    public void menuMain() throws Exception {

        do {
            try {

                System.out.println("    Welcome to TechShop     ");
                System.out.println("----------------------------");
                System.out.println("       Options Menu         ");
                System.out.println("----------------------------");
                System.out.println("1. List products name");
                System.out.println("2. List products name and price");
                System.out.println("3. List products where the price is between "
                        + "120 and 202");
                System.out.println("4. Search and list products that are portable");
                System.out.println("5. List name and price cheapest product");
                System.out.println("6. Exit");
                System.out.println("-------------------------------------------");
                System.out.print("Choose an option: ");
                String g = read.nextLine();
                option = Integer.parseInt(g);
                optionsMenu(option);

            } catch (NumberFormatException e) {
                System.out.println("\nError! Please enter a valid integer.\n");
                option = 0;
            }

        } while (option != 6);

    }

    public void optionsMenu(int option) throws Exception {

        switch (option) {
            case 1:
                productS.printProducts();
                System.out.println("");
                break;
            case 2:
                productS.namePriceProducts();
                System.out.println("");
                break;
            case 3:
                productS.listProducts();
                System.out.println("");
                break;
            case 4:
                productS.productPortatil();
                System.out.println("");
                break;
            case 5:
                productS.priceMin();
                System.out.println("");
                break;
            case 6:
                System.out.println("\nYou have exited the system!");
        }

    }

}
