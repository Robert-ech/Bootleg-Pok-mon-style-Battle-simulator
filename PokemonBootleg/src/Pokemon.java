/**
* This is a bootleg version of Pokemon which can create objects (pokemon)
* and make them battle.(updated to include toString and attack selection.)
* @author Roberto Echeverria, Alessandro Cassese and Yulina Soto 
* @since 04/24/2024
* @version 1.0
*/
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

//Pokemon attributes
public class Pokemon {
	private String name;
    private String type;
    private int health;
    private int attack;
    private int defense;
    private List<Moves> moves;
    
    // Pokemon Constructor
    public Pokemon (String name, String type, int health, int attack, int defense) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.moves = new ArrayList<>();
    }
    
    // Getters
    public void addMove(Moves move) {
    	moves.add(move);
    }
    
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }


    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    
    // Attack method that lets user select an attack
    public void Attack(Pokemon target) {
        Scanner scanner = new Scanner(System.in);

        // Display moves available to the user
        System.out.println("Available moves for " + name + ":");
        for (int i = 0; i < moves.size(); i++) {
            System.out.println((i + 1) + ". " + moves.get(i).getName());
        }

        int moveIndex = -1;
        while (true) {
            try {
                // Ask the user to select a move
                System.out.print("Select a move (1-" + moves.size() + "): ");
                moveIndex = scanner.nextInt();
                if (moveIndex >= 1 && moveIndex <= moves.size()) {
                    break; // Valid input, exit the loop
                } else {
                    System.out.println("Invalid move selection!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); 
            }
        }

        Moves move = moves.get(moveIndex - 1);
        System.out.println(name + " performs " + move.getName() + "!");
        // Calculate damage based on move and target's defense
        int damage = move.getDamage() - target.getDefense();
        damage = Math.max(damage, 0); // Ensure damage is not negative
        System.out.println("Dealing " + damage + " damage to " + target.getName() + ".");
        target.takeDamage(damage);
    }

    
    
    
    
    public void CPU_attack(Pokemon target) {
        Random random = new Random();
        Moves randomMove = moves.get(random.nextInt(moves.size())); // Chooses a random move
        int randomDamageNumber = random.nextInt(40) + 1; // Generates a random number between 1 and 40
        int damage = (randomDamageNumber + attack) - target.getDefense();
        damage = Math.max(damage, 0); // Ensure damage is not negative
        System.out.println(name + " used " + randomMove.getName() + "!");
        System.out.println("Damage dealt: " + damage);
        target.takeDamage(damage);
    }
    
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + "'s health is now " + health + ".");
    }
    
    // overwriting the toString method to show pokemon stats
    @Override
    public String toString() {
        StringBuilder Stats = new StringBuilder();
        Stats.append("Name: ").append(name).append("\n");
        Stats.append("Type: ").append(type).append("\n");
        Stats.append("Health: ").append(health).append("\n");
        Stats.append("Moves: \n");
        for (int i = 0; i < moves.size(); i++) {
        	Stats.append((i + 1)).append(". ").append(moves.get(i).toString()).append("\n");
        }
        return Stats.toString();
    }
    
    
}
