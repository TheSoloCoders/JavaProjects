package roy.aman;

import java.io.*;
import java.util.ArrayList;

public class Booking {

    private int ID;
    private Customer customer;
    private Car car;
    private long RentTime; //time when the Book() method is called
    private long ReturnTime;


    //Important Business methods
    public void Add() {
        ArrayList<Booking> booking = Booking.View();
        if (booking.isEmpty()) {
            this.ID = 1;
        } else {
            this.ID = booking.get(booking.size() - 1).ID + 1; // Auto ID ...
        }
        this.ReturnTime = 0;
        booking.add(this);
        File file = new File("Booking.ser");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

        writeToFile(booking);
     }

    private void writeToFile(ArrayList<Booking> bookings) {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("Booking.ser"));
            for (int i = 0; i < bookings.size(); i++) {
                outputStream.writeObject(bookings.get(i));
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
        ArrayList<Booking> booking = Booking.View();

        // for loop for replacing the new Booking object with old one with same ID
        for (int i = 0; i < booking.size(); i++) {
            if (booking.get(i).ID == ID) {
                booking.set(i, this);
            }
        }
        writeToFile(booking);
    }

    public void Remove() {

        ArrayList<Booking> booking = Booking.View();
        // for loop for deleting the required Booking
        for (int i = 0; i < booking.size() - 1; i++) {
            if ((booking.get(i).ID == ID)) {

                for (int j = i; j < booking.size() - 1; j++) {
                    booking.set(j, (booking.get(j + 1)));
                }

            }
        }

        writeToFile(booking);
    }

    public int calculateBill() {
        // rent calculation
        long rentTime = this.getRentTime();
        long returnTime = this.getReturnTime();
        long totalTime = returnTime - rentTime;
        totalTime = totalTime / (1000 * 60 * 60);

        int rentPerHour = this.getCar().getRentPerHour();
        if (totalTime != 0) {
            return (int) (rentPerHour * totalTime);
        } else {
            return rentPerHour;
        }
    }

    public static ArrayList<Booking> SearchByCustomerID(int CustomerID) {
        ArrayList<Booking> bookingList = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("Booking.ser"));
            boolean EOF = false;
// Keep reading file until file ends
            while (!EOF) {
                try {
                    Booking myObj = (Booking) inputStream.readObject();
                    if (myObj.customer.getId() == CustomerID) {
                        bookingList.add(myObj);
                    }
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
        return bookingList;
    }

    public static ArrayList<Booking> SearchByCarID(int carID) {
        ArrayList<Booking> bookingList = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("Booking.ser"));
            boolean EOF = false;
// Keep reading file until file ends
            while (!EOF) {
                try {
                    Booking myObj = (Booking) inputStream.readObject();
                    if (myObj.car.getID() == carID) {
                        bookingList.add(myObj);
                    }
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
        return bookingList;
    }

    public static ArrayList<Booking> View() {
        ArrayList<Booking> bookingList = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("Booking.ser"));
            boolean EOF = false;
// Keep reading file until file ends
            while (!EOF) {
                try {
                    Booking myObj = (Booking) inputStream.readObject();
                    bookingList.add(myObj);
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
        return bookingList;
    }

    public static ArrayList<Car> getBookedCars() {
        ArrayList<Car> bookedCars = new ArrayList<>();
        ArrayList<Booking> bookings = Booking.View();
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).ReturnTime == 0) {
                bookedCars.add(bookings.get(i).car);
            }
        }
        return bookedCars;
    }

    public static ArrayList<Car> getUnbookedCars() {
        ArrayList<Car> allCars = Car.View();
        ArrayList<Car> bookedCars = Booking.getBookedCars();
        for (int i = 0; i < bookedCars.size(); i++) {
            allCars.remove(bookedCars.get(i));
        }
        return allCars;
    }

    //Getter Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public long getRentTime() {
        return RentTime;
    }

    public void setRentTime(long rentTime) {
        RentTime = rentTime;
    }

    public long getReturnTime() {
        return ReturnTime;
    }

    public void setReturnTime(long returnTime) {
        ReturnTime = returnTime;
    }

    public Booking(int ID, Customer customer, Car car, long rentTime, long returnTime) {
        this.ID = ID;
        this.customer = customer;
        this.car = car;
        RentTime = rentTime;
        ReturnTime = returnTime;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "ID=" + ID +
                ", customer=" + customer +
                ", car=" + car +
                ", RentTime=" + RentTime +
                ", ReturnTime=" + ReturnTime +
                '}';
    }
}
