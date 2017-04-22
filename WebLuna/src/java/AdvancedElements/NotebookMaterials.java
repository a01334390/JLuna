/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdvancedElements;

import BasicElements.NotebookMaterial;
import static DatabaseManager.Handler.*;

/**
 *
 * @author Arpi
 */
public class NotebookMaterials {
    int id;
    int materialid;
    int quantity;
    String[] materials;
    public NotebookMaterials(int id, int materialid, int quantity){
        this.id=id;
        this.materialid=materialid;
        this.quantity=quantity;
    }
    public NotebookMaterials(){
        
    }
    public String[] getMaterials(String notebookid){
        //NotebookMaterial material= new NotebookMaterial();
        System.out.println(" iniciated");
        NotebookMaterial[] material=getMaterialsofNotebook(Integer.parseInt(notebookid));
        materials = new String[material.length];
        System.out.println(material.length+ " fsdfsdfdsfsdfsd");
        for (int i = 0; i < material.length; i++) {
            materials[i]= material[i].getNotebook_id()+", "+material[i].getMaterial_id() +", "+material[i].getAmmount();
        }
        return materials;
    }
}
