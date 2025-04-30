////////////////////////////////////////////////////////////////////
// Gabriel Rovesti
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test suite per la classe IntegerToRoman.
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
public class IntegerToRomanTest {
    
    @Test
    public void testInvalidNumbers() {
        // RIGHT + ERROR: Verifica che numeri invalidi generino eccezioni
        IllegalArgumentException exception1 = assertThrows(
            IllegalArgumentException.class,
            () -> IntegerToRoman.convert(0)
        );
        assertEquals("Number must be between 1 and 1000", exception1.getMessage());
        
        IllegalArgumentException exception2 = assertThrows(
            IllegalArgumentException.class,
            () -> IntegerToRoman.convert(-1)
        );
        assertEquals("Number must be between 1 and 1000", exception2.getMessage());
        
        IllegalArgumentException exception3 = assertThrows(
            IllegalArgumentException.class,
            () -> IntegerToRoman.convert(1001)
        );
        assertEquals("Number must be between 1 and 1000", exception3.getMessage());
    }
    
    @ParameterizedTest
    @CsvSource({
        "1, I",
        "2, II",
        "3, III",
        "4, IV",
        "5, V",
        "6, VI",
        "9, IX",
        "10, X",
        "14, XIV",
        "15, XV",
        "19, XIX",
        "20, XX",
        "40, XL",
        "50, L",
        "90, XC",
        "100, C",
        "400, CD",
        "500, D",
        "900, CM",
        "1000, M"
    })
    public void testBasicConversions(int input, String expected) {
        // RIGHT: Verifica la correttezza delle conversioni
        assertEquals(expected, IntegerToRoman.convert(input));
    }
    
    @ParameterizedTest
    @CsvSource({
        "7, VII",
        "8, VIII",
        "11, XI",
        "12, XII",
        "13, XIII",
        "16, XVI",
        "17, XVII",
        "18, XVIII",
        "21, XXI",
        "30, XXX",
        "39, XXXIX",
        "42, XLII",
        "44, XLIV",
        "45, XLV",
        "49, XLIX",
        "51, LI",
        "60, LX",
        "70, LXX",
        "80, LXXX",
        "88, LXXXVIII",
        "99, XCIX",
        "200, CC",
        "300, CCC",
        "444, CDXLIV",
        "555, DLV",
        "666, DCLXVI",
        "777, DCCLXXVII",
        "888, DCCCLXXXVIII",
        "999, CMXCIX"
    })
    public void testAdvancedConversions(int input, String expected) {
        // RIGHT: Verifica la correttezza delle conversioni
        assertEquals(expected, IntegerToRoman.convert(input));
    }
    
    @Test
    public void testBoundaryValues() {
        // BOUNDARY: Verifica i casi limite
        assertEquals("I", IntegerToRoman.convert(1));
        assertEquals("M", IntegerToRoman.convert(1000));
    }
}