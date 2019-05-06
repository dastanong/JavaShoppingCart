import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingCart {
    static void getList(String[][] list) {
        for(int i = 0; i < list.length; i++) {
            System.out.println(i + " - " + list[i][0] + " (Price: RM " + list[i][1] + ")");
        }
    }

    public static void main(String[] args) {
        Integer finalPrice = 0;
        Integer count = 0;
        Boolean isAdded = false;

        String[] menu = {"Configure Your Laptop", "View Cart", "Checkout"};

        String[][] allLaptops = {{"Latitude", "1000"}, {"XPS", "1300"}, {"Precision", "1700"}};
        String[][] screenList = {{"1080p", "1000"}, {"2k", "1500"}, {"4k", "2000"}};
        String[][] ramList = {{"8GB", "300"}, {"16GB", "500"}, {"32GB", "700"}};
        String[][] hddList = {{"1TB HDD", "400"}, {"128GB SSD", "550"}, {"256GB SSD", "750"}, {"512GB SSD", "950"}};
        String[][] processorList = {{"i3", "600"}, {"i5", "800"}, {"i7", "1000"}};
        String discountCode = "Q3H1M0K8G1";

        ArrayList<ArrayList<String>> cartList = new ArrayList<ArrayList<String>>();

        while(isAdded == false) {
            System.out.println("-----------------------------------");
            System.out.println("Main Menu :");
            for(int i = 0; i < menu.length; i++) {
                System.out.println(i + ". " + menu[i]);
            }
            System.out.println("-----------------------------------");
            Scanner mainMenu = new Scanner(System.in);
            Integer selectedOption = Integer.parseInt(mainMenu.nextLine());

            if(selectedOption == 0) {
                for(int i = 0; i <= count; i++) {
                    ArrayList<String> laptopArray = new ArrayList<>();
                
                    System.out.println("Please select a laptop model : ");
                    System.out.println("-----------------------------------");
                    getList(allLaptops);
                    Scanner pickModel = new Scanner(System.in);
                    Integer selectedModel = Integer.parseInt(pickModel.nextLine());
                    laptopArray.add(allLaptops[selectedModel][0]);
                    finalPrice += Integer.parseInt(allLaptops[selectedModel][1]);

                    System.out.println("Please choose your resolution : ");
                    System.out.println("-----------------------------------");
                    getList(screenList);
                    Scanner pickScreen = new Scanner(System.in);
                    Integer selectedScreen = Integer.parseInt(pickScreen.nextLine());
                    laptopArray.add(screenList[selectedScreen][0]);
                    finalPrice += Integer.parseInt(screenList[selectedScreen][1]);
                    
                    System.out.println("Please choose your RAM : ");
                    System.out.println("-----------------------------------");
                    getList(ramList);
                    Scanner pickRam = new Scanner(System.in);
                    Integer selectedRam = Integer.parseInt(pickRam.nextLine());
                    laptopArray.add(ramList[selectedRam][0]);
                    finalPrice += Integer.parseInt(ramList[selectedRam][1]);

                    System.out.println("Please choose your HDD : ");
                    System.out.println("-----------------------------------");
                    getList(hddList);
                    Scanner pickHdd = new Scanner(System.in);
                    Integer selectedHdd = Integer.parseInt(pickHdd.nextLine());
                    laptopArray.add(hddList[selectedHdd][0]);
                    finalPrice += Integer.parseInt(hddList[selectedHdd][1]);
                    
                    System.out.println("Please choose your Processor : ");
                    System.out.println("-----------------------------------");
                    getList(processorList);
                    Scanner pickProcessor = new Scanner(System.in);
                    Integer selectedProcessor = Integer.parseInt(pickProcessor.nextLine());
                    laptopArray.add(processorList[selectedProcessor][0]);
                    finalPrice += Integer.parseInt(processorList[selectedProcessor][1]);

                    System.out.println("Laptop Configuration : " + laptopArray);
                    cartList.add(laptopArray);
                    isAdded = true;
                    
                    if(cartList.size() > 0) {                   
                        isAdded = false;
                    }
                }
            } else if(selectedOption == 1) {
                System.out.println("Cart List : ");
                System.out.println(cartList);
                System.out.println("Total : " + cartList.size() + " item in cart now");
                
            } else if(selectedOption == 2 && finalPrice > 0) {
                System.out.println("Total price : RM " + finalPrice);
                System.out.println("Please enter a coupon code for discount :");

                Scanner codeInput = new Scanner(System.in);
                String codeValue = codeInput.nextLine();

                if(codeValue.equals(discountCode)) {
                    finalPrice = finalPrice - (finalPrice * 30 / 100);
                    System.out.println("Final price discount for 30% and left : " + finalPrice);
                } else {
                    System.out.println("Invalid discount code!");
                }
            }
        }
    }
}