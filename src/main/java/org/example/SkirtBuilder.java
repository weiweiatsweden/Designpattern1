package org.example;

public class SkirtBuilder {
    private Skirt skirt = new Skirt();

    public SkirtBuilder addMaterial(String material){
        if(!material.equals("cotton") && !material.equals("linen")){
            throw new RuntimeException("Material is unavailable.");
        }
        skirt.setMaterial(material);
        return this;
    }

    public SkirtBuilder addWaistLine(String waistLine){
        if (!waistLine.equals("high") && !waistLine.equals("medium") && !waistLine.equals("low")){
            throw new RuntimeException("Waistline is unavailable.");
        }
        skirt.setWaistLine(waistLine);
        return this;
    }

    public SkirtBuilder addPattern(String pattern){
        if (!pattern.equals("flower") && !pattern.equals("square") && !pattern.equals("polka")){
            throw new RuntimeException("Pattern is unavailable.");
        }
        skirt.setPattern(pattern);
        return this;
    }

    public Skirt build(){
        return skirt;
    }
}
