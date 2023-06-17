import java.time.LocalDate;

public class House extends Building {
    private double landArea;

    public House(String street, int number, String city, String postalCode, double area, LocalDate offerDate, double price, double landArea){
        super(street, number, city, postalCode, area, offerDate, price);
        this.landArea = landArea;
    }

    public double getLandArea(){
        return landArea;
    }

    public String toString() {
        return "Street: " + getStreet() + ", " + getNumber() + ", city: " + getCity() + ", postal code: " + getPostalCode() + ", area: " + getArea() + ", land area: " + landArea + ", price: " + getPrice() + ", offer time: " + getOfferDate();
    }
}
