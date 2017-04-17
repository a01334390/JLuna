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

import java.util.Date;

/**
 *
 * @author a01334390
 */
public class Order {

    private int id;
    private int client_id;
    private String date;
    private String priority;
    private String create_time;

    /**
     *
     * @param id
     * @param date
     * @param priority
     * @param create_time
     * @param client_id
     */
    public Order(int id, String date, String priority, String create_time, int client_id) {
        this.id = id;
        this.client_id = client_id;
        this.date = date;
        this.priority = priority;
        this.create_time = create_time;
    }

    public Order(int id, String date, String priority) {
        this.id = id;
        this.date = date;
        this.priority = priority;        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

}
