import java.util.ArrayList;
import java.util.function.Predicate;

public class OfferList {
    ArrayList<Building> offerList = new ArrayList<>();

    public OfferList(){

    }

    public void addHouse(House house){
        offerList.add(house);
    }

    public void addFlat(Flat flat){
        offerList.add(flat);
    }

    public ArrayList<Building> getOffers(Predicate<Building> pred){
        ArrayList<Building> ret = new ArrayList<>();

        for(Building offer : offerList){
            if(pred.test(offer)){
                ret.add(offer);
            }
        }

        return ret;
    }
}
