package org.example.pants;

import org.example.GarmentProcessingCommand;

public class PantsLengthCommand implements GarmentProcessingCommand {
    private int length;
    private Pants pants;

    public PantsLengthCommand(int length, Pants pants){
        this.length = length; this.pants = pants;
    }
    @Override
    public void process() {
        pants.setLength(length);
        System.out.println("Cut to " + length + " length.");
    }
}
