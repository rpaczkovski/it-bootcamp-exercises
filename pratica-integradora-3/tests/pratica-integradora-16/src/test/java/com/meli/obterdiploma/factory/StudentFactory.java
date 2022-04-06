package com.meli.obterdiploma.factory;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;

import java.util.Arrays;
import java.util.List;

public class StudentFactory {

    public static StudentDTO createStudentWithSubjects() {
        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Portugues", 9.0),
                new SubjectDTO("Ingles", 8.0)
        );

        return new StudentDTO(1L, "Rodrigo", null, null, subjects);
    }

    public static StudentDTO createStudentWithSubjects(List<SubjectDTO> subjects) {
        return new StudentDTO(1L, "Rodrigo", null, null, subjects);
    }

    public static StudentDTO createStudentWithSubjects(String studentName) {
        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Portugues", 9.0),
                new SubjectDTO("Ingles", 8.0)
        );

        return new StudentDTO(1L, studentName, null, null, subjects);
    }

}
