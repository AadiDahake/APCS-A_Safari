import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class DisplayFrame extends JFrame implements ActionListener {

    JButton land;
    JButton water;
    JButton air;
    JLabel safari;
    JButton first;
    JButton second;
    JButton third;

    DisplayFrame() {
        this.setLayout(null);
        this.setSize(500, 600);
        this.setTitle("Scenic Safari");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(43, 43, 43));
        this.setVisible(true);
        safari = new JLabel();
        safari.setBounds(130, 10, 300, 50);
        safari.setText("Scenic Safari");
        safari.setVisible(true);
        safari.setFont(new Font("Typeface", Font.BOLD, 30));
        safari.setHorizontalTextPosition(JLabel.CENTER);
        safari.setVerticalTextPosition(JLabel.CENTER);
        this.add(safari);

        first = new JButton();
        second = new JButton();
        third = new JButton();
        first.setBounds(10-5,130,150,40);
        second.setBounds(180-5,130,150,40);
        third.setBounds(350-5,130,150,40);
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

        first.setBackground(Color.yellow);
        second.setBackground(Color.yellow);
        third.setBackground(Color.yellow);
        this.add(first);
        this.add(second);
        this.add(third);


        water = new JButton();
        water.setBounds(50,60,100,40);
        water.setBackground(Color.cyan);
        water.addActionListener(this);
        water.setText("Water");
        water.setFocusable(false);
        water.setVisible(true);
        water.setHorizontalTextPosition(JButton.CENTER);
        water.setVerticalTextPosition(JButton.CENTER);
        this.add(water);

        air = new JButton();
        air.setBounds(250,60,100,40);
        air.setBackground(Color.white);
        air.addActionListener(this);
        air.setText("Ariel");
        air.setFocusable(false);
        air.setVisible(true);
        air.setHorizontalTextPosition(JButton.CENTER);
        air.setVerticalTextPosition(JButton.CENTER);
        this.add(air);

        land = new JButton();
        land.setBounds(340,60,100,40);
        land.setBackground(Color.GREEN);
        land.addActionListener(this);
        land.setText("Land");
        land.setFocusable(false);
        land.setVisible(true);
        land.setHorizontalTextPosition(JButton.CENTER);
        land.setVerticalTextPosition(JButton.CENTER);
        this.add(land);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
    }
}