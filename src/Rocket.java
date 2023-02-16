import java.util.ArrayList;

public class Rocket implements SpaceShip{
    private int rocketCost;
    private int rocketWeight;
    private int maxWeight;
    private int currentWeight;
    private String rocketType;
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * A method that returns either true or false indicating if the launch was successful or if the rocket has crashed.
     * @return Boolean
     */
    public boolean launch() {
        return true;
    }

    /**
     * A method that returns either true or false based on the success of the landing.
     * @return Boolean
     */
    public boolean land() {
        return true;
    }

    /**
     * A method that takes an Item as an argument and returns true if the rocket can carry such item or false if it will exceed the weight limit.
     * @param item
     * @return Boolean
     */
    @Override
    public boolean canCarry(Item item) {
        return (item.getWeight() + this.currentWeight) <= (this.maxWeight);
    }

    /**
     * A method that also takes an Item object and updates the current weight of the rocket.
     * @param item
     */
    @Override
    public void carry(Item item) {
        this.currentWeight += item.getWeight();
        this.items.add(item);
    }

    /**
     * Setters and Getters
     */

    public void printItems(){
        System.out.println(getItems() + "\n");
    }

    public void setRocketCost(int rocketCost) {
        this.rocketCost = rocketCost;
    }

    public void setRocketWeight(int rocketWeight) {
        this.rocketWeight = rocketWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getRocketCost() {
        return rocketCost;
    }

    public int getRocketWeight() {
        return rocketWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getRocketType() {
        return rocketType;
    }

    public void setRocketType(String rocketType) {
        this.rocketType = rocketType;
    }
}
