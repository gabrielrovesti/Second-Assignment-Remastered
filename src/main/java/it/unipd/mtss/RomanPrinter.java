////////////////////////////////////////////////////////////////////
// Gabriel Rovesti
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class RomanPrinter {
    public static String print(int num) {
        if (num <= 0 || num > 1000) {
            throw new IllegalArgumentException("Number must be between 1 and 1000");
        }
        return printAsciiArt(IntegerToRoman.convert(num));
    }

    private static String printAsciiArt(String romanNumber) {
        if (romanNumber == null || romanNumber.isEmpty()) {
            return "";
        }

        // Definizione ASCII art per ogni carattere romano
        String[][] asciiLetters = {
            { // I
                " _____ ",
                "|_   _|",
                "  | |  ",
                "  | |  ",
                " _| |_ ",
                "|_____|"
            },
            { // V
                "__      __",
                "\\ \\    / /",
                " \\ \\  / / ",
                "  \\ \\/ /  ",
                "   \\  /   ",
                "    \\/    "
            },
            { // X
                "__   __",
                "\\ \\ / /",
                " \\ V / ",
                "  > <  ",
                " / . \\ ",
                "/_/ \\_\\"
            },
            { // L
                " _      ",
                "| |     ",
                "| |     ",
                "| |     ",
                "| |____ ",
                "|______|"
            },
            { // C
                "   _____ ",
                "  / ____|",
                " | |     ",
                " | |     ",
                " | |____ ",
                "  \\_____|"
            },
            { // D
                " _____  ",
                "|  __ \\ ",
                "| |  | |",
                "| |  | |",
                "| |__| |",
                "|_____/ "
            },
            { // M
                " __  __ ",
                "|  \\/  |",
                "| \\  / |",
                "| |\\/| |",
                "| |  | |",
                "|_|  |_|"
            }
        };

        StringBuilder result = new StringBuilder();
        
        // Altezza dell'ASCII art (6 righe)
        int height = 6;
        
        // Per ogni riga dell'ASCII art
        for (int row = 0; row < height; row++) {
            // Per ogni carattere romano
            for (char c : romanNumber.toCharArray()) {
                int index;
                switch (c) {
                    case 'I': index = 0; break;
                    case 'V': index = 1; break;
                    case 'X': index = 2; break;
                    case 'L': index = 3; break;
                    case 'C': index = 4; break;
                    case 'D': index = 5; break;
                    case 'M': index = 6; break;
                    default: continue;
                }
                
                result.append(asciiLetters[index][row]);
                result.append(" ");
            }
            result.append("\n");
        }
        
        // Rimuovi l'ultimo carattere newline
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        
        return result.toString();
    }
}