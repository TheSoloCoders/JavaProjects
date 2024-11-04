package roy.aman;

import java.io.*;
import java.util.ArrayList;

public class Customer extends Person implements Serializable {

    private int Bill; // increases after every HOUR after Booking the car


    //Important Methods

    public void Add() {
        ArrayList<Customer> customers = Customer.View();
        if (customers.isEmpty()) {
            this.setId(1);
        } else {
            this.setId(customers.get((customers.size() - 1)).getId() + 1); // Auto ID increment
        }
        customers.add(this);
        File file = new File("Customer.ser");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        writeToFile(customers);
    }

    private void writeToFile(ArrayList<Customer> customers) {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("Customer.ser"));
            for (int i = 0; i < customers.size(); i++) {
                outputStream.writeObject(customers.get(i));
                System.out.println("Record Added to File!!");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public void Update() {
        ArrayList<Customer> customers = Customer.View();

        // for loop for replacing the new Customer object with old one with same ID
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == this.getId()) {
                customers.set(i, this);
            }
        }
        writeToFile(customers);
    }

    public void Remove() {

        ArrayList<Customer> customers = Customer.View();

        // for loop for deleting the required Customer
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == this.getId()) {
                customers.remove(i);
            }
        }

        writeToFile(customers);
    }

    public static ArrayList<Customer> SearchByName(String name) {
        ArrayList<Customer> customers = Customer.View();
        ArrayList<Customer> s = new ArrayList<>();

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equalsIgnoreCase(name)) {
                s.add(customers.get(i));
            }
        }
        return s;
    }


    public static Customer SearchByID(int id) {
        ArrayList<Customer> customers = Customer.View();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                return customers.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Customer> View() {
        ArrayList<Customer> CustomerList = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("Customer.ser"));
            boolean EOF = false;
// Keep reading file until file ends
            while (!EOF) {
                try {
                    Customer myObj = (Customer) inputStream.readObject();
                    CustomerList.add(myObj);
                } catch (ClassNotFoundException e) {
                    System.out.println(e);
                } catch (EOFException end) {
                    EOF = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return CustomerList;
    }

    //getters-Setters

    public int getBill() {
        return Bill;
    }

    public void setBill(int bill) {
        Bill = bill;
    }
}
