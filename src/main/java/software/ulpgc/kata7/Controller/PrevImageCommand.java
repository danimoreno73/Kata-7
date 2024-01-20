package software.ulpgc.kata7.Controller;

import software.ulpgc.kata7.View.ImageDisplay;

public class PrevImageCommand implements Command{

    private final ImageDisplay imageDisplay;

    public PrevImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }


    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().prev());
    }
}
