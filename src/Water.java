public class Water extends Animal {
    private int numberOfFins;
    private int averageDepth;
    private boolean comesAboveWater;

    public Water(String name, String biome, int lifespan, String color, String regionFound, int weight,
                 int numberOfFins, int averageDepth, boolean comesAboveWater) {
        super(name, biome, lifespan, color, regionFound, weight);
        this.numberOfFins = numberOfFins;
        this.averageDepth = averageDepth;
        this.comesAboveWater = comesAboveWater;
    }

    public int getNumberOfFins() {
        return numberOfFins;
    }

    public int getAverageDepth() {
        return averageDepth;
    }

    public boolean isComesAboveWater() {
        return comesAboveWater;
    }

    public void swim() {
        ChatFrame.appendToChat("        " + getName() + " swims at 3 mph", false);
    }

    public void dive(int depth) {
        ChatFrame.appendToChat("        " + getName() + " goes " + depth + " meters deep", false);
    }
}
