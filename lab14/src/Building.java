import java.time.LocalDate;

public abstract class Building  {
    private String street;
    private int number;
    private String city;
    private String postalCode;
    private double area;
    private LocalDate offerDate;
    private double price;

    protected Building(String street, int number, String city, String postalCode, double area, LocalDate offerDate, double price){
        this.street = street;
        this.number = number;
        this.city = city;
        this.postalCode = postalCode;
        this.area = area;
        this.offerDate = offerDate;
        this.price = price;
    }

    protected String getStreet(){
        return street;
    }

    protected int getNumber(){
        return number;
    }

    protected String getCity(){
        return city;
    }

    protected String getPostalCode(){
        return postalCode;
    }
    protected double getArea(){
        return area;
    }

    protected LocalDate getOfferDate(){
        return offerDate;
    }
    protected double getPrice(){
        return price;
    }

}
