import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalSafariGame {
    private JFrame frame;
    private JPanel buttonPanel;
    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JButton oceanButton;
    private JButton grasslandsButton;
    private JButton skyButton;
    private JButton sharkButton;
    private JButton dolphinButton;
    private JButton seaTurtleButton;
    private JButton lionButton;
    private JButton tigerButton;
    private JButton elephantButton;
    private JButton eagleButton;
    private JButton hawkButton;
    private JButton houseflyButton;

    public static String newRegion;

    public AnimalSafariGame() {
        frame = new JFrame("Scenic Safari");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0x232323));
        frame.setLayout(new BorderLayout());

        welcomeLabel = new JLabel("Welcome to the Scenic Safari!");
        welcomeLabel.setForeground(new Color(0x33CCFF));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));

        frame.add(welcomeLabel, BorderLayout.NORTH);

        buttonPanel = new JPanel(new GridLayout(1, 3));
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(0x232323));

        oceanButton = new JButton("Ocean");
        grasslandsButton = new JButton("Grasslands");
        skyButton = new JButton("Sky");

        customizeButton(oceanButton);
        customizeButton(grasslandsButton);
        customizeButton(skyButton);

        buttonPanel.add(oceanButton);
        buttonPanel.add(grasslandsButton);
        buttonPanel.add(skyButton);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        setBiomeButtonsAction();
    }

    private void customizeButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setFocusPainted(false);
        button.setBackground(new Color(0x0099CC));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    private void setBiomeButtonsAction() {
        oceanButton.addActionListener(e -> displayOceanAnimals());
        grasslandsButton.addActionListener(e -> displayGrasslandsAnimals());
        skyButton.addActionListener(e -> displaySkyAnimals());
    }

    private void displayOceanAnimals() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();

        ChatFrame.wrongCheck = false;
        ChatFrame.activelyGettingInfo = false;
        ChatFrame.appendToChat("        " + "What animal are you interested in learning about?", false);

        JLabel oceanLabel = new JLabel("What animal are you interested in learning about?");
        oceanLabel.setForeground(new Color(0x33CCFF));
        oceanLabel.setHorizontalAlignment(SwingConstants.CENTER);
        oceanLabel.setFont(new Font("Arial", Font.BOLD, 18));

        sharkButton = new JButton("Shark");
        dolphinButton = new JButton("Dolphin");
        seaTurtleButton = new JButton("Sea Turtle");

        customizeButton(sharkButton);
        customizeButton(dolphinButton);
        customizeButton(seaTurtleButton);

        mainPanel.add(oceanLabel, BorderLayout.NORTH);

        JPanel animalButtonPanel = new JPanel(new GridLayout(1, 3));
        animalButtonPanel.add(sharkButton);
        animalButtonPanel.add(dolphinButton);
        animalButtonPanel.add(seaTurtleButton);

        mainPanel.add(animalButtonPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        setOceanAnimalButtonsAction();
    }

    private void setOceanAnimalButtonsAction() {
        sharkButton.addActionListener(e -> displayAnimalInfo(createShark()));
        dolphinButton.addActionListener(e -> displayAnimalInfo(createDolphin()));
        seaTurtleButton.addActionListener(e -> displayAnimalInfo(createSeaTurtle()));
    }

    private void displayGrasslandsAnimals() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();

        ChatFrame.wrongCheck = false;
        ChatFrame.activelyGettingInfo = false;
        ChatFrame.appendToChat("        " + "What animal are you interested in learning about?", false);


        JLabel grasslandsLabel = new JLabel("What animal are you interested in learning about?");
        grasslandsLabel.setForeground(new Color(0x33CCFF));
        grasslandsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        grasslandsLabel.setFont(new Font("Arial", Font.BOLD, 18));

        lionButton = new JButton("Lion");
        tigerButton = new JButton("Tiger");
        elephantButton = new JButton("Elephant");

        customizeButton(lionButton);
        customizeButton(tigerButton);
        customizeButton(elephantButton);

        mainPanel.add(grasslandsLabel, BorderLayout.NORTH);

        JPanel animalButtonPanel = new JPanel(new GridLayout(1, 3));
        animalButtonPanel.add(lionButton);
        animalButtonPanel.add(tigerButton);
        animalButtonPanel.add(elephantButton);

        mainPanel.add(animalButtonPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        setGrasslandsAnimalButtonsAction();
    }

    private void setGrasslandsAnimalButtonsAction() {
        lionButton.addActionListener(e -> displayAnimalInfo(createLion()));
        tigerButton.addActionListener(e -> displayAnimalInfo(createTiger()));
        elephantButton.addActionListener(e -> displayAnimalInfo(createElephant()));
    }

    private void displaySkyAnimals() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();

        ChatFrame.wrongCheck = false;
        ChatFrame.activelyGettingInfo = false;
        ChatFrame.appendToChat("        " + "What animal are you interested in learning about?", false);


        JLabel skyLabel = new JLabel("What animal are you interested in learning about?");
        skyLabel.setForeground(new Color(0x33CCFF));
        skyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        skyLabel.setFont(new Font("Arial", Font.BOLD, 18));

        eagleButton = new JButton("Eagle");
        hawkButton = new JButton("Hawk");
        houseflyButton = new JButton("Housefly");

        customizeButton(eagleButton);
        customizeButton(hawkButton);
        customizeButton(houseflyButton);

        mainPanel.add(skyLabel, BorderLayout.NORTH);

        JPanel animalButtonPanel = new JPanel(new GridLayout(1, 3));
        animalButtonPanel.add(eagleButton);
        animalButtonPanel.add(hawkButton);
        animalButtonPanel.add(houseflyButton);

        mainPanel.add(animalButtonPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        setSkyAnimalButtonsAction();
    }

    private void setSkyAnimalButtonsAction() {
        eagleButton.addActionListener(e -> displayAnimalInfo(createEagle()));
        hawkButton.addActionListener(e -> displayAnimalInfo(createHawk()));
        houseflyButton.addActionListener(e -> displayAnimalInfo(createHousefly()));
    }

    private void displayAnimalInfo(Animal animal) {
        if(newRegion != null) {
            animal.setRegionFound(newRegion);
        }
        newRegion = null;
        StringBuilder animalInfo = new StringBuilder();
        animalInfo.append("Name: ").append(animal.displayName(animal)).append("\n");
        animalInfo.append("Biome: ").append(animal.getBiome()).append("\n");
        animalInfo.append("Lifespan: ").append(animal.getLifespan()).append("\n");
        animalInfo.append("Color: ").append(animal.getColor()).append("\n");
        animalInfo.append("Region Found: ").append(animal.getRegionFound()).append("\n");
        animalInfo.append("Weight (lb): ").append(animal.getWeight()).append("\n");

        if (animal instanceof Water) {
            Water waterAnimal = (Water) animal;
            animalInfo.append("Number of Fins: ").append(waterAnimal.getNumberOfFins()).append("\n");
            animalInfo.append("Average Depth (meters): ").append(waterAnimal.getAverageDepth()).append("\n");
            animalInfo.append("Comes Above Water: ").append(waterAnimal.isComesAboveWater()).append("\n");
        }
        if(animal instanceof Land) {
            Land landAnimal = (Land) animal;
            animalInfo.append("Number of Legs: ").append(landAnimal.numberOfLegs).append("\n");
            animalInfo.append("Average Jumping Height (meters): ").append(landAnimal.averageJumpingHeight).append("\n");
        }
        if(animal instanceof Air) {
            Air airAnimal = (Air) animal;
            animalInfo.append("Has Beak: ").append(airAnimal.hasBeak).append("\n");
        }

        ChatFrame.appendToChat("        " + animalInfo.toString(), false);
        animal.live();
        if (animal instanceof Water) {
            Water waterAnimal = (Water) animal;
            waterAnimal.swim();
            waterAnimal.dive(waterAnimal.getAverageDepth());
        }

        if (animal instanceof Land) {
            Land landAnimal = (Land) animal;
            landAnimal.move(landAnimal.getWeight());
            landAnimal.run();
            landAnimal.jump(landAnimal.averageJumpingHeight);
        }
        if(animal instanceof Air) {
            Air airAnimal = (Air) animal;
            airAnimal.move(airAnimal.getWeight());
            airAnimal.fly();
            airAnimal.height(5);
        }


        ChatFrame.appendToChat("        " + "Type 'Change Region' if you have seen this animal someplace else. If you have not, feel free to move on.", false);

        ChatFrame.wrongCheck = true;

        welcomeLabel.setText("Where do you want to go next?");
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
        frame.revalidate();
        frame.repaint();
    }

    private Water createShark() {
        return new Water("Shark", "Ocean", 10, "Gray", "Pacific Ocean", 500, 2, 10, true);
    }

    private Water createDolphin() {
        return new Water("Dolphin", "Ocean", 15, "Gray", "Atlantic, Pacific, and Indian Oceans", 150, 1, 2, true);
    }

    private Water createSeaTurtle() {
        return new Water("Sea Turtle", "Ocean", 80, "Green", "Atlantic and Indian Ocean", 500, 4, 10, false);
    }

    private Land createLion() {
        return new Land("Lion", "Grasslands", 20, "Yellow", "Africa", 420, 4, 1);
    }

    private Land createTiger() {
        return new Land("Tiger", "Grasslands", 15, "Orange", "Asia", 300, 4, 1);
    }

    private Land createElephant() {
        return new Land("Elephant", "Grasslands", 60, "Gray", "Africa", 12000, 4, 0.1);
    }

    private Air createEagle() {
        return new Air("Eagle", "Sky", 30, "Brown", "North America and Europe", 10, true);
    }

    private Air createHawk() {
        return new Air("Hawk", "Sky", 20, "Brown and Black", "North America", 2, true);
    }

    private Air createHousefly() {
        return new Air("Housefly", "Sky", 1, "Black", "Global", 0.002, false);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(AnimalSafariGame::new);
    }

}
