package models.user;

import enums.UserRole;

public class Admin extends User {

    public Admin(String name) {
        super(name, UserRole.ADMIN);
    }
}
