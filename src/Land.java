class Land extends Animal {
    protected int numberOfLegs;
    protected double averageJumpingHeight;

    public Land(String name, String biome, int lifespan, String color, String regionFound, double weight,
                int numberOfLegs, double averageJumpingHeight) {
        super(name, biome, lifespan, color, regionFound, weight);
        this.numberOfLegs = numberOfLegs;
        this.averageJumpingHeight = averageJumpingHeight;
    }

    @Override
    public void move(double speed) {
        ChatFrame.appendToChat("        " + getName() + " runs at " + speed + " miles per hour", false);
    }

    public void jump(double height) {
        ChatFrame.appendToChat("        " + getName() + " jumps " + height + " meters high on average", false);
    }

    public void run() {
        ChatFrame.appendToChat("        " + getName() + " is running", false);
    }
}