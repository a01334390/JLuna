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
public class Cliente {
    private int id;
    private  String first_name,second_name,address,email;
    private int isPhysical;

    public Cliente(int id, String first_name, String second_name, String address, int isPhysical,String email) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.address = address;
        this.isPhysical = isPhysical;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getAddress() {
        return address;
    }

    public int getIsPhysical() {
        return isPhysical;
    }
    
    @Override
    public String toString(){
        return id+","+first_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIsPhysical(int isPhysical) {
        this.isPhysical = isPhysical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
