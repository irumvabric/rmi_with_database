package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(6666);
            Bank b = new BankImpl();
            Naming.rebind("rmi://localhost:6666/me",b);

            System.out.println("Le serveur est pret");

        } catch (RemoteException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}