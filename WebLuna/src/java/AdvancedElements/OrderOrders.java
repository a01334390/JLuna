/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdvancedElements;

import DatabaseManager.Handler;

/**
 *
 * @author Arpi
 */
public class OrderOrders {
    String[] order;
    public OrderOrders(){
        this.order=order;
        
    }
    public String[] orderDate() { 
        String orders [] = Handler.getOrdersByDate();
        order= new String[orders.length];
        //jTextArea1.append("Estos son los pedidos ordenados por fecha mÃ¡s prÃ³xima\n");
        for(int i = 0;i < orders.length; i++){
            order[i]=(orders[i]);
        }
        return order;
    }                                           

    public String[] orderPriority() {
        String orders [] = Handler.getOrdersByPriority();
        order= new String[orders.length];
        //jTextArea1.append("Estos son los pedidos ordenados por prioridad\n");
        for(int i = 0;i < orders.length; i++){
            order[i]=(orders[i]);
        }     
        return order;
    }  
}
