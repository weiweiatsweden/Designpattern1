package org.example;

public class TShirtBuilder {
    private Tshirts tShirt = new Tshirts();

    public TShirtBuilder addMaterial(String material) {
        if (!material.equals("cotton") && !material.equals("linen")) {
            throw new RuntimeException("Material is unavailable.");
        }
        tShirt.setMaterial(material);
        return this;
    }


    public TShirtBuilder addSleeveLength(String sleeveLength){
        if(!sleeveLength.equals("short") && !sleeveLength.equals("medium") && !sleeveLength.equals("long")){
            throw new RuntimeException("Length is unavailable.");
        }
        tShirt.setSleeves(sleeveLength);
        return this;
    }

    public TShirtBuilder addNeckShape(String neckShape){
        if(!neckShape.equals("v") && !neckShape.equals("round") && !neckShape.equals("turtle")){
            throw new RuntimeException("Neck shape is unavailable");
        }
        tShirt.setNeck(neckShape);
        return this;
    }

    public Tshirts build(){
        return tShirt;
    }
}
