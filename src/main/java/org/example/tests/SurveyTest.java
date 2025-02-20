package org.example.tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.example.*;

public class SurveyTest {
    @Test
    void testSurveyCreation() {
        Survey survey = new Survey("Minta Kérdőív", new ArrayList<>());
        assertNotNull(survey);
        assertEquals("Minta Kérdőív", survey.getTitle());
    }
}
