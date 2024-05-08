/**
* This is a bootleg version of Pokemon which can create objects (pokemon)
* and make them battle.(updated to include toString and attack selection.)
* @author Roberto Echeverria, Alessandro Cassese and Yulina Soto 
* @since 04/24/2024
* @version 1.0
*/
// Move attributes
public class Moves {
	private String name;
	private String type;
	private int damage;
	
	// Move Constructor
	public Moves(String name,String type,int damage) {
		this.name = name;
		this.type = type;
		this.damage = damage;
	}
	
	// Getters and Setters for Move attributes 
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    
    // toString method overide to print out Move attributes 
    @Override
    public String toString() {
        return "Move: " + name + ", Type: " + type + ", Damage: " + damage;
    }
}


