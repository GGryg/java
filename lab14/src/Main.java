import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program for sale offers for houses and flats!");

        Scanner scanOption = new Scanner(System.in);
        boolean run = true;
        OfferList offerList = new OfferList();
        // adds some example house and flat offers
        addTestOffers(offerList);
        while (run) {
            printOptions();
            String option = scanOption.next();
            switch (option) {
                case "1" -> addHouseOffer(offerList);
                case "2" -> addFlatOffer(offerList);
                case "3" -> getAllHouseOffer(offerList);
                case "4" -> getAllFlatOffer(offerList);
                case "5" -> getAllHouseOfferThat(offerList);
                case "6" -> getAllFlatOfferThat(offerList);
                case "7" -> {
                    run = false;
                    System.out.println("Exiting the program");
                }
            }
        }
    }

    public static void printOptions(){
        System.out.println("========================================");
        System.out.println("1) add a house offer");
        System.out.println("2) add a flat offer");
        System.out.println("3) get all up to date house offers");
        System.out.println("4) get all up to date flat offers");
        System.out.println("5) get all up to date house offers that are in city c, with area at least y");
        System.out.println("6) get all up to date flat offers that are in city c, on higher floor than x and with prica at most y");
        System.out.println("7) exit");
        System.out.println("========================================");
    }

    public static void addHouseOffer(OfferList offerList){
        Scanner scan = new Scanner(System.in);
        System.out.print("Street: ");
        String street = scan.next();
        System.out.print("Number: ");
        int number = scan.nextInt();
        System.out.print("City: ");
        String city = scan.next();
        System.out.print("Postal code: ");
        String postalCode = scan.next();
        System.out.print("Area: ");
        double area = scan.nextDouble();
        System.out.print("Price: ");
        double price = scan.nextDouble();
        System.out.print("Land area: ");
        double landArea = scan.nextDouble();
        System.out.print("offer date (yyyy-mm-dd): ");
        LocalDate offerDate = LocalDate.parse(scan.next());

        House houseOffer = new House(street, number, city, postalCode, area, offerDate, price, landArea);
        offerList.addHouse(houseOffer);
    }

    public static void addFlatOffer(OfferList offerList){
        Scanner scan = new Scanner(System.in);
        System.out.print("Street: ");
        String street = scan.next();
        System.out.print("Number: ");
        int number = scan.nextInt();
        System.out.print("Flat number: ");
        int flatNumber = scan.nextInt();
        System.out.print("Floor: ");
        int floor = scan.nextInt();
        System.out.print("City: ");
        String city = scan.next();
        System.out.print("Postal code: ");
        String postalCode = scan.next();
        System.out.print("Area: ");
        double area = scan.nextDouble();
        System.out.print("Price: ");
        double price = scan.nextDouble();
        System.out.print("offer date (yyyy-mm-dd): ");
        LocalDate offerDate = LocalDate.parse(scan.next());

        Flat flatOffer = new Flat(street, number, city, postalCode, area, offerDate, price, floor, flatNumber);
        offerList.addFlat(flatOffer);
    }

    public static void getAllHouseOffer(OfferList offerList){
        LocalDate now = LocalDate.now();
        Predicate<Building> pred = (Building offer) -> offer instanceof House && (offer.getOfferDate().isAfter(now) || offer.getOfferDate().isEqual(now));
        System.out.println(getString(offerList.getOffers(pred)));
    }

    public static void getAllFlatOffer(OfferList offerList){
        LocalDate now = LocalDate.now();
        Predicate<Building> pred = (Building offer) -> offer instanceof Flat && (offer.getOfferDate().isAfter(now) || offer.getOfferDate().isEqual(now));
        offerList.getOffers(pred);
        System.out.println(getString(offerList.getOffers(pred)));
    }

    public static void getAllHouseOfferThat(OfferList offerList){
        Scanner scan = new Scanner(System.in);
        System.out.print("City: ");
        String city = scan.next();
        System.out.print("Area: ");
        double area = scan.nextDouble();
        LocalDate now = LocalDate.now();
        Predicate<Building> pred = (Building offer) -> offer instanceof House && (offer.getOfferDate().isAfter(now) || offer.getOfferDate().isEqual(now)) && offer.getCity().equals(city) && offer.getArea() >= area;
        System.out.println(getString(offerList.getOffers(pred)));
    }

    public static void getAllFlatOfferThat(OfferList offerList){
        Scanner scan = new Scanner(System.in);
        System.out.print("City: ");
        String city = scan.next();
        System.out.print("Price: ");
        double price = scan.nextDouble();
        System.out.print("Floor: ");
        int floor  = scan.nextInt();
        LocalDate now = LocalDate.now();
        Predicate<Building> pred = (Building offer) -> offer instanceof Flat && (offer.getOfferDate().isAfter(now) || offer.getOfferDate().isEqual(now)) && offer.getCity().equals(city) && offer.getPrice() <= price && ((Flat)offer).getFloor() >= floor;
        System.out.println(getString(offerList.getOffers(pred)));
    }

    public static String getString(ArrayList<Building> list){
        StringBuilder str = new StringBuilder();
        for(Building offer : list){
            str.append(offer.toString());
            str.append("\n");
        }

        return str.toString();
    }

    public static void addTestOffers(OfferList offerList){
        House house1 = new House("Ulica1", 1, "Gdansk", "99-333", 100, LocalDate.parse("2023-05-22"), 800, 120);
        House house2 = new House("Ulica1", 2, "Gdansk", "99-333", 80, LocalDate.parse("2023-05-26"), 600, 120);
        House house3 = new House("Ulica2", 1, "Gdynia", "99-333", 100, LocalDate.parse("2023-05-30"), 800, 120);
        House house4 = new House("Ulica3", 2, "Gdynia", "99-444", 120, LocalDate.parse("2023-06-20"), 1000, 140);
        House house5 = new House("Ulica1", 4, "Gdansk", "99-333", 100, LocalDate.parse("2023-06-10"), 800, 120);

        Flat flat1 = new Flat("Ulica3", 1, "Gdansk", "99-333", 30, LocalDate.parse("2023-05-22"), 700, 3, 2);
        Flat flat2 = new Flat("Ulica3", 1, "Gdansk", "99-333", 32, LocalDate.parse("2023-05-30"), 800, 4, 6);
        Flat flat3 = new Flat("Ulica4", 2, "Gdynia", "99-333", 35, LocalDate.parse("2023-05-25"), 600, 3, 3);
        Flat flat4 = new Flat("Ulica5", 4, "Gdynia", "99-444", 40, LocalDate.parse("2023-06-20"), 100, 6, 10);
        Flat flat5 = new Flat("Ulica6", 1, "Gdansk", "99-333", 34, LocalDate.parse("2023-05-30"), 700, 3, 2);

        offerList.addHouse(house1);
        offerList.addHouse(house2);
        offerList.addHouse(house3);
        offerList.addHouse(house4);
        offerList.addHouse(house5);

        offerList.addFlat(flat1);
        offerList.addFlat(flat2);
        offerList.addFlat(flat3);
        offerList.addFlat(flat4);
        offerList.addFlat(flat5);
    }


}