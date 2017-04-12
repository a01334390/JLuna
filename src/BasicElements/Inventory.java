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
public class Inventory {
    private int id_Notebook;
    private int ammount;

    public Inventory(int ammount,int id_Notebook) {
        this.id_Notebook = id_Notebook;
        this.ammount = ammount;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public int getId_Notebook() {
        return id_Notebook;
    }

    public void setId_Notebook(int id_Notebook) {
        this.id_Notebook = id_Notebook;
    }
    
    
}
