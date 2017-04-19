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
public class OrderNotebooks {

    private int quantity;
    private int id_Notebook;
    private int id_Order;
    private String status;
    private String ribbon;
    private String image;
    private String elastic;
    private String pageType;

    public OrderNotebooks(int id_Notebook, int id_Order,int quantity, String status, String ribbon, String image, String elastic, String pageType) {
        this.quantity = quantity;
        this.id_Notebook = id_Notebook;
        this.id_Order = id_Order;
        this.status = status;
        this.ribbon = ribbon;
        this.image = image;
        this.elastic = elastic;
        this.pageType = pageType;
    }
    
    public OrderNotebooks(){
        
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId_Notebook() {
        return id_Notebook;
    }

    public void setId_Notebook(int id_Notebook) {
        this.id_Notebook = id_Notebook;
    }

    public int getId_Order() {
        return id_Order;
    }

    public void setId_Order(int id_Order) {
        this.id_Order = id_Order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRibbon() {
        return ribbon;
    }

    public void setRibbon(String ribbon) {
        this.ribbon = ribbon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getElastic() {
        return elastic;
    }

    public void setElastic(String elastic) {
        this.elastic = elastic;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }
    
    
    
  

}
