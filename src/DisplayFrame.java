import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class DisplayFrame extends JFrame implements ActionListener {

    JButton land;
    JButton water;
    JButton air;
    JLabel safari;
    JButton first;
    JButton second;
    JButton third;
    JLabel waterImageLabel;
    JLabel airImageLabel;
    JLabel landImageLabel;

    DisplayFrame() {
        this.setLayout(null);
        this.setSize(1000, 800); // Adjusted window size
        this.setTitle("Scenic Safari");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(43, 43, 43));
        this.setVisible(true);

        safari = new JLabel();
        safari.setBounds(250, 10, 500, 50); // Adjusted position and size
        safari.setText("Scenic Safari");
        safari.setVisible(true);
        safari.setFont(new Font("Typeface", Font.BOLD, 30));
        safari.setHorizontalTextPosition(JLabel.CENTER);
        safari.setVerticalTextPosition(JLabel.CENTER);
        safari.setForeground(Color.WHITE); // Set text color to white
        this.add(safari);

        first = new JButton();
        second = new JButton();
        third = new JButton();

        int buttonWidth = 300; // Adjusted button width
        int buttonHeight = 40;
        int gap = 20; // Adjusted gap

        first.setBounds(gap, 130, buttonWidth, buttonHeight);
        second.setBounds(buttonWidth + 2 * gap, 130, buttonWidth, buttonHeight);
        third.setBounds(2 * (buttonWidth + 2 * gap), 130, buttonWidth, buttonHeight);

        first.setHorizontalTextPosition(JButton.CENTER);
        first.setVerticalTextPosition(JButton.CENTER);
        second.setHorizontalTextPosition(JButton.CENTER);
        second.setVerticalTextPosition(JButton.CENTER);
        third.setHorizontalTextPosition(JButton.CENTER);
        third.setVerticalTextPosition(JButton.CENTER);

        first.addActionListener(this);
        second.addActionListener(this);
        third.addActionListener(this);

        first.setFocusable(false);
        second.setFocusable(false);
        third.setFocusable(false);

        first.setEnabled(false);
        second.setEnabled(false);
        third.setEnabled(false);

        first.setVisible(false);
        second.setVisible(false);
        third.setVisible(false);

        first.setBackground(Color.YELLOW);
        second.setBackground(Color.YELLOW);
        third.setBackground(Color.YELLOW);

        this.add(first);
        this.add(second);
        this.add(third);

        water = new JButton();
        water.setBounds(gap, 60, buttonWidth, buttonHeight);
        water.setBackground(Color.CYAN);
        water.addActionListener(this);
        water.setText("Water");
        water.setFocusable(false);
        water.setVisible(true);
        water.setHorizontalTextPosition(JButton.CENTER);
        water.setVerticalTextPosition(JButton.CENTER);
        this.add(water);

        air = new JButton();
        air.setBounds(buttonWidth + 2 * gap, 60, buttonWidth, buttonHeight);
        air.setBackground(Color.WHITE);
        air.addActionListener(this);
        air.setText("Aerial");
        air.setFocusable(false);
        air.setVisible(true);
        air.setHorizontalTextPosition(JButton.CENTER);
        air.setVerticalTextPosition(JButton.CENTER);
        this.add(air);

        land = new JButton();
        land.setBounds(2 * (buttonWidth + 2 * gap), 60, buttonWidth, buttonHeight);
        land.setBackground(Color.GREEN);
        land.addActionListener(this);
        land.setText("Land");
        land.setFocusable(false);
        land.setVisible(true);
        land.setHorizontalTextPosition(JButton.CENTER);
        land.setVerticalTextPosition(JButton.CENTER);
        this.add(land);

        // Use class loader to load images
        ClassLoader classLoader = getClass().getClassLoader();

        // Load and scale images to maintain aspect ratio
        int imageWidth = buttonWidth;

        // Load water image
        ImageIcon waterIcon = new ImageIcon(classLoader.getResource("Logos/water.png"));
        int waterHeight = calculateMaintainedAspectRatioHeight(waterIcon, imageWidth);
        waterImageLabel = new JLabel(new ImageIcon(waterIcon.getImage().getScaledInstance(imageWidth, waterHeight, Image.SCALE_SMOOTH)));
        waterImageLabel.setBounds(gap, 180, imageWidth, waterHeight);
        this.add(waterImageLabel);

        // Load air image
        ImageIcon airIcon = new ImageIcon(classLoader.getResource("Logos/air.png"));
        int airHeight = calculateMaintainedAspectRatioHeight(airIcon, imageWidth);
        airImageLabel = new JLabel(new ImageIcon(airIcon.getImage().getScaledInstance(imageWidth, airHeight, Image.SCALE_SMOOTH)));
        airImageLabel.setBounds(buttonWidth + 2 * gap, 180, imageWidth, airHeight);
        this.add(airImageLabel);

        // Load land image
        ImageIcon landIcon = new ImageIcon(classLoader.getResource("Logos/land.png"));
        int landHeight = calculateMaintainedAspectRatioHeight(landIcon, imageWidth);
        landImageLabel = new JLabel(new ImageIcon(landIcon.getImage().getScaledInstance(imageWidth, landHeight, Image.SCALE_SMOOTH)));
        landImageLabel.setBounds(2 * (buttonWidth + 2 * gap), 180, imageWidth, landHeight);
        this.add(landImageLabel);
    }

    // Calculate height to maintain aspect ratio
    private int calculateMaintainedAspectRatioHeight(ImageIcon icon, int width) {
        double aspectRatio = (double) icon.getIconWidth() / icon.getIconHeight();
        return (int) (width / aspectRatio);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // Handle button actions here if needed
    }

    public static void main(String[] args) {
        new DisplayFrame();
    }
}
