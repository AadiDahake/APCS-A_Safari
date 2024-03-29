import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ChatFrame extends JFrame {
    private static JTextPane chatPane;
    private static JTextField inputField;
    private JButton submitButton;
    private Timer cursorTimer;

    private Color backgroundColor = new Color(40, 40, 40);
    private Color chatAreaColor = new Color(43, 43, 43);
    private Color textColor = new Color(253, 250, 236);
    private static Color userPromptColor = new Color(255, 251, 240);
    private static Color robotResponseColor = new Color(206, 102, 206);
    private Font textFont = new Font("Montserrat", Font.PLAIN, 14);

    public static boolean wrongCheck = false;
    public static boolean activelyGettingInfo = false;

    public static String globalUserInput = "";


    public ChatFrame(String title) {
        super(title);


        setWindowIcon();


        setLayout(new BorderLayout());

        // chat area
        chatPane = new JTextPane();
        chatPane.setEditable(false);
        chatPane.setBackground(chatAreaColor);
        chatPane.setForeground(textColor);
        chatPane.setFont(textFont);
        chatPane.setEditorKit(new WrapEditorKit());


        JScrollPane scrollPane = new JScrollPane(chatPane);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        inputField = new JTextField("Type here...");
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(chatAreaColor, 2, true),
                        BorderFactory.createEmptyBorder(5, 10, 5, 10)
                )
        ));
        inputField.setBackground(chatAreaColor);
        inputField.setForeground(new Color(169, 169, 169));
        inputField.setFont(textFont);

        JPanel linePanel = new JPanel();
        linePanel.setBackground(Color.GRAY);
        linePanel.setPreferredSize(new Dimension(400, 2));

        inputField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if ("Type here...".equals(inputField.getText())) {
                    inputField.setText("");
                    inputField.setForeground(textColor);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputField.getText().isEmpty()) {
                    inputField.setText("Type here...");
                    inputField.setForeground(new Color(169, 169, 169));
                }
            }
        });

        // submit button
        ImageIcon submitIcon = new ImageIcon(getClass().getResource("/Logos/submitButton.png"));
        ImageIcon resizedIcon = new ImageIcon(submitIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        submitButton = new JButton(resizedIcon);
        submitButton.setBackground(chatAreaColor);
        submitButton.setBorderPainted(false);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Adding all things to the frame
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBackground(backgroundColor);
        inputPanel.add(linePanel, BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);

        getContentPane().setBackground(backgroundColor);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(inputPanel, BorderLayout.SOUTH);

        cursorTimer = new Timer(500, new ActionListener() {
            private boolean cursorVisible = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setCaretColor(textColor);
                cursorVisible = !cursorVisible;
            }
        });
        cursorTimer.start();

        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        appendToChat("        Hello! I am your Tour Guide. I will be guiding you through your Scenic Safari! If you want to exit type \"Bye\". Where do you want to visit first?", false);

    }

    private void sendMessage() {
        String userInput = inputField.getText().trim();
        if (!userInput.isEmpty()) {
            if ("bye".equalsIgnoreCase(userInput.toLowerCase())) {
                appendToChat("        Goodbye! If you have more questions, feel free to ask later.", false);
                inputField.setText("");
                Timer exitTimer = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                exitTimer.setRepeats(false);
                exitTimer.start();
                return;
            }
            if (!"Type here...".equals(userInput)) {
                appendToChat("     " + userInput, true);
                String botResponse = Main.respondTo(userInput);
                //CHATBOT LOGIC
                if (wrongCheck && userInput.toLowerCase().equals("change region")){
                    botResponse = "I am sorry I got the information wrong, please correct me based on your information. Type 'Region: [Your Information]' (ex: Region: North America) to correct me.";
                    activelyGettingInfo = true;
                }
                if (activelyGettingInfo){
                    globalUserInput = userInput.toLowerCase();
                    if(userInput.toLowerCase().indexOf("region:") != -1){
                        botResponse = "Thank you for the correction. The region found has been updated to " + userInput.substring(7);
                        AnimalSafariGame.newRegion = userInput.substring(7);
                        wrongCheck = false;
                        activelyGettingInfo = false;
                    }
//                    if (userInput.toLowerCase().contains("name:")){
//                        Animal.setName(userInput.substring(6));
//                        botResponse = "Thank you for the correction. The name has been updated to " + userInput.substring(6);
//                        activelyGettingInfo = false;
//                    }
//                    else if (userInput.toLowerCase().contains("biome:")){
//                        Animal.setBiome(userInput.substring(7));
//                        botResponse = "Thank you for the correction. The biome has been updated to " + userInput.substring(7);
//                        activelyGettingInfo = false;
//                    }
//                    else if (userInput.toLowerCase().contains("lifespan:")){
//                        Animal.setLifespan(Integer.parseInt(userInput.substring(9)));
//                        botResponse = "Thank you for the correction. The lifespan has been updated to " + userInput.substring(9);
//                        activelyGettingInfo = false;
//                    }
//                    else if (userInput.toLowerCase().contains("color:")){
//                        Animal.setColor(userInput.substring(6));
//                        botResponse = "Thank you for the correction. The color has been updated to " + userInput.substring(6);
//                        activelyGettingInfo = false;
//                    }
//                    else if (userInput.toLowerCase().contains("region found:")){
//                        Animal.setRegionFound(userInput.substring(13));
//                        botResponse = "Thank you for the correction. The region found has been updated to " + userInput.substring(13);
//                        activelyGettingInfo = false;
//                    }
//                    else if (userInput.toLowerCase().contains("weight:")){
//                        Animal.setWeight(Double.parseDouble(userInput.substring(7)));
//                        botResponse = "Thank you for the correction. The weight has been updated to " + userInput.substring(7);
//                        activelyGettingInfo = false;
//                    }
                }

                appendToChat("        " + botResponse, false);
                inputField.setText("");
            }
        }
    }

    public static void appendToChat(String message, boolean isUser) {
        StyledDocument styledDoc = chatPane.getStyledDocument();


        addStyledText(styledDoc, isUser ? "You: " : "Tour Guide: ", isUser ? new Color(148, 218, 255) : new Color(88, 144, 255));

        addStyledText(styledDoc, message.substring(isUser ? 5 : 8) + "\n", isUser ? userPromptColor : robotResponseColor);

        displayToChat();
    }


    private static void displayToChat() {
        Timer timer = new Timer(50, new ActionListener() {
            private int currentIndex = inputField.getText().length();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex <= inputField.getText().length()) {
                    inputField.setCaretPosition(currentIndex);
                } else {
                    ((Timer) e.getSource()).stop();
                    inputField.setCaretPosition(inputField.getText().length());
                }
                currentIndex++;
            }
        });
        timer.start();
    }

    private static void addStyledText(StyledDocument doc, String text, Color color) {
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, color);
        StyleConstants.setBold(set, true);
        StyleConstants.setItalic(set, false);
        StyleConstants.setFontFamily(set, "Montserrat");
        StyleConstants.setFontSize(set, 14);
        try {
            doc.insertString(doc.getLength(), text, set);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChatFrame("Tour Guide");
        });
    }


    private void setWindowIcon() {
        try {

            BufferedImage iconImage = ImageIO.read(getClass().getResource("/Logos/submitButton.png"));


            setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


class WrapEditorKit extends StyledEditorKit {
    ViewFactory defaultFactory = new WrapColumnFactory();

    public ViewFactory getViewFactory() {
        return defaultFactory;
    }

    static class WrapColumnFactory implements ViewFactory {
        public View create(Element elem) {
            String kind = elem.getName();
            if (kind != null) {
                if (kind.equals(AbstractDocument.ContentElementName)) {
                    return new WrapLabelView(elem);
                } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                    return new ParagraphView(elem);
                } else if (kind.equals(AbstractDocument.SectionElementName)) {
                    return new BoxView(elem, View.Y_AXIS);
                } else if (kind.equals(StyleConstants.ComponentElementName)) {
                    return new ComponentView(elem);
                } else if (kind.equals(StyleConstants.IconElementName)) {
                    return new IconView(elem);
                }
            }

            return new LabelView(elem);
        }
    }

    static class WrapLabelView extends LabelView {
        public WrapLabelView(Element elem) {
            super(elem);
        }

        public float getMinimumSpan(int axis) {
            switch (axis) {
                case View.X_AXIS:
                    return 0;
                case View.Y_AXIS:
                    return super.getMinimumSpan(axis);
                default:
                    throw new IllegalArgumentException("Invalid axis: " + axis);
            }
        }
    }
}

