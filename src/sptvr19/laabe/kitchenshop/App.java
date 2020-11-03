package sptvr19.laabe.kitchenshop;

import entity.Person;
import entity.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import sptvr19.laabe.kitchenshop.tools.PersonManager;
import sptvr19.laabe.kitchenshop.tools.ProductManager;
import sptvr19.laabe.kitchenshop.tools.SaveToFile;
import sptvr19.laabe.kitchenshop.tools.colorprint;

class App {
    
    List<Product> listProducts = new ArrayList<>();
    ProductManager productManager = new ProductManager(); 
    
    List<Person> listPersons = new ArrayList<>();
    PersonManager personManager = new PersonManager();  
    
    colorprint text = new colorprint();
    
    public App() {
        SaveToFile saveToFile = new SaveToFile();
        this.listProducts = saveToFile.loadFromFile("listProducts");
        this.listPersons = saveToFile.loadFromFile("listPersons");
    }     
    boolean work = true;
    
    Scanner scan = new Scanner(System.in);
    
    public void run() {
        
        text.nameprint("~~~ KitchenShop ~~~", true);
        
        while (work) {
            
            text.defprint("\n[ Functions ]", true);
            text.defprint("- 1. Add Product -", true);
            text.defprint("- 2. Product List -", true);
            text.defprint("- 3. Add Person -", true);
            text.defprint("- 4. Person List -", true);
            text.defprint("- 5. Buy Product -", true);
            text.defprint("- 6. Exit -", true);
            
            text.defprint("\n> Choose function: ", false);
            int function = scan.nextInt();
            
            switch (function) {
                default:
                    text.errorprint("There is no function like that!", true);
                    text.defprint("__________________________________", true);
                case 1:
                    text.defprint("\n[ Functions --> Add Product ]", true);
                    
                    Product prod = productManager.createProduct();
                    productManager.addProductToList(prod, listProducts);
                    
                    text.defprint("__________________________________", true);
                    break;
                case 2:
                    text.defprint("\n[ Functions --> Product List ]", true);
                    
                    if (listProducts.size() == 0) {
                        text.listprint("\nThere is no any product in here!", true);
                    } else {
                        productManager.showList(listProducts);
                    }
                    
                    text.defprint("__________________________________", true);   
                    break;
                case 3:
                    text.defprint("\n[ Functions --> Add Person ]", true);
                    
                    Person pers = personManager.createPerson();
                    personManager.addPersonToList(pers, listPersons);
                    
                    text.defprint("__________________________________", true);
                    break;   
                case 4:
                    text.defprint("\n[ Functions --> Person List ]", true);
                    
                    if (listPersons.size() == 0) {
                        text.listprint("\nThere is no any person in here!", true);
                    } else {
                        personManager.showList(listPersons);
                    }
                    
                    text.defprint("__________________________________", true);   
                    break;      
                case 5:
                    text.defprint("\n[ Functions --> Buy Product ]", true);
                    
                    if (listPersons.size() == 0) {
                        text.listprint("\nThere is no any person in here!", true);
                    } else if (listProducts.size() == 0) {
                        text.listprint("\nThere is no any product in here!", true);
                    } else {
                        personManager.showList(listPersons);
                        
                        text.defprint("\nChoose person: ", false);
                        int choosed_person = scan.nextInt();
                        
                        if (choosed_person >= 0 && choosed_person < listPersons.size()) {
                            productManager.showList(listProducts);
                            
                            text.defprint("\nChoose product: ", false);
                            int choosed_product = scan.nextInt();
                            
                            if (choosed_product >= 0 && choosed_product < listProducts.size()) {
                                
                                if (listPersons.get(choosed_person).getMoney() >= listProducts.get(choosed_product).getPrice()) {
                                    listPersons.get(choosed_person).setMoney(listPersons.get(choosed_person).getMoney() - listProducts.get(choosed_product).getPrice());
                                    listPersons.get(choosed_person).getListProducts().add(listProducts.get(choosed_product));
                                    listProducts.remove(choosed_product);
                                } else {
                                    //
                                }
                            
                            } else {
                                text.errorprint("\nThere is no product like that!", true);
                            }                        
                        } else {
                            text.errorprint("\nThere is no person like that!", true);
                        }                        
                    }
                    
                    text.defprint("__________________________________", true);   
                    break;  
                case 6:                   
                    work = false;                    
                    text.defprint("__________________________________", true);   
                    break;                      
            }
        }
    } 
}
