public class DistanceCalculator {
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
    private double degreeToRadian(double degree) {
        return degree * Math.PI / 180.0;
    }
    private double radianToDegree(double radian) {
         return (radian * 180.0 / Math.PI);
    }
}
