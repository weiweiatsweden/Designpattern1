package org.example.pants;

public class PantsBuilder {
    private Pants pants = new Pants();

    public PantsBuilder addMaterial(String material){
        if(!material.equals("cotton") && !material.equals("linen")){
            throw new RuntimeException("Material is unavailable.");
        }
        pants.setMaterial(material);
        return this;
    }
    public PantsBuilder addType(String type){
        if(!type.equals("kostym") && !type.equals("sport") && !type.equals("casual")){
            throw new RuntimeException("Type is unavailable.");
        }
        pants.setType(type);
        return this;
    }

    public PantsBuilder addFit(String fit){
        if(!fit.equals("regular") && !fit.equals("wide") && !fit.equals("slim")) {
            throw new RuntimeException("Fit is unavailable.");
        }
        pants.setFit(fit);
        return this;
    }


    public Pants build(){
        return pants;
    }
}
