package org.example;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Skirt {
    private int id = 0;
    private String name;
    private String material;
    private int size;
    private String color;
    private double price;
    private String waistLine;
    private String pattern;

    private boolean productionIsCompleted = false;

    private PropertyChangeSupport propertyChangeSupport;
    public Skirt() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        this.propertyChangeSupport.firePropertyChange("New Garment in production", oldId, this.id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWaistLine() {
        return waistLine;
    }

    public void setWaistLine(String waistLine) {
        this.waistLine = waistLine;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setProductionIsCompleted(boolean productionIsCompleted) {
        boolean oldStatus = this.productionIsCompleted;
        this.productionIsCompleted = productionIsCompleted;
        this.propertyChangeSupport.firePropertyChange("Garment production complete", oldStatus, this.productionIsCompleted);
    }
}
