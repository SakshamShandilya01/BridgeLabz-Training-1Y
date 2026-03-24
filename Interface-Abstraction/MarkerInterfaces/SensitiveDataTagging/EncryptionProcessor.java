package com.gla.interfacesabstraction.MarkerInterfaces.SensitiveDataTagging;

public class EncryptionProcessor {

    public static void process(Object obj) {

        if (obj instanceof SensitiveData) {
            System.out.println("Sensitive data detected. Encrypting...");
        } else {
            System.out.println("Normal data. No encryption required.");
        }
    }
}
