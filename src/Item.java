public class Item {
    /**
     * Item class includes a String name and an int weight that will represent an item to be carried by the rockets
     */
    private String name;
    private int weight;
    Item(String name, int weight){
        this.name = name;
        this.weight = weight/1000;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName() + "= " + getWeight() + " tonnes";
    }
}
