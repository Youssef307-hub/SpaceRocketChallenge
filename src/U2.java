public class U2 extends Rocket{

    /**
     * Default constructor setting rocket cost, weight, and maximum weight it can carry
     * Rocket cost = $120 Million
     * Rocket weight = 18 Tonnes
     * Max weight (with cargo) = 29 Tonnes
     */
    U2(){
        setRocketCost(120);
        setRocketWeight(18);
        setMaxWeight(29);
        setCurrentWeight(getRocketWeight());
        setRocketType("U2");
    }

    /**
     * Method returns true or false based on the equation => Chance of launch explosion = 4% * (cargo carried / cargo limit)
     * @return Boolean
     */
    @Override
    public boolean launch() {
        double chanceOfExplosion = 0.04 *(this.getCurrentWeight() / this.getMaxWeight());
        return chanceOfExplosion <= Math.random()* 0.1;
    }

    /**
     * Method returns true or false based on the equation => Chance of landing crash = 8% * (cargo carried / cargo limit)
     * @return Boolean
     */
    @Override
    public boolean land() {
        double chanceOfCrashing = 0.08 *(this.getCurrentWeight() / this.getMaxWeight());
        return chanceOfCrashing <= Math.random()* 0.1;
    }
}
