import java.util.Scanner;

public final class Player extends Character {
    String name;
    int moveChoice;

    public Player() {   
        createName();
        createCharClass();
        debug();
    }
    
    /* --------------------- LOGIC METHODS ---------------*/
    private void createName() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\nWhat would you like to call your avatar?");
        name = scan.nextLine();
    }
    
    public void createCharClass() {
        int chosen;
        Scanner scan = new Scanner(System.in);
        
        while(true) {
            System.out.println("\nWhat class would you like to play? Please select a number...");
            System.out.println("1. Archer \t2. Mage \t3. Warrior");
            chosen = Integer.parseInt(scan.nextLine());

            switch(chosen) {
                    case 1:
                        className = "Archer";
                        charClass = new Archer();
                        return;
                    case 2:
                        className = "Mage";
                        charClass = new Mage();
                        return;
                    case 3:
                        className = "Warrior";
                        charClass = new Warrior();
                        return;
                    default:
                        System.out.println("Please select one of the following numbers...");
            }
        }
    }
    
    @Override
    public void movement() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\nYour position is: " +getXPosition()+ ", " +getYPosition());
        System.out.println("Where would you like to move? Select number... \n1. North \t2. East \t3. South \t4. West \t5. Stop");
        moveChoice = Integer.parseInt(scan.nextLine());
            
        switch(moveChoice) {
            case 1:
                movePosition(0, 1);
                break;
            case 2:
                movePosition(1, 0);
                break;
            case 3:
                movePosition(0, -1);
                break;
            case 4:
                movePosition(-1, 0);
                break;
            case 5: 
                return;
            default:
                System.out.println("Please select one of the following numbers... ");
        }
    }
    
    @Override
    public void wallCollision() {
        System.out.println("Sorry, there is a wall blocking your way...");
        
        switch(moveChoice) {
            case 1:
                movePosition(0, -1);
                break;
            case 2: 
                movePosition(-1, 0);
                break;
            case 3:
                movePosition(0, 1);
                break;
            case 4:
                movePosition(1, 0);
                break;
            default:
                System.out.println("An error has occurred...");
        }
    }
    
    /* --------------------- SETTER METHODS ---------------*/
    public void setName(String name) {
        this.name = name;
    }
  
    /* --------------------- GETTER METHODS ---------------*/
    public String getName() {
        return name;
    }

    public int getMoveChoice() {
        return moveChoice;
    }
    
    /* --------------------- TESTING METHODS ---------------*/
    private void debug() {
        System.out.println("\nName: " +getName());
        System.out.println("Class: " +getClassName());
        System.out.println("Health: " +charClass.getHealth());
        System.out.println("Damage: " +charClass.getDamage());
    }
}
