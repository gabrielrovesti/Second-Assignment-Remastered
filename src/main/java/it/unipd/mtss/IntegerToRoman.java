////////////////////////////////////////////////////////////////////
// [Giuseppe] [Tutino] [2075515]
// [Manuel] [Gusella] [2076430]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

public class IntegerToRoman {
  public static String convert(int number) {
    if (number <= 0 || number > 1000) {
      throw new IllegalArgumentException("Number must be between 1 and 1000");
    }

    StringBuilder romanNumber = new StringBuilder();

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    for (int i = 0; i < values.length; i++) {
      while (number >= values[i]) {
        romanNumber.append(symbols[i]);
        number -= values[i];
      }
    }

    return romanNumber.toString();
  }
}