class Air extends Animal {
    protected boolean hasBeak;

    public Air(String name, String biome, int lifespan, String color, String regionFound, double weight, boolean hasBeak) {
        super(name, biome, lifespan, color, regionFound, weight);
        this.hasBeak = hasBeak;
    }

    @Override
    public void move(double speed) {
        ChatFrame.appendToChat("        " + getName() + " flies at " + speed + " miles per hour", false);
    }

    public void height(double flyingHeight) {
        ChatFrame.appendToChat("        " + getName() + " flies at " + flyingHeight + " meters high", false);
    }

    public void fly() {
        ChatFrame.appendToChat("        " + getName() + " is flying", false);
    }
}
