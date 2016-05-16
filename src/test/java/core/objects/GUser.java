package core.objects;

import core.data.Constants;

/**
 * Created by bogat on 5/2/2016.
 */
public class GUser {

    private String name;
    private String surname;
    private String email;
    private String password;

    /*************************************************************************************
     * *                                     Constructors                                **
     *************************************************************************************/

    public GUser(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public GUser() {
        this.name = Constants.DEFAULT_USER_NAME;
        this.surname = Constants.DEFAULT_USER_SURNAME;
        this.email = Constants.DEFAULT_USER_EMAIL;
        this.password = Constants.DEFAULT_USER_PASSWORD;
    }

    /*************************************************************************************
     * *                                     Getters                                     **
     *************************************************************************************/

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() { return surname; }

    /*************************************************************************************
     * *                                     Setters                                     **
     *************************************************************************************/

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*************************************************************************************
     * *                                     Others                                     **
     *************************************************************************************/

    public boolean equals(GUser user) {
        if(this.name.equals(user.name) & this.surname.equals(user.surname))
            return true;
        else
            return false;
    }
}
