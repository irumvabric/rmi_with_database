package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankImpl extends UnicastRemoteObject implements Bank{
    BankImpl()throws RemoteException {}

    public List<Customer> getCustomers(){
        List<Customer> list=new ArrayList<Customer>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rmi_app","root","");
            PreparedStatement ps=con.prepareStatement("select * from customer");
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Customer c=new Customer();
                c.setAcc_no(rs.getInt(1));
                c.setFirstname(rs.getString(2));
                c.setLastname(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setAmount(rs.getFloat(5));
                list.add(c);
            }
            System.out.println("La reponse not ok : 1");

            con.close();
        }catch(Exception e){
            System.out.println(e);
            System.out.println("La reponse not ok : 2");
        }
        return list;
    }//end of getCustomers()
}