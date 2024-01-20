package software.ulpgc.kata7;

import software.ulpgc.kata7.Controller.NextImageCommand;
import software.ulpgc.kata7.Controller.PrevImageCommand;
import software.ulpgc.kata7.Model.FileImageLoader;
import software.ulpgc.kata7.Model.Image;
import software.ulpgc.kata7.View.MainFrame;

import java.io.File;

public class Main {

    public static final String root = "C:\\Users\\Dani\\Desktop\\Imagenes";

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        Image image = new FileImageLoader(new File(root)).load();

        mainFrame.imageDisplay().show(image);

        mainFrame.addCommand(">", new NextImageCommand(mainFrame.imageDisplay()));
        mainFrame.addCommand("<", new PrevImageCommand(mainFrame.imageDisplay()));

        mainFrame.setVisible(true);

    }

}
