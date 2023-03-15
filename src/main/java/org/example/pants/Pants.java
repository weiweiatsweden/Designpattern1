package org.example.pants;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Pants {
    private int id = 0;
    private String name;
    private String material;
    private String size;
    private String color;
    private double price;
    private int length;
    private String type;
    private String fit;

    private boolean productionIsCompleted = false;

    private PropertyChangeSupport propertyChangeSupport;

    public Pants() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
      //* report change
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public boolean isProductionIsCompleted() {
        return productionIsCompleted;
    }

    public void setProductionIsCompleted(boolean productionIsCompleted) {
        boolean oldStatus = this.productionIsCompleted;
        this.productionIsCompleted = productionIsCompleted;
        this.propertyChangeSupport.firePropertyChange("Garment production complete", oldStatus, this.productionIsCompleted);
    }
}
