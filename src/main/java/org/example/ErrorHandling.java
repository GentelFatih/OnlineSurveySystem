package org.example;

import java.util.ArrayList;
import java.util.List;

public class ErrorHandling {

    /**
     * Ellenőrzi, hogy a válaszlista null-e.
     *
     * @param answers A válaszlista, amit ellenőrizni kell.
     * @param message A hibaüzenet, ha a válaszlista null.
     * @throws NullPointerException Ha a válaszlista null.
     */
    public static void checkNullAnswerList(List<?> answers, String message) {
        if (answers == null) {
            throw new NullPointerException(message);
        }
    }

    /**
     * Ellenőrzi, hogy a válaszlista üres-e.
     *
     * @param answers A válaszlista, amit ellenőrizni kell.
     * @param message A hibaüzenet, ha a válaszlista üres.
     * @throws IllegalStateException Ha a válaszlista üres.
     */
    public static void checkEmptyAnswerList(List<?> answers, String message) {
        if (answers.isEmpty()) {
            throw new IllegalStateException(message);
        }
    }

    /**
     * Ellenőrzi, hogy a megadott index érvényes-e a listához.
     *
     * @param answers A válaszlista, amit ellenőrizni kell.
     * @param index   Az ellenőrizendő index.
     * @param message A hibaüzenet, ha az index érvénytelen.
     * @throws IndexOutOfBoundsException Ha az index kívül esik a lista határain.
     */
    public static void checkValidIndex(List<?> answers, int index, String message) {
        if (index < 0 || index >= answers.size()) {
            throw new IndexOutOfBoundsException(message);
        }
    }

    public static List<Integer> parsePickMoreAnswer(String input, int maxAnswerSize) {
        List<Integer> selectedIndexes = new ArrayList<>();
        try {
            String[] tokens = input.split(",");
            for (String token : tokens) {
                int index = Integer.parseInt(token.trim()) - 1; // Az input 1-alapú
                if (index < 0 || index >= maxAnswerSize) {
                    throw new IllegalArgumentException("Érvénytelen válaszindex: " + (index + 1));
                }
                selectedIndexes.add(index);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Hibás formátum. Kérem, csak számokat adjon meg!");
        }
        return selectedIndexes;
    }
}