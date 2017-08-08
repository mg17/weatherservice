package com.bytebistro.weatherservice;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignupForm {

    @NotNull
    @Size(min = 3)
    private String email;

    @NotNull
    @Size(min = 5)
    private String password;

    @NotNull
    @Size(min = 5)
    private String password_confirmation;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Email: " + this.email + "\nPassword: " + this.password;
    }
}
