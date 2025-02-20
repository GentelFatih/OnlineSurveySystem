package org.example;

import java.util.List;

// A konkrét kérdőív osztálya, amely a kérdések listáját tartalmazza
public class EmployeeSatisfactionSurvey extends Survey {
    public EmployeeSatisfactionSurvey(String title, List<Question<?>> questions) {
        super(title, questions);
    }

}

