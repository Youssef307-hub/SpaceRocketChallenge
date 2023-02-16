import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    /**
     * Simulation class responsible for reading item data and filling up the rockets.
     */
    private ArrayList<Item> itemsArray;
    private ArrayList<Rocket> rockets;
    private int totalU1Cost,totalU2Cost;

    Simulation(){
        itemsArray  = new ArrayList<>();
        rockets = new ArrayList<>();
        totalU1Cost = 0;
        totalU2Cost = 0;
    }

    /**
     * Method loads all items from a text file and returns an ArrayList of Items:
     * Each line in the text file consists of the item name followed by = then its weigh in kg.
     * @param myFile file containing the items to be carried
     * @return ArrayList of Items
     */
    public ArrayList<Item> loadItems(File myFile){
        try {
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] splitLine = line.split("=");
                Item item = new Item(splitLine[0],Integer.parseInt(splitLine[1]));
                itemsArray.add(item);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Your File Is Not Found!!!");
        }
        return itemsArray;
    }

    /**
     * Method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
     * It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and filling that one until all items are loaded.
     * @param items ArrayList of the items to be loaded
     */
    public void loadU1(ArrayList<Item> items){

        while(!items.isEmpty()){
            System.out.println("Loading New U1 Rocket...");
            U1 u1 = new U1();
            totalU1Cost += u1.getRocketCost();
            while(true){
                if(u1.canCarry(items.get(0))){
                    u1.carry(items.get(0));
                    items.remove(0);
                    if(items.size() == 0) break;
                }else {
                    break;
                }
            }
            rockets.add(u1);
            u1.printItems();
        }
    }

    /**
     * Method takes the ArrayList of Items and starts creating U2 rockets and filling them with those items the same way as with U1 until all items are loaded.
     * The method then returns the ArrayList of those U2 rockets that are fully loaded.
     * @param items ArrayList of the items to be loaded
     */
    public void loadU2(ArrayList<Item> items){

        while(!items.isEmpty()){
            System.out.println("Loading New U2 Rocket...");
            U2 u2 = new U2();
            totalU2Cost += u2.getRocketCost();
            while(true){
                if(u2.canCarry(items.get(0))){
                    u2.carry(items.get(0));
                    items.remove(0);
                    if(items.size() == 0) break;
                }else {
                    break;
                }
            }
            rockets.add(u2);
            u2.printItems();
        }
    }

    /**
     * Method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList.
     * Every time a rocket explodes or crashes (i.e. if launch or land return false) it will have to send that rocket again.
     * All while keeping track of the total budget required to send each rocket safely to Mars.
     * runSimulation then prints the total budget required to send all rockets (including the crashed ones).
     */
    public void runSimulation(){
        int failedU1Rockets = 0, failedU2Rockets = 0;
        for (Rocket rocket: this.rockets) {
            if(!rocket.launch() && !rocket.land()){
                if(rocket.getRocketType().equals("U1")){
                    failedU1Rockets++;
                    totalU1Cost += rocket.getRocketCost();
                }else{
                    failedU2Rockets++;
                    totalU2Cost += rocket.getRocketCost();
                }
            }
        }
        System.out.println("\nThe total cost of U1 rockets is: $" + totalU1Cost + " Million");
        System.out.println("\nThe number of failed U1 rockets is: " + failedU1Rockets);

        System.out.println("\nThe total cost of U2 rockets is: $" + totalU2Cost + " Million");
        System.out.println("\nThe number of failed U2 rockets is: " + failedU2Rockets);
    }
}
