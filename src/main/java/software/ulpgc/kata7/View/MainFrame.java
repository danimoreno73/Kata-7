package software.ulpgc.kata7.View;

import software.ulpgc.kata7.Controller.Command;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    private ImageDisplay imageDisplay;
    private final Map<String, Command> commandMap;

    public MainFrame() {
        this.commandMap = new HashMap<>();
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(900,675);
        this.setLocationRelativeTo(null);



        add(createImageDisplay());
        add(createNextImageButton(">"),BorderLayout.EAST);
        add(createNextImageButton("<"),BorderLayout.WEST);
        this.setVisible(true);
    }


    private Component createNextImageButton(String label) {
        JPanel jPanel = new JPanel();
        jPanel.add(createButton(label));
        return jPanel;
    }

    private Component createButton(String label) {
        JButton button = new JButton(label);
        button.setPreferredSize(new Dimension((int) (this.getWidth() * 0.05),this.getHeight()));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.addActionListener(e -> commandMap.get(label).execute());
        return button;
    }

    private Component createImageDisplay() {
        SwingImageDisplay swingImageDisplay = new SwingImageDisplay();
        this.imageDisplay = swingImageDisplay;
        return swingImageDisplay;
    }

    public void addCommand(String name, Command command){commandMap.put(name,command);}

    public ImageDisplay imageDisplay(){return  imageDisplay;}
}
