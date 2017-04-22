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
public class HighestBenefit {
    String[] order;
    String date1;
    String date2;
    public HighestBenefit(){
        this.order=order;
        this.date1=date1;
        this.date2=date2;
    }
    public void setDate1(String date){
        date1=date;
    }
    public void setDate2(String date){
        date2=date;
    }
    public String[] search() {   
        if(date1 == null || date2 == null){
            order= new String[1];
            order[0]="Verifique que todos los campos estÃ©n llenos";
        }
        else{
            
            String [] query = Handler.getHighestBenefitBetweenDates(date1, date2);
            order= new String[query.length];
            //jTextArea1.append("Total de beneficio por tipo de cuaderno"
            //        + " entre "+date1+" y "+date2+".\n");            
            for(int i = 0; i < query.length; i++){
                order[i]=(query[i]);
            }
        } 
        return order;
    }
}
