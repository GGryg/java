import java.time.LocalDate;

public class Flat extends Building {
    private int floor;
    private int flatNumber;

    public Flat(String street, int number, String city, String postalCode, double area, LocalDate offerDate, double price, int floor, int flatNumber){
        super(street, number, city, postalCode, area, offerDate, price);
        this.floor = floor;
        this.flatNumber = flatNumber;
    }

    public int getFloor(){
        return floor;
    }

    public int getFlatNumber(){
        return flatNumber;
    }

    public String toString() {
        return "Street: " + getStreet() + ", " + getNumber() + "/" + flatNumber + ", floor: " + floor + ", city: " + getCity() + ", postal code: " + getPostalCode() + ", area: " + getArea() + ", price: " + getPrice() + ", offer time: " + getOfferDate();
    }
}
