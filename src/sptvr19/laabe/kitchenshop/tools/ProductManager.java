package sptvr19.laabe.kitchenshop.tools;

import entity.Product;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    
    Scanner scan = new Scanner(System.in);
    colorprint text = new colorprint();
    
    public Product createProduct() {       
        String name;
        double price;
        
        while (true) {
            text.defprint("\nInput the name of new product: ", false);
            name = scan.nextLine();
            if (name.length() > 0 && name.length() < 41 && !name.matches(" (.*)")) {
                break;
            } else {
                text.errorprint("Incorrect name!", true);
            }
        }
        
        while (true) {
            text.defprint("Input the price of new product: ", false);
            price = scan.nextDouble();
            if (price >= 0 && price < 10000 && (price % 1) == 0) {
                break;
            } else {
                text.errorprint("Incorrect price!", true);
            }
        }
        Product prod = new Product(name, (int)(price));
        return prod;
    }
    
    public void addProductToList(Product product, List<Product> listProducts) {
        listProducts.add(product);
        SaveToFile saveToFile = new SaveToFile();
        saveToFile.saveToFile(listProducts, "listProducts");
    }
    
    public void showList(List<Product> listProducts) {
        text.defprint("", true);
        for (int i = 0; i < listProducts.size(); i++) {
            text.listprint(i + ". " + (String)(listProducts.get(i).toString()), true);
        }
    }
}