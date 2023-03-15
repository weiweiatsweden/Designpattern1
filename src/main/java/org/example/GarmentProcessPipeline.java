package org.example;

import java.util.ArrayList;

public class GarmentProcessPipeline {
    private ArrayList<GarmentProcessingCommand> pipeline = new ArrayList<>();

    public void addCommand(GarmentProcessingCommand command){
        pipeline.add(command);
    }

    public void execute(){
        for (GarmentProcessingCommand command : pipeline){
            command.process();
        }
    }


}
