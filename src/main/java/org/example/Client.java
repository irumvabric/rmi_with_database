package org.example;

import java.net.MalformedURLException;
import java.util.List;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) {


        Bank b;

        {
            try {
                b = (Bank) Naming.lookup("rmi://localhost:6666/me");

                List<Customer> list = b.getCustomers();

                for (Customer c : list) {
                    System.out.println(c.getAcc_no() + " " + c.getFirstname() + " " + c.getLastname()
                            + " " + c.getEmail() + " " + c.getAmount());
                }

            } catch (NotBoundException e) {
                System.out.println(e.toString());
                throw new RuntimeException(e);
            } catch (MalformedURLException e) {
                System.out.println(e.toString());
                throw new RuntimeException(e);
            } catch (RemoteException e) {
                System.out.println(e.toString());
                throw new RuntimeException(e);
            }
        }

    }
}
