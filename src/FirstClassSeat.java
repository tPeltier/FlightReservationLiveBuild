
public class FirstClassSeat extends FlightSeat {
    public FirstClassSeat() {
        classType = "First Class";
        extraCharge = 220.78;
    }
    public void classGreeting() {
        System.out.println("---Wow, you're fancy! Thanks for flying first class!---");
    }
}
