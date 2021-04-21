 /**
 * calculates distance between chosen cities 
 */
public class DistanceCalculator {
 /**
 * calculates distance between chosen cities
 * @param city1 departure city
 * @param city2 arrival city
 * @return distance
 */
    public double calculateDistance(City city1, City city2) {
        double latitude1 = city1.getLatitude();
        double longitude1 = city1.getLongitude();
        double latitude2 = city2.getLatitude();
        double longitude2 = city2.getLongitude();
        // Had to look up these formulas on google obviously
        double longitudeDifference =  longitude1 - longitude2;
        double distance = Math.sin(degreeToRadian(latitude1)) * Math.sin(degreeToRadian(latitude2)) + Math.cos(degreeToRadian(latitude1)) * Math.cos(degreeToRadian(latitude2)) * Math.cos(degreeToRadian(longitudeDifference));
        distance = Math.acos(distance);
        distance = radianToDegree(distance);
        distance = distance * 60 * 1.1515;
        return distance;
    }
/**
* @param degree
* @return degree converted to radians
*/
    private double degreeToRadian(double degree) {
        return degree * Math.PI / 180.0;
    }
/**
* @param radian
* @return radian converted to degree
*/
    private double radianToDegree(double radian) {
         return (radian * 180.0 / Math.PI);
    }
}
