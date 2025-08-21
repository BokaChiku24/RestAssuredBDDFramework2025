package resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
    public AddPlace addPlacePayLoad(){
        AddPlace place = new AddPlace();
        place.setAccuracy(50);
        place.setAddress("29, side ayout, cohen 09");
        place.setLanguage("French-IN");
        place.setPhone_number("(91) 983 893 3973");
        place.setWebsite("https://rahulshettyacademy.com");
        place.setName("katraj Dhankawadi");
        List<String> myList = new ArrayList<String>();
        myList.add("Shoe Park");
        myList.add("Shop");
        place.setTypes(myList);
        Location location = new Location();
        location.setLat(-38.3456);
        location.setLng(30.3456);
        place.setLocation(location);
        return place;
    }
}
