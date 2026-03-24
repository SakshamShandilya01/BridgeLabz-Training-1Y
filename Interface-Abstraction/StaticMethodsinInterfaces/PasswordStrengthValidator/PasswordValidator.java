package com.gla.interfacesabstraction.StaticMethodsinInterfaces.PasswordStrengthValidator;


public class PasswordValidator {

    public static void main(String[] args) {

        String password = "Secure@123";

        boolean result = SecurityUtils.isStrongPassword(password);

        if (result)
            System.out.println("Strong Password ✅");
        else
            System.out.println("Weak Password ❌");
    }
}