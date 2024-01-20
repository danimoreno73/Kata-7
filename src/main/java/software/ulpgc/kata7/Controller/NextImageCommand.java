package software.ulpgc.kata7.Controller;

import software.ulpgc.kata7.View.ImageDisplay;

public class NextImageCommand implements Command{

    private final ImageDisplay imageDisplay;

    public NextImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().next());
    }
}
