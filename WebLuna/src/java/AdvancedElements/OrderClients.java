/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdvancedElements;
import BasicElements.Material;
import DatabaseManager.Handler;
/**
 *
 * @author Arpi
 */
public class OrderClients {
    String[] clients;
    public OrderClients(){
        this.clients=clients;
    }
    public String[] getMostOrderedNotebooks(){
        String [] notebooks = Handler.getMostOrderedNotebooks();
        clients= new String[notebooks.length];
        //textArea1.append("Pedidos ordenados por cliente con mayor cantidad de cuadernos a menor\n"
        //        + "ID \t Nombre \t Status \t Prioridad \t Cantidad \n");
        for(int i = 0;i < notebooks.length; i++){
            clients[i]=(notebooks[i]+"\n");
        }
        return clients;
    }
    public String[] getNotebooksByPriority(){
        String [] notebooks = Handler.getMostOrderedNotebooksWithPriority();
        clients= new String[notebooks.length];
        //textArea1.append("Pedidos ordenados por prioridad\n"
        //        + "ID \t Nombre \t Cantidad \t Status \t Prioridad\n");
        for(int i = 0; i < notebooks.length; i++){
            clients[i]=(notebooks[i]+"\n");
        }
        return clients;
    }
     public String[] getNotebooksByStatus(){
        String [] notebooks = Handler.getMostOrderedNotebooksWithStatus();
        clients= new String[notebooks.length];
        //textArea1.append("Pedidos ordenados por status\n"
        //        + "ID \t Nombre \t Cantidad \t Prioridad \t Status\n");
        for(int i = 0; i < notebooks.length; i++){
            clients[i]=(notebooks[i]+"\n");
        }  
        return clients;
    }
}
