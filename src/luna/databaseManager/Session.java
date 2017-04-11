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
package luna.databaseManager;

/**
 *
 * @author a01334390
 */
public class Session {

    private String username, email, firstname, secondname, privilege, imagepath;
    private boolean isValidated;

    public Session(String username, String email, String firstname, String secondname, String privilege, String imagepath) {
        this.username = username;
        this.firstname = firstname;
        this.secondname = secondname;
        this.privilege = privilege;
        this.imagepath = imagepath;
        this.email = email;
        isValidated = true;
    }

    public String getEmail() {
        return email;
    }

    public Session() {
        isValidated = false;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public String getPrivilege() {
        return privilege;
    }

    public String getImagepath() {
        return imagepath;
    }

    public boolean isIsValidated() {
        return isValidated;
    }

    public void setIsValidated(boolean isValidated) {
        this.isValidated = isValidated;
    }

}
