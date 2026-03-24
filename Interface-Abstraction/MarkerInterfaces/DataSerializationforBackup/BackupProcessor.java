package com.gla.interfacesabstraction.MarkerInterfaces.DataSerializationforBackup;

import java.io.Serializable;

public class BackupProcessor {

    public static void processBackup(Object obj) {

        if (obj instanceof Serializable) {
            System.out.println("Object is Serializable. Backup allowed.");
        } else {
            System.out.println("Object is NOT Serializable. Backup denied.");
        }
    }
}
