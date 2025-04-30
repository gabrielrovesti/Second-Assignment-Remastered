////////////////////////////////////////////////////////////////////
// Gabriel Rovesti
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Test suite per la classe RomanPrinter.
 * Rispetta i principi A-TRIP:
 * - Automatic: test automatizzati con JUnit
 * - Thorough: test esaustivi per diversi casi
 * - Repeatable: risultati consistenti
 * - Independent: test indipendenti l'uno dall'altro
 * - Professional: codice di test chiaro e ben documentato
 *
 * Rispetta i principi RIGHT-BICEP:
 * - Right: verifica la correttezza dei risultati
 * - Boundary: verifica i casi limite (1, 1000)
 * - Inverse: n/a per questo caso
 * - Cross-check: n/a per questo caso
 * - Error: verifica la gestione degli errori per input invalidi
 * - Performance: n/a per questo caso
 */
public class RomanPrinterTest {
    
    @Test
    public void testInvalidNumbers() {
        // RIGHT + ERROR: Verifica che numeri invalidi generino eccezioni
        IllegalArgumentException exception1 = assertThrows(
            IllegalArgumentException.class,
            () -> RomanPrinter.print(0)
        );
        assertEquals("Number must be between 1 and 1000", exception1.getMessage());
        
        IllegalArgumentException exception2 = assertThrows(
            IllegalArgumentException.class,
            () -> RomanPrinter.print(-1)
        );
        assertEquals("Number must be between 1 and 1000", exception2.getMessage());
        
        IllegalArgumentException exception3 = assertThrows(
            IllegalArgumentException.class,
            () -> RomanPrinter.print(1001)
        );
        assertEquals("Number must be between 1 and 1000", exception3.getMessage());
    }
    
    @Test
    public void testPrintI() {
        // RIGHT: Verifica la correttezza della rappresentazione ASCII art
        String expected = 
            " _____ \n" +
            "|_   _|\n" +
            "  | |  \n" +
            "  | |  \n" +
            " _| |_ \n" +
            "|_____|";
        assertEquals(expected, RomanPrinter.print(1));
    }
    
    @Test
    public void testPrintV() {
        // RIGHT: Verifica la correttezza della rappresentazione ASCII art
        String expected = 
            "__      __\n" +
            "\\ \\    / /\n" +
            " \\ \\  / / \n" +
            "  \\ \\/ /  \n" +
            "   \\  /   \n" +
            "    \\/    ";
        assertEquals(expected, RomanPrinter.print(5));
    }
    
    @Test
    public void testPrintX() {
        // RIGHT: Verifica la correttezza della rappresentazione ASCII art
        String expected = 
            "__   __\n" +
            "\\ \\ / /\n" +
            " \\ V / \n" +
            "  > <  \n" +
            " / . \\ \n" +
            "/_/ \\_\\";
        assertEquals(expected, RomanPrinter.print(10));
    }
    
    @Test
    public void testPrintL() {
        // RIGHT: Verifica la correttezza della rappresentazione ASCII art
        String expected = 
            " _      \n" +
            "| |     \n" +
            "| |     \n" +
            "| |     \n" +
            "| |____ \n" +
            "|______|";
        assertEquals(expected, RomanPrinter.print(50));
    }
    
    @Test
    public void testPrintC() {
        // RIGHT: Verifica la correttezza della rappresentazione ASCII art
        String expected = 
            "   _____ \n" +
            "  / ____|\n" +
            " | |     \n" +
            " | |     \n" +
            " | |____ \n" +
            "  \\_____|";
        assertEquals(expected, RomanPrinter.print(100));
    }
    
    @Test
    public void testPrintD() {
        // RIGHT: Verifica la correttezza della rappresentazione ASCII art
        String expected = 
            " _____  \n" +
            "|  __ \\ \n" +
            "| |  | |\n" +
            "| |  | |\n" +
            "| |__| |\n" +
            "|_____/ ";
        assertEquals(expected, RomanPrinter.print(500));
    }
    
    @Test
    public void testPrintM() {
        // RIGHT: Verifica la correttezza della rappresentazione ASCII art
        String expected = 
            " __  __ \n" +
            "|  \\/  |\n" +
            "| \\  / |\n" +
            "| |\\/| |\n" +
            "| |  | |\n" +
            "|_|  |_|";
        assertEquals(expected, RomanPrinter.print(1000));
    }
    
    @Test
    public void testPrintIV() {
        // RIGHT: Verifica la correttezza della rappresentazione ASCII art
        String expected = 
            " _____  __      __\n" +
            "|_   _| \\ \\    / /\n" +
            "  | |   \\ \\  / / \n" +
            "  | |    \\ \\/ /  \n" +
            " _| |_    \\  /   \n" +
            "|_____|    \\/    ";
        assertEquals(expected, RomanPrinter.print(4));
    }
    
    @Test
    public void testPrintIX() {
        // RIGHT: Verifica la correttezza della rappresentazione ASCII art
        String expected = 
            " _____  __   __\n" +
            "|_   _| \\ \\ / /\n" +
            "  | |   \\ V / \n" +
            "  | |    > <  \n" +
            " _| |_  / . \\ \n" +
            "|_____| /_/ \\_\\";
        assertEquals(expected, RomanPrinter.print(9));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 50, 100, 500, 1000})
    public void testBasicPrints(int number) {
        // RIGHT: Verifica che la stampa produca un risultato non vuoto
        String result = RomanPrinter.print(number);
        assertNotEquals("", result);
    }
    
    @Test
    public void testBoundaryValues() {
        // BOUNDARY: Verifica i casi limite
        assertNotEquals("", RomanPrinter.print(1));
        assertNotEquals("", RomanPrinter.print(1000));
    }
    
    @Test
    public void testPrintPrivateMethod() throws Exception {
        // TEST METODO PRIVATO: Verifica il funzionamento del metodo privato printAsciiArt
        Method printAsciiArt = RomanPrinter.class.getDeclaredMethod("printAsciiArt", String.class);
        printAsciiArt.setAccessible(true);
        
        assertEquals("", printAsciiArt.invoke(null, ""));
        assertEquals("", printAsciiArt.invoke(null, (String) null));
        
        String expectedI = 
            " _____ \n" +
            "|_   _|\n" +
            "  | |  \n" +
            "  | |  \n" +
            " _| |_ \n" +
            "|_____|";
        assertEquals(expectedI, printAsciiArt.invoke(null, "I"));
    }
}