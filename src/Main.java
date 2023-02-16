import java.io.File;

public class Main {
    public static void main(String[] args) {

        Simulation s1 = new Simulation();
        File myFile1 = new File("./Phase-1.txt");
        System.out.println("------------------First Phase------------------");
        s1.loadU1(s1.loadItems(myFile1));
        s1.loadU2(s1.loadItems(myFile1));
        System.out.println("------------------First Phase Done------------------");

        System.out.println("\n------------------Second Phase------------------");
        File myFile2 = new File("./Phase-2.txt");
        s1.loadU1(s1.loadItems(myFile2));
        s1.loadU2(s1.loadItems(myFile2));
        System.out.println("------------------Second Phase Done------------------");

        System.out.println("\n------------------Simulation Results------------------");
        s1.runSimulation();

    }
}