package org.example;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEOMessageNotification implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getPropertyName());
    }
}
