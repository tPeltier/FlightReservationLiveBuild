/**
 * city class
 */
public class City {
    private double latitude;
    private double longitude;
    private String name;
/**
* @param name guests name
* @param latitude of city 
* @param longitude of city
 */
    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
/**
* @return latitude 
*/
    public double getLatitude() {
        return latitude;
    }
/**
* @return longitude 
*/
    public double getLongitude() {
        return longitude;
    }
/**
*@return name 
*/
     public String getName() {
        return name;
    }
}
