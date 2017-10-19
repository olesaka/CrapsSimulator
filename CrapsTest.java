
/**
 * Write a description of class CrapsTest here.
 * 
 * @author Andrew Olesak
 * @version October 21, 2015
 */
public class CrapsTest
{
    public static void main(String Args[]){
        Craps Craps1 = new Craps();
        System.out.println(Craps1.getMessage());
        if(Craps1.okToRoll()){
            System.out.println("Fix Me: Should return False.");
        }     

        // Tests the Come Out Method.
        Craps1.comeOut();
        if((Craps1.getCredits() == 11) && (Craps1.okToRoll())){
            System.out.println("FIX ME: Should return False.");   
        } else if((Craps1.getCredits() == 9) && (Craps1.okToRoll())){
            System.out.println("FIX ME: Should return False.");
        } else if((Craps1.getCredits() == 10) && (!Craps1.okToRoll())){
            System.out.println("FIX ME: Should return True.");
        }

        System.out.println(Craps1.getMessage());
        // Tests the Roll Method.
        while(Craps1.okToRoll()){
            Craps1.roll();
            if((Craps1.getCredits() == 11) && (Craps1.okToRoll())){
                System.out.println("FIX ME: Should return False.");
            } else if((Craps1.getCredits() == 9) && (Craps1.okToRoll())){
                System.out.println("FIX ME: Should return False.");
            } else if((Craps1.getCredits() == 10) && (!Craps1.okToRoll())){
                System.out.println("FIX ME: Should return True.");
            }
            System.out.println(Craps1.getMessage());
            Craps1.okToRoll();
        }

        System.out.println("Number of Credits is " + Craps1.getCredits() + ".");
        // Tests the value of the Credits.
        if(Craps1.getCredits() == 10){
            System.out.println("FIX ME: Credits have to change after a round is played.");
        } else if(Craps1.getCredits() < 9){
            System.out.println("FIX ME: Credits can't be lower than nine after one round");
        } else if(Craps1.getCredits() > 11){
            System.out.println("FIX ME: Credits can't be higher than eleven after one round");
        }
    }
}
