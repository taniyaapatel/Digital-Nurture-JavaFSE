
public class Car {
    String mk;
    String md;
    int yr;

    public Car(String mk, String md, int yr) {
        this.mk = mk;
        this.md = md;
        this.yr = yr;
    }

    public void displayDetails() {
        System.out.println("Make: " + mk + ", Model: " + md + ", Year: " + yr);
    }

    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Camry", 2020);
        Car c2 = new Car("Honda", "Civic", 2022);
        c1.displayDetails();
        c2.displayDetails();
    }
}
