/*
 * Copyright (c) 2017 a01334390.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    a01334390 - initial API and implementation and/or initial documentation
 */
package BasicElements;

/**
 *
 * @author a01334390
 */
public class Notebook {
    private int id;
    private String average_time;
    private String type;
    private float benefit;
    private int onInventory;

    public Notebook(int id, String average_time, String type, float benefit, int onnventory) {
        this.id = id;
        this.average_time = average_time;
        this.type = type;
        this.benefit = benefit;
        this.onInventory = onInventory;
    }

    public int getOnInventory() {
        return onInventory;
    }

    public void setOnInventory(int onInventory) {
        this.onInventory = onInventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAverage_time() {
        return average_time;
    }

    public void setAverage_time(String average_time) {
        this.average_time = average_time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getBenefit() {
        return benefit;
    }

    public void setBenefit(float benefit) {
        this.benefit = benefit;
    }
    
    @Override
    public String toString(){
        return type;
    }
    
    
}
