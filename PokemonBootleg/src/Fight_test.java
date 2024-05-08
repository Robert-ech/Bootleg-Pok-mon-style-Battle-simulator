/**
* This is a bootleg version of Pokemon which can create objects (pokemon)
* and make them battle.(updated to include toString and attack selection.)
* @author Roberto Echeverria, Alessandro Cassese and Yulina Soto 
* @since 04/24/2024
* @version 1.0
*/
public class Fight_test {
	public static void main(String[] args) {
		
		//SALAMENCE MOVES
		Moves Dragon_Tail = new Moves("Dragon Tail", "Dragon", 90);
		Moves Draco_Meteor = new Moves("Draco Meteor", "Dragon", 120);
		//SALAMENCE CREATION
		Pokemon salamence = new Pokemon("Salamence", "Dragon",140, 40, 20);
		salamence.addMove(Dragon_Tail);
		salamence.addMove(Draco_Meteor);
		
		//RAYQUAZA MOVES
		Moves Breaking_Swipe = new Moves("Breaking Swipe", "Dragon", 120);
		Moves Dragon_Ascent = new Moves("Dragon_Ascent", "Dragon", 125);
		//RAYQUAZA CREATION
		Pokemon rayquaza = new Pokemon("Rayquaza", "Dragon", 135, 42, 25);
		rayquaza.addMove(Dragon_Tail);
		rayquaza.addMove(Breaking_Swipe);
		rayquaza.addMove(Dragon_Ascent);
		
		// Display initial information about Pokemon
        System.out.println("Initial Information:");
        System.out.println(salamence.toString());
        System.out.println(rayquaza.toString());
        System.out.println();
		
		
		//BATTLE LOOP
		while (salamence.getHealth() > 0 && rayquaza.getHealth() > 0) {
            // Salamence attacks Rayquaza
            salamence.Attack(rayquaza);
            
            // Check if Rayquaza has fainted
            if (rayquaza.getHealth() <= 0) {
                System.out.println(rayquaza.getName() + " has fainted!");
                break;
            }
            
            // Rayquaza (CPU) attacks Salamence
            rayquaza.CPU_attack(salamence);
            
            // Check if Salamence has fainted
            if (salamence.getHealth() <= 0) {
                System.out.println(salamence.getName() + " has fainted!");
                break;
            }
            
            // Display remaining HP
            System.out.println("Remaining HP: " + salamence.getName() + ": " + salamence.getHealth() +
                               ", " + rayquaza.getName() + ": " + rayquaza.getHealth());
            System.out.println();
        }
        
        // Determine the winner
        if (salamence.getHealth() <= 0) {
            System.out.println(rayquaza.getName() + " wins the battle!");
        } else {
            System.out.println(salamence.getName() + " wins the battle!");
        }
        
		
	}
	
}



/*	
 *[TO ADD NEW MOVES]
 *Moves_test move_Name = new Moves_test("Cool move name", "type", int damage);      
 *[SAMPLE POKEMON CREATION]
 *Pokemon_test name = new Pokemon_test("Pikachu", "type", int health,int atk,int def);
 *pikachu.addMove(tackle);
 *pikachu.addMove(thunderbolt);
 * 
 * 
 */