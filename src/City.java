
public class City {
    private double latitude;
    private double longitude;
    private String name;
    
    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getName() {
        return name;
    }
}
