package org.example.pants;

import org.example.GarmentProcessingCommand;

public class PantsSizeCommand implements GarmentProcessingCommand {

    private String size;
    private Pants pants;
    public PantsSizeCommand(String size, Pants pants) {
        this.size = size;
        this.pants = pants;
    }

    @Override
    public void process() {
        pants.setSize(size);
        System.out.println("Customized to size " + size);
    }
}
