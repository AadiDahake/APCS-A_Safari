import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ChatFrame frame = new ChatFrame("Tour Guide");
            frame.setSize(400, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

        Scanner scanner = new Scanner(System.in);
        AnimalSafariGame g = new AnimalSafariGame();
    }

    public static String respondTo(String userInput) {
        return "Hello! I am your Tour Guide. Please follow the instructions in our main Safari window.";
    }

}