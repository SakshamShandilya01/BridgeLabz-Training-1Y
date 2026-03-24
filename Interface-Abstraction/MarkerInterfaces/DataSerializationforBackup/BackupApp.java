package com.gla.interfacesabstraction.MarkerInterfaces.DataSerializationforBackup;

public class BackupApp {

    public static void main(String[] args) {

        UserData user = new UserData("Uttkarsh", "uttkarsh@email.com");

        BackupProcessor.processBackup(user);
    }
}
