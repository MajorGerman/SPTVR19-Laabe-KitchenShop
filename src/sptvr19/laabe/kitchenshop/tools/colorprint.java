package sptvr19.laabe.kitchenshop.tools;

public class colorprint {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";  

    public void defprint(String string, boolean enter) {
        if (enter) {
            System.out.println(ANSI_YELLOW + string + ANSI_RESET);
        } else {
            System.out.print(ANSI_YELLOW + string + ANSI_RESET);    
        }
    }
    public void listprint(String string, boolean enter) {
        if (enter) {
            System.out.println(ANSI_CYAN + string + ANSI_RESET);
        } else {
            System.out.print(ANSI_CYAN + string + ANSI_RESET);    
        }
    }       
    public void errorprint(String string, boolean enter) {
        if (enter) {
            System.out.println(ANSI_RED + string + ANSI_RESET);
        } else {
            System.out.print(ANSI_RED + string + ANSI_RESET);    
        }
    }    
    public void nameprint(String string, boolean enter) {
        if (enter) {
            System.out.println(ANSI_PURPLE + string + ANSI_RESET);
        } else {
            System.out.print(ANSI_PURPLE + string + ANSI_RESET);    
        }
    } 
}
