/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdvancedElements;

import BasicElements.Material;
import DatabaseManager.Handler;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Arpi
 */
public class MacroView {
    String[] material;
    String[] clientes;
    String[]atrasados;
    String[] semana;
    String[] notebook;
    public MacroView(){
        this.material=material;
        this.clientes=clientes;
        this.atrasados=atrasados;
        this.semana=semana;
        this.notebook=notebook;
    }
    public void init(){
        setSemana();
        setAtrasados();
        setClientes();
        setMaterial();
    }
    public String[] setSemana(){//date-priority-1name-2name
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String today=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate).toString();
        LocalDate after=localDate.plusDays(7);
        String daysAfter=DateTimeFormatter.ofPattern("yyy/MM/dd").format(after).toString();
        String orders [] = Handler.getOrdersByDate();
        String[] semana1= new String[orders.length];
        System.out.println(orders.length);
        int j=0;
        //semanaText.append("Pedidos "+ " entre "+today+" y "+daysAfter+".\n");            
        for(int i = 0;i < orders.length; i++){
            String sub=orders[i].substring(0, 10);
            LocalDate queryDate = LocalDate.parse(sub);
            if(queryDate.isAfter(localDate.minusDays(1)) && queryDate.isBefore(after)){
                semana1[i]=(orders[i]);
                j++;
            }
            
        }
        semana= new String[j];
        for (int i = 0; i < j; i++) {
            semana[i]=semana1[i];
        }
        return semana;
    }
    public String[] setAtrasados(){//id-1name-2name-status
        LocalDate localDate = LocalDate.now();
        String today=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate).toString();
        //atrasadoText.append("Pedidos atrasados:"+"\n"); 
        String orders [] = Handler.getOrdersUnfinished();
        atrasados = new String[orders.length];
        System.out.println(orders.length);
        for(int i = 0;i < orders.length; i++){
            atrasados[i]=(orders[i]);
            
        }
        return atrasados;
    }
    public String[] setClientes(){// idorder, 1name, 2name, status, priority, quantity
        String [] notebooks = Handler.getMostOrderedNotebooks();
        clientes= new String[notebooks.length];
        //clientesText.append("Pedidos ordenados por cliente con mayor cantidad de cuadernos a menor\n"
                //+ "ID \t Nombre \t\t Status \t Prioridad \t Cantidad \n");
        for(int i = 0;i < notebooks.length; i++){
            clientes[i]=(notebooks[i]);
        }
        return clientes;
    }
    public String[] setMaterial(){//
        Material [] materials = Handler.getShortageOfMaterial();
        material= new String[materials.length];
        //productosText.append("Hay escasez de los siguientes materiales:\n");
        int i =0;
        for(i = 0;i < material.length; i++){
            material[i]=(materials[i].getQuantity()+", "+materials[i].getName());
        }
        return material;
    }
    public String[] setNotebook(){//type ammount
        //productosText.append("Hay escasez de los siguientes cuadernos:\n");
        String [] notebooks = Handler.getShortageOfNotebooks();
        notebook= new String[notebooks.length];
        for(int j = 0;j < notebooks.length; j++){
            notebook[j]=(notebooks[j]);
        }
        return notebook;
    }
}
