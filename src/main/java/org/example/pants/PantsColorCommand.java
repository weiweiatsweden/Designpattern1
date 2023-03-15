package org.example.pants;

import org.example.GarmentProcessingCommand;

public class PantsColorCommand implements GarmentProcessingCommand {

    private String color;
    private Pants pants;

    public PantsColorCommand(String color, Pants pants) {
        this.color = color;
        this.pants = pants;
    }
    @Override
    public void process() {
        pants.setColor(color);
        System.out.println("Coloring to " + color);
    }
}
