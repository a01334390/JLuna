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
public class AVOrderNotebook {
    private String type;
    private String ribbon;
    private String elastic;
    private String pageType;
    private String image;

    public AVOrderNotebook(String type, String ribbon, String elastic, String pageType, String image) {
        this.type = type;
        this.ribbon = ribbon;
        this.elastic = elastic;
        this.pageType = pageType;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRibbon() {
        return ribbon;
    }

    public void setRibbon(String ribbon) {
        this.ribbon = ribbon;
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
