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
public class NotebookMaterial {
    private int notebook_id;
    private int material_id;
    private int ammount;

    public NotebookMaterial(int notebook_id, int material_id, int ammount) {
        this.notebook_id = notebook_id;
        this.material_id = material_id;
        this.ammount = ammount;
    }

    public int getNotebook_id() {
        return notebook_id;
    }

    public void setNotebook_id(int notebook_id) {
        this.notebook_id = notebook_id;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
    
}
