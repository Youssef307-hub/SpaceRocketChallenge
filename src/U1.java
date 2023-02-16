public class U1 extends Rocket{

    /**
     * Default constructor setting rocket cost, weight, and maximum weight it can carry
     * Rocket cost = $100 Million
     * Rocket weight = 10 Tonnes
     * Max weight (with cargo) = 18 Tonnes
     */
    U1(){
        setRocketCost(100);
        setRocketWeight(10);
        setMaxWeight(18);
        setCurrentWeight(getRocketWeight());
        setRocketType("U1");
    }

    /**
     * Method returns true or false based on the equation => Chance of launch explosion = 5% * (cargo carried / cargo limit)
     * @return Boolean
     */
    @Override
    public boolean launch() {
        double chanceOfExplosion = 0.05 *(this.getCurrentWeight() / this.getMaxWeight());
        return chanceOfExplosion <= Math.random()* 0.1;
    }

    /**
     * Method returns true or false based on the equation => Chance of landing crash = 1% * (cargo carried / cargo limit)
     * @return Boolean
     */
    @Override
    public boolean land() {
        double chanceOfCrashing = 0.01 *(this.getCurrentWeight() / this.getMaxWeight());
        return chanceOfCrashing <= Math.random()* 0.1;
    }

}
