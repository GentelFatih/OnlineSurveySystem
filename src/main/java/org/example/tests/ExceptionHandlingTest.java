package org.example.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.ErrorHandling;

import java.util.ArrayList;
import java.util.List;

class ExceptionHandlingTest {

    @Test
    void testNullAnswerList() {
        // Ellenőrizzük, hogy NullPointerException dobódik-e, ha a lista null
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            ErrorHandling.checkNullAnswerList(null, "A válaszok listája null!");
        });
        assertEquals("A válaszok listája null!", exception.getMessage());
    }

    @Test
    void testEmptyAnswerList() {
        // Ellenőrizzük, hogy IllegalStateException dobódik-e, ha a lista üres
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            ErrorHandling.checkEmptyAnswerList(new ArrayList<>(), "A válaszok listája üres!");
        });
        assertEquals("A válaszok listája üres!", exception.getMessage());
    }

    @Test
    void testValidIndex() {
        // Létrehozunk egy tesztlistát
        List<String> testList = List.of("Elem1", "Elem2", "Elem3");

        // Ellenőrizzük, hogy IndexOutOfBoundsException dobódik-e érvénytelen index esetén
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            ErrorHandling.checkValidIndex(testList, 5, "Érvénytelen válaszindex!");
        });
        assertEquals("Érvénytelen válaszindex!", exception.getMessage());
    }

    @Test
    void testValidIndexWithNegativeValue() {
        // Létrehozunk egy tesztlistát
        List<String> testList = List.of("Elem1", "Elem2", "Elem3");

        // Ellenőrizzük, hogy IndexOutOfBoundsException dobódik-e negatív index esetén
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            ErrorHandling.checkValidIndex(testList, -1, "Érvénytelen válaszindex!");
        });
        assertEquals("Érvénytelen válaszindex!", exception.getMessage());
    }

    @Test
    void testValidListWithCorrectIndex() {
        // Létrehozunk egy tesztlistát
        List<String> testList = List.of("Elem1", "Elem2", "Elem3");

        // Ellenőrizzük, hogy NEM dobódik kivétel, ha az index érvényes
        assertDoesNotThrow(() -> {
            ErrorHandling.checkValidIndex(testList, 1, "Ez nem dob kivételt");
        });
    }
}