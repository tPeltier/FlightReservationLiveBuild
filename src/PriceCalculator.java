import java.util.ArrayList;
import java.util.Random;
/**
 * class that calculates the price of the flight using a random generator
 * 
 */
public class PriceCalculator {
    
    private static final double BASECHARGE = 50;
    private ArrayList<FlightSeat> sl = new ArrayList<>();
    private double distance;
    /**
     * @param distance of flight
     */
    public PriceCalculator(double distance)
    {
       
        this.distance = distance;
        
    }
     /**
     * * @param sl 
     */
    public PriceCalculator(ArrayList<FlightSeat> sl)
    {
         this.sl = sl;
    }
     /**
     * @return fee
     */
    public double getPrice()
    {
        // equation source:
        // https://www.rome2rio.com/blog/2013/01/02/170779446/
        // plus a random number
        Random randomGenerator = new Random();
        double randomNumber = randomGenerator.nextDouble() * 10.0;
        
        double fee = BASECHARGE + (distance * .09) + randomNumber;
        return fee;
    }
     /**
     * @param seatNumber
     * @return sl 
     */
    public double getSeatUpcharge(int seatNumber)
    {
       return sl.get(seatNumber - 1).getExtraCharge();
    }

    
}
