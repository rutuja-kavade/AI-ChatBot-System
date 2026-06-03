package aichatbotsystem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatBotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JButton clearButton;

    private ChatBotEngine engine;

    public ChatBotGUI() {

        engine = new ChatBotEngine();

        setTitle("AI ChatBot Assistant");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BackgroundPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(new BorderLayout());

        //---------------- HEADER ----------------//

        //---------------- HEADER ----------------//

JPanel headerPanel = new JPanel(
        new FlowLayout(FlowLayout.LEFT, 20, 10));

headerPanel.setBackground(
        new Color(0, 31, 63));

headerPanel.setPreferredSize(
        new Dimension(1000, 70));

// Robot Logo

ImageIcon icon = new ImageIcon(
        getClass().getResource(
                "/image/robo.png"));

Image img = icon.getImage()
        .getScaledInstance(
                45,
                45,
                Image.SCALE_SMOOTH);

ImageIcon robotIcon =
        new ImageIcon(img);

// Title

JLabel titleLabel = new JLabel(
        " AI ChatBot Assistant",
        robotIcon,
        JLabel.LEFT);

titleLabel.setFont(
        new Font(
                "Segoe UI",
                Font.BOLD,
                26));

titleLabel.setForeground(
        Color.WHITE);

headerPanel.add(titleLabel);

// Window Icon

setIconImage(robotIcon.getImage());

        //---------------- CHAT AREA ----------------//

        chatArea = new JTextArea();

        chatArea.setEditable(false);

        chatArea.setFont(
                new Font("Segoe UI", Font.PLAIN, 16));

        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        chatArea.setBackground(
                new Color(30, 30, 30, 180));

        chatArea.setForeground(Color.WHITE);

        chatArea.setMargin(
                new Insets(15, 15, 15, 15));

        JScrollPane scrollPane =
                new JScrollPane(chatArea);

        scrollPane.setBorder(
                BorderFactory.createEmptyBorder());

        //---------------- INPUT PANEL ----------------//

        JPanel bottomPanel =
                new JPanel(new BorderLayout(10, 10));

        bottomPanel.setBorder(
                new EmptyBorder(10, 10, 10, 10));

        bottomPanel.setBackground(
                new Color(20, 20, 20));

        inputField = new JTextField();

        inputField.setFont(
                new Font("Segoe UI", Font.PLAIN, 16));

        sendButton = new JButton("Send");

        sendButton.setFont(
                new Font("Segoe UI", Font.BOLD, 15));

        sendButton.setBackground(
                new Color(0, 120, 215));

        sendButton.setForeground(Color.WHITE);

        clearButton = new JButton("Clear");

        clearButton.setFont(
                new Font("Segoe UI", Font.BOLD, 15));

        clearButton.setBackground(
                new Color(220, 53, 69));

        clearButton.setForeground(Color.WHITE);

        JPanel buttonPanel =
                new JPanel(new FlowLayout());

        buttonPanel.setBackground(
                new Color(20, 20, 20));

        buttonPanel.add(sendButton);
        buttonPanel.add(clearButton);

        bottomPanel.add(inputField,
                BorderLayout.CENTER);

        bottomPanel.add(buttonPanel,
                BorderLayout.EAST);

        //---------------- ADD COMPONENTS ----------------//

        mainPanel.add(headerPanel,
                BorderLayout.NORTH);

        mainPanel.add(scrollPane,
                BorderLayout.CENTER);

        mainPanel.add(bottomPanel,
                BorderLayout.SOUTH);

        add(mainPanel);

        //---------------- WELCOME MESSAGE ----------------//

        chatArea.append(
                "🤖 AI Assistant\n" +
                "Welcome to AI ChatBot System\n\n");

        //---------------- EVENTS ----------------//

        sendButton.addActionListener(
                (ActionEvent e) -> sendMessage());

        inputField.addActionListener(
                (ActionEvent e) -> sendMessage());

        clearButton.addActionListener(
                (ActionEvent e) -> {

            chatArea.setText("");

            chatArea.append(
                    "🤖 AI Assistant\n" +
                    "Chat Cleared Successfully\n\n");
        });
    }

    private void sendMessage() {

        String userInput =
                inputField.getText().trim();

        if (userInput.isEmpty()) {
            return;
        }

        String time =
                new SimpleDateFormat("HH:mm")
                        .format(new Date());

        chatArea.append(
                "[" + time + "] You : "
                        + userInput + "\n");

        String response =
                engine.generateResponse(userInput);

        chatArea.append(
                "[" + time + "] Bot : "
                        + response + "\n\n");

        inputField.setText("");

        chatArea.setCaretPosition(
                chatArea.getDocument()
                        .getLength());
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new ChatBotGUI()
                        .setVisible(true));
    }
}

/*---------------------------------------------------
  Background Panel Class
---------------------------------------------------*/

class BackgroundPanel extends JPanel {

    private Image backgroundImage;

    public BackgroundPanel() {

        try {

            backgroundImage =
                    new ImageIcon(
                            getClass().getResource(
                                    "/image/ai.jpeg"))
                            .getImage();

        } catch (Exception e) {

            System.out.println(
                    "Background image not found.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (backgroundImage != null) {

            g.drawImage(
                    backgroundImage,
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    this);
        }
    }
}