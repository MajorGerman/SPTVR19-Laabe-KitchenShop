package sptvr19.laabe.kitchenshop.tools;

import entity.Person;
import java.util.List;
import java.util.Scanner;

public class PersonManager {
    
    colorprint text = new colorprint();
    Scanner scan = new Scanner(System.in);
    
    public Person createPerson() {       
        
        String name;
        String surname;
        String phone;
        double money;
        
        while (true) {
            text.defprint("\nInput the name of new person: ", false);
            name = scan.nextLine();
            if (name.length() > 0 && name.length() < 41 && !name.matches(" (.*)")) {
                break;
            } else {
                text.errorprint("Incorrect name!", true);
            }
        }

        while (true) {
            text.defprint("Input the surname of new person: ", false);
            surname = scan.nextLine();
            if (surname.length() > 0 && surname.length() < 41 && !surname.matches(" (.*)")) {
                break;
            } else {
                text.errorprint("Incorrect surname!", true);
            }
        }
                
        while (true) {
            text.defprint("Input the phone number of new person: ", false);
            phone = scan.nextLine();
            if (phone.length() > 2 && phone.length() < 21 && !phone.matches(" (.*)")) {
                break;
            } else {
                text.errorprint("Incorrect phone!", true);
            }
        }
        
        while (true) {
            text.defprint("Input the base money count of new product: ", false);
            money = scan.nextDouble();
            if (money >= 0 && money < 10000 && (money % 1) == 0) {
                break;
            } else {
                text.errorprint("Incorrect money count!", true);
            }
        }
        
        Person pers = new Person(name, surname, phone, (int)(money));
        return pers;
    }
    public void addPersonToList(Person person, List<Person> listPersons) {
        listPersons.add(person);
        SaveToFile saveToFile = new SaveToFile();
        saveToFile.saveToFile(listPersons, "listPersons");
    }
    
    public void showList(List<Person> listPersons) {
        text.defprint("", true);
        for (int i = 0; i < listPersons.size(); i++) {
            text.listprint(i + ". " + (String)(listPersons.get(i).toString()), true);
        }
    }    
}
