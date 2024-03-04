class Animal {
    private String name;
    private String biome;
    private int lifespan;
    private String color;
    private String regionFound;
    private double weight;

    public Animal(String name, String biome, int lifespan, String color, String regionFound, double weight) {
        this.name = name;
        this.biome = biome;
        this.lifespan = lifespan;
        this.color = color;
        this.regionFound = regionFound;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiome() {
        return biome;
    }

    public void setBiome(String biome) {
        this.biome = biome;
    }

    public String getLifespan() {
        return lifespan + " years";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegionFound() {
        return regionFound;
    }

    public void setRegionFound(String regionFound) {
        this.regionFound = regionFound;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void live() {
        ChatFrame.appendToChat("        " + name + " will live for " + lifespan + " years", false);
    }

    public void move(double speed) {
        ChatFrame.appendToChat("        " + name + " moves at " + speed + " mph", false);
    }

    public String displayName(Animal animal) {
        return animal.getName();
    }
}
