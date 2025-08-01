package ui;

import javax.swing.*;
import java.awt.*;

import model.Closet;

// Represents an abstract class that has methods for the common frame setup
public abstract class WhisktyleAbstract extends JFrame {
    protected BackgroundImage background;

    protected static final String IMG_DIRECTORY = "img/";
    protected static final String DEFAULT_IMG_DIRECTORY = IMG_DIRECTORY + "default-imgs/";
    protected static final String BUTTON_IMG_DIRECTORY = IMG_DIRECTORY + "button-imgs/";
    protected static final String CLOSET_IMG_DIRECTORY = IMG_DIRECTORY + "closet-imgs/";
    protected static final String LOADING_IMG_DIRECTORY = IMG_DIRECTORY + "loading-imgs/";

    protected static final int BUTTON_WIDTH = 230;
    protected static final int BUTTON_HEIGHT = 90;

    protected Component horizontalSpacer = Box.createRigidArea(new Dimension(20, 0));
    protected Component verticalSpacer = Box.createRigidArea(new Dimension(0, 20));

    // EFFECTS: Constructor for WhisktyleAbstract, setting up the frame
    public WhisktyleAbstract() {
        super("Whisktyle");
        setupFrame();

    }

    // EFFECTS: Makes menu screen visible
    public void setupFrame() {
        setTitle("Whisktyle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);
        setCursorIcon();
        setContentPane(setBackgroundImage());
        setUI();
        setVisible(true);

    }

    // EFFECTS: returns instance of BackgroundImage
    public BackgroundImage setBackgroundImage() {
        Image img = new ImageIcon(getClass().getResource(DEFAULT_IMG_DIRECTORY + "background.png")).getImage();
        background = new BackgroundImage(img);
        return background;
    }

    // Represents a class to override paint compenent to allow it to draw background
    // image
    class BackgroundImage extends JPanel {
        private Image bg;

        // EFFECTS: Constructor for BackgroundImage
        public BackgroundImage(Image img) {
            this.bg = img;
            setLayout(new FlowLayout());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Paints back
            g.setColor(Color.RED);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.drawImage(bg, 0, 0, getWidth(), getHeight(), this); // Draws image

        }
    }

    // EFFECTS: Gets cursor img, scales it, then sets as cursor
    public void setCursorIcon() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ImageIcon cursorImg = new ImageIcon(getClass().getResource(DEFAULT_IMG_DIRECTORY + "cursor.png"));
        Image scaledCursorImg = cursorImg.getImage().getScaledInstance(100, 150,
                Image.SCALE_SMOOTH);

        Cursor c = toolkit.createCustomCursor(scaledCursorImg, new Point(0, 0), "customCursor");

        setCursor(c);

    }

    // EFFECTS: Adds title panel and closet panel to background panel
    public void setUI() {
        background.setLayout(new BorderLayout());
        background.add(setTitlePanel(), BorderLayout.NORTH);
    }

    // EFFECTS: Creates and returns title image as label
    public JLabel setTitle() {
        ImageIcon headerImg = new ImageIcon(getClass().getResource(DEFAULT_IMG_DIRECTORY + "whisktyle.png"));
        Image image = headerImg.getImage().getScaledInstance(500, 150, Image.SCALE_SMOOTH);

        headerImg = new ImageIcon(image);
        JLabel header = new JLabel(headerImg);

        header.setAlignmentY(Component.CENTER_ALIGNMENT);
        return header;
    }

    // EFFECTS: returns title panel with title image added to it
    public JPanel setTitlePanel() {
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        titlePanel.add(setTitle());
        return titlePanel;
    }

    // EFFECTS: returns instance of closet
    public Closet getCloset() {
        return WhisktyleController.getInstance().getCloset();
    }

    // EFFECTS: scales and returns image icon
    public ImageIcon createImgIcon(String imgPath, int width, int height) {
        final ImageIcon icon = new ImageIcon(
                getClass().getResource(imgPath));

        Image img = icon.getImage().getScaledInstance(width, height,
                Image.SCALE_SMOOTH);

        final ImageIcon finalIcon = new ImageIcon(img);

        return finalIcon;
    }

    // EFFECTS: creates and returns inner menu buttons
    public JButton createButton(String imgPath, int width, int height) {
        JButton button = new JButton();
        ImageIcon innerButtonIcon = createButtonImg(imgPath, width, height);
        button.setIcon(innerButtonIcon);
        button.setPreferredSize(new Dimension(innerButtonIcon.getIconWidth(), innerButtonIcon.getIconHeight()));
        button.setMaximumSize(new Dimension(innerButtonIcon.getIconWidth(), innerButtonIcon.getIconHeight()));

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setAlignmentY(Component.CENTER_ALIGNMENT);
        button.setOpaque(false);
        button.setContentAreaFilled(false);

        return button;
    }

    // EFFECTS: creates, scales, returns image icon of a button
    public ImageIcon createButtonImg(String imgPath, int width, int height) {
        ImageIcon buttonIcon = new ImageIcon(getClass().getResource(imgPath));

        Image scaledButtonImg = buttonIcon.getImage().getScaledInstance(width, height,
                Image.SCALE_SMOOTH);
        ImageIcon scaledButtonIcon = new ImageIcon(scaledButtonImg);

        return scaledButtonIcon;
    }
}
