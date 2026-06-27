
public class Car {
    String make;
    String model;
    int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void displayDetails() {
        System.out.println("Make: " + make + ", Model: " + model + ", Year: " + year);
    }

    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Camry", 2020);
        Car c2 = new Car("Honda", "Civic", 2022);
        c1.displayDetails();
        c2.displayDetails();
    }
}
