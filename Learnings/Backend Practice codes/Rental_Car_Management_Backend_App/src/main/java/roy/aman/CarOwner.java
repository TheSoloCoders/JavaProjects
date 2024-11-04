package roy.aman;

import java.io.*;
import java.util.ArrayList;

public class CarOwner extends Person implements Serializable {

    private int totalIncome; // will increase every HOUR when Owner's car(s) is booked

// Important Methods
public void Add() {
    ArrayList<CarOwner> carOwners = CarOwner.View();
    if (carOwners.isEmpty()) {
        this.setId(1);
    } else {
        this.setId(carOwners.get(carOwners.size() - 1).getId() + 1); // Auto Id Increment
    }
    carOwners.add(this);
    File file = new File("CarOwner.ser");
    if (!file.exists()) {
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    writeToFile(carOwners);

}

    public void Update() {
        ArrayList<CarOwner> carOwner = CarOwner.View();
        // for loop for replacing the new CarOwner object with old one with same Id
        for (int i = 0; i < carOwner.size(); i++) {
            if (carOwner.get(i).getId() == this.getId()) {
                carOwner.set(i, this);
            }
        }
        writeToFile(carOwner);
    }

    public void Remove(int ownerId) {
        ArrayList<CarOwner> carOwner = CarOwner.View();
        // for loop for deleting the required CarOwner
        for (int i = 0; i < carOwner.size(); i++) {
            if ((carOwner.get(i).getId() == ownerId)) {
                carOwner.remove(i);
            }
        }
        writeToFile(carOwner);
    }

    private void writeToFile(ArrayList<CarOwner> carOwners){

        // code for writing new CarOwner record
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("CarOwner.ser"));
            for (int i = 0; i < carOwners.size(); i++) {
                outputStream.writeObject(carOwners.get(i));
            }
            System.out.println("New Record Added Successfully!!");
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

    public static ArrayList<CarOwner> SearchByName(String name) {
        ArrayList<CarOwner> carOwner = CarOwner.View();
        ArrayList<CarOwner> s = new ArrayList<>();

        for (int i = 0; i < carOwner.size(); i++) {
            if (carOwner.get(i).getName().equalsIgnoreCase(name)) {
                s.add(carOwner.get(i));
            }
        }
        return s;
    }

    public static CarOwner SearchByID(int id) {
        ArrayList<CarOwner> carOwner = CarOwner.View();
        for (int i = 0; i < carOwner.size(); i++) {
            if (carOwner.get(i).getId() == id) {
                return carOwner.get(i);
            }
        }
        return null;
    }

    public ArrayList<Car> getAllCars() {
        ArrayList<Car> cars = Car.View();
        ArrayList<Car> car1 = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getCarOwner().getId() == this.getId()) {
                car1.add(cars.get(i));
            }
        }
        return car1;
    }

    public static ArrayList<CarOwner> View() {
        ArrayList<CarOwner> carOwnerList = new ArrayList<>(0);
        ObjectInputStream inputStream = null;
        try {
        // open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("CarOwner.ser"));
            boolean EOF = false;
        // Keep reading file until file ends
            while (!EOF) {
                try {
                    CarOwner myObj = (CarOwner) inputStream.readObject();
                    carOwnerList.add(myObj);
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
        return carOwnerList;
    }


// Getter- Setters and Constructors
    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public CarOwner(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    @Override
    public String toString() {
        return "CarOwner{" +
                "totalIncome=" + totalIncome +
                '}';
    }
}
