////////////////////////////////////////////////////////////////////
// Gabriel Rovesti
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class App 
{
    public static void main(String[] args)
    {
        if (args.length == 0) {
            System.out.println("Usage: java -jar roman-number-1.0-SNAPSHOT.jar <number>");
            return;
        }
        
        try {
            int number = Integer.parseInt(args[0]);
            System.out.println("Roman numeral for " + number + ":");
            System.out.println(RomanPrinter.print(number));
        } catch (NumberFormatException e) {
            System.err.println("Error: Input must be a valid integer");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}