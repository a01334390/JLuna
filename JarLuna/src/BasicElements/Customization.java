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
public class Customization {
    private int id;
    private String ribbon;
    private String image;
    private String elastic;
    private String pagetype;

    public Customization(int id, String ribbon, String image, String elastic, String pagetype) {
        this.id = id;
        this.ribbon = ribbon;
        this.image = image;
        this.elastic = elastic;
        this.pagetype = pagetype;
    }

    public String getPagetype() {
        return pagetype;
    }

    public void setPagetype(String pagetype) {
        this.pagetype = pagetype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
}
