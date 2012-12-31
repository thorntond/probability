import java.io.Console;
import java.lang.Integer;
import java.lang.NumberFormatException;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * A command-line dice roller that rolls two six-sided (D6) dice.  This program
 * is designed to expedite board-game sessions by providing instant results and
 * a normal distribution of dice outcomes.
 *
 * @author Daniel F. Thornton
 */
public class DiceRoller
{
    private static String DIE_TAB = "              ";
    
    private static String DIE_1_7x7 = DIE_TAB + " _______ \n" +
                                       DIE_TAB + "|       |\n" +
                                       DIE_TAB + "|       |\n" +
                                       DIE_TAB + "|   O   |\n" +
                                       DIE_TAB + "|       |\n" +
                                       DIE_TAB + "|_______|\n";

    private static String DIE_2_7x7 = DIE_TAB + " _______ \n" +
                                       DIE_TAB + "|       |\n" +
                                       DIE_TAB + "|     O |\n" +
                                       DIE_TAB + "|       |\n" +
                                       DIE_TAB + "| O     |\n" +
                                       DIE_TAB + "|_______|\n";

    private static String DIE_3_7x7 = DIE_TAB + " _______ \n" +
                                       DIE_TAB + "|       |\n" +
                                       DIE_TAB + "|     O |\n" +
                                       DIE_TAB + "|   O   |\n" +
                                       DIE_TAB + "| O     |\n" +
                                       DIE_TAB + "|_______|\n";

    private static String DIE_4_7x7 = DIE_TAB + " _______ \n" +
                                       DIE_TAB + "|       |\n" +
                                       DIE_TAB + "| O   O |\n" +
                                       DIE_TAB + "|       |\n" +
                                       DIE_TAB + "| O   O |\n" +
                                       DIE_TAB + "|_______|\n";

    private static String DIE_5_7x7 = DIE_TAB + " _______ \n" +
                                       DIE_TAB + "|       |\n" +
                                       DIE_TAB + "| O   O |\n" +
                                       DIE_TAB + "|   O   |\n" +
                                       DIE_TAB + "| O   O |\n" +
                                       DIE_TAB + "|_______|\n";

    private static String DIE_6_7x7 = DIE_TAB + " _______ \n" +
                                       DIE_TAB + "|       |\n" +
                                       DIE_TAB + "| O   O |\n" +
                                       DIE_TAB + "| O   O |\n" +
                                       DIE_TAB + "| O   O |\n" +
                                       DIE_TAB + "|_______|\n";

    private static String DIE_1_5x5 = DIE_TAB + " _____ \n" +
                                       DIE_TAB + "|     |\n" +
                                       DIE_TAB + "|  O  |\n" +
                                       DIE_TAB + "|_____|\n";

    private static String DIE_2_5x5 = DIE_TAB + " _____ \n" +
                                       DIE_TAB + "|    O|\n" +
                                       DIE_TAB + "|     |\n" +
                                       DIE_TAB + "|O____|\n";

    private static String DIE_3_5x5 = DIE_TAB + " _____ \n" +
                                       DIE_TAB + "|    O|\n" +
                                       DIE_TAB + "|  O  |\n" +
                                       DIE_TAB + "|O____|\n";

    private static String DIE_4_5x5 = DIE_TAB + " _____ \n" +
                                       DIE_TAB + "|O   O|\n" +
                                       DIE_TAB + "|     |\n" +
                                       DIE_TAB + "|O___O|\n";

    private static String DIE_5_5x5 = DIE_TAB + " _____ \n" +
                                       DIE_TAB + "|O   O|\n" +
                                       DIE_TAB + "|  O  |\n" +
                                       DIE_TAB + "|O___O|\n";

    private static String DIE_6_5x5 = DIE_TAB + " _____ \n" +
                                       DIE_TAB + "|O   O|\n" +
                                       DIE_TAB + "|O   O|\n" +
                                       DIE_TAB + "|O___O|\n";

    /**
     * The dice-rolling command-line interface (CLI).  This CLI runs in a
     * continuous loop, designed to support board game play.  It defaults to the
     * larger, 7x7 die pictures, and accepts an optional command-line parameter.
     * 
     * @param small directs the CLI to display 5x5 die pictures.
     * @param tiny  directs the CLI to display 5x5 die pictures.
     * @param 5     directs the CLI to display 5x5 die pictures.
     * @param large directs the CLI to display 7x7 die pictures.
     * @param big   directs the CLI to display 7x7 die pictures.
     * @param 7     directs the CLI to display 7x7 die pictures.
     */
    public static void main (String[] args)
    {
        Random r = new Random(System.currentTimeMillis());
        int pxSize = 7;
        
        if (args.length > 0)
        {
            try
            {
                pxSize = Integer.valueOf(args[0]);
            }
            catch (NumberFormatException nfe)
            {
                if (args[0].equalsIgnoreCase("small")
                  || args[0].equalsIgnoreCase("tiny"))
                    pxSize = 5;
                else if (args[0].equalsIgnoreCase("large")
                  || args[0].equalsIgnoreCase("big"))
                    pxSize = 7;
            }
        }
        
        for (;;)
        {
        
        int die1 = r.nextInt(6) + 1;
        int die2 = r.nextInt(6) + 1;
        
        for (int i = 0; i < 20; i++)
            System.out.println();
        
        System.out.println(" ____________________________________ ");
        System.out.println("|           |           |            |");
        System.out.print("| D6 #1 = ");
        System.out.print(die1);
        System.out.print(" | D6 #2 = ");
        System.out.print(die2);
        System.out.print(" | TOTAL = ");
        System.out.print(new DecimalFormat("00").format(die1 + die2));
        System.out.print(" |");
        System.out.println();
        System.out.println("|___________|___________|____________|");
        System.out.println();
        System.out.print(getDiePicture(die1, pxSize));
        System.out.println();
        System.out.print(getDiePicture(die2, pxSize));
        
        for (int i = 0; i < 5; i++)
            System.out.println();
        
        Console console = System.console();
        String input = console.readLine();
        
        }
    }
    
    /**
     * Converts a die number into a 7x7 ASCII die picture.
     * 
     * @param number An integer from one (1) to six (6).
     */
    public static String getDiePicture (int number)
    {
        return getDiePicture(number, 7);
    }
    
    /**
     * Converts a die number into an ASCII die picture.
     * 
     * @param number An integer from one (1) to six (6).
     * @param pictureSize The size of the desired ASCII die picture.  Currently
     * accepts five (5) or seven (7), returning 5x5 or 7x7 pictures
     * respectively.
     */
    public static String getDiePicture (int number, int pictureSize)
    {
        if (pictureSize == 5)
        {
            if      (number == 1) return DIE_1_5x5;
            else if (number == 2) return DIE_2_5x5;
            else if (number == 3) return DIE_3_5x5;
            else if (number == 4) return DIE_4_5x5;
            else if (number == 5) return DIE_5_5x5;
            else if (number == 6) return DIE_6_5x5;
            else                  return "ERROR: roll number outside D6 range!";
        }
        else if (pictureSize == 7)
        {
            if      (number == 1) return DIE_1_7x7;
            else if (number == 2) return DIE_2_7x7;
            else if (number == 3) return DIE_3_7x7;
            else if (number == 4) return DIE_4_7x7;
            else if (number == 5) return DIE_5_7x7;
            else if (number == 6) return DIE_6_7x7;
            else                  return "ERROR: roll number outside D6 range!";
        }
        else
        {
            return "ERROR: getDiePicture() only accepts size 5 or size 7!";
        }
    }
}