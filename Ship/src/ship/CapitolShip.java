
package ship;

public class CapitolShip extends Ship{
    private int shields;
    private boolean shieldsUp;
    
    public CapitolShip(String type, double speed, int hStrength, int wStrength, int totalMass, int shield, boolean shieldUp){
        super(type, speed, hStrength, wStrength, totalMass);
        shieldsUp = shieldUp;
        shields = shield;
    }
}
