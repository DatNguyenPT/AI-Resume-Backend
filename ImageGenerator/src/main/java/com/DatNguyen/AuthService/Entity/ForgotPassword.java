package com.DatNguyen.AuthService.Entity;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ForgotPassword {
    @Size(min=5, max=15, message="Password length must be at least 5 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$")
    private String password;

    @Size(min=5, max=15, message="Password length must be at least 5 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$")
    private String retypePassword;

    public ForgotPassword() {}

    public ForgotPassword(String password, String retypePassword) {
        this.password = password;
        this.retypePassword = retypePassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }
}
