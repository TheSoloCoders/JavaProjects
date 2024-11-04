package roy.aman;

import java.io.*;
import java.util.ArrayList;

public class Car {

    private int ID;
    private String Maker, Name, Colour, Type;
    private int SeatingCapacity;
    private String RegNo;
    private int RentPerHour;
    private CarOwner carOwner;

    // Important Methods
    public void Add() {
        ArrayList<Car> cars = Car.View();
        if (cars.isEmpty()) {
            this.ID = 1;
        } else {
            this.ID = cars.get(cars.size() - 1).ID + 1; // Auto ID...
        }
        cars.add(this);
        File file = new File("Car.ser");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

        writeToFile(cars);
    }


    public void Update() {
        ArrayList<Car> car = Car.View();

        // for loop for replacing the new Car object with old one with same ID
        for (int i = 0; i < car.size(); i++) {
            if (car.get(i).ID == ID) {
                car.set(i, this);
            }
        }

        writeToFile(car);
    }

    public void Remove() {

        ArrayList<Car> car = Car.View();
        // for loop for deleting the required Car
        for (int i = 0; i < car.size(); i++) {
            if ((car.get(i).ID == ID)) {
                car.remove(i);
            }
        }

        writeToFile(car);

    }

    private void writeToFile(ArrayList<Car> cars){
        // code for writing new Car record
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("car.ser"));
            for (int i = 0; i < cars.size(); i++) {
                outputStream.writeObject(cars.get(i));
                System.out.println("New Record added Successfully!");
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

    public static ArrayList<Car> SearchByName(String name) {
        ArrayList<Car> car = Car.View();
        ArrayList<Car> s = new ArrayList<>();
        for (int i = 0; i < car.size(); i++) {
            if (car.get(i).Name.equalsIgnoreCase(name)) {
                s.add(car.get(i));
            }
        }
        return s;
    }

    public static Car SearchByID(int id) {
        ArrayList<Car> car = Car.View();
        for (int i = 0; i < car.size(); i++) {
            if (car.get(i).ID == id) {
                return car.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Car> View() {
        ArrayList<Car> carList = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("Car.ser"));
            boolean EOF = false;
// Keep reading file until file ends
            while (!EOF) {
                try {
                    Car myObj = (Car) inputStream.readObject();
                    carList.add(myObj);
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
        return carList;
    }


    //Constructors


    public Car(int ID, String maker, String name, String colour, String type, int seatingCapacity, String regNo, int rentPerHour, CarOwner carOwner) {

        this.ID = ID;
        Maker = maker;
        Name = name;
        Colour = colour;
        Type = type;
        SeatingCapacity = seatingCapacity;
        RegNo = regNo;
        RentPerHour = rentPerHour;
        this.carOwner = carOwner;
    }

    public Car() {
    }

    // Getters-Setters


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaker() {
        return Maker;
    }

    public void setMaker(String maker) {
        Maker = maker;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getSeatingCapacity() {
        return SeatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        SeatingCapacity = seatingCapacity;
    }

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String regNo) {
        RegNo = regNo;
    }

    public int getRentPerHour() {
        return RentPerHour;
    }

    public void setRentPerHour(int rentPerHour) {
        RentPerHour = rentPerHour;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    // ToString

    @Override
    public String toString() {
        return "Car{" +
                "ID=" + ID +
                ", Maker='" + Maker + '\'' +
                ", Name='" + Name + '\'' +
                ", Colour='" + Colour + '\'' +
                ", Type='" + Type + '\'' +
                ", SeatingCapacity=" + SeatingCapacity +
                ", RegNo='" + RegNo + '\'' +
                ", RentPerHour=" + RentPerHour +
                ", carOwner=" + carOwner +
                '}';
    }
}
