package com.meli.obterdiploma.service;

import com.meli.obterdiploma.factory.StudentFactory;
import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.repository.IStudentRepository;
import com.meli.obterdiploma.repository.StudentDAO;
import com.meli.obterdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class StudentTest {

    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;


    @Test
    void primaryTest() {
        StudentDTO studentDTO = StudentFactory.createStudentWithSubjects();
        Mockito.when(studentDAO.findById(Mockito.any())).thenReturn(studentDTO);

        StudentDTO result = this.studentService.read(any());

        System.out.println(result.getMessage());

        Assertions.assertEquals(studentDTO.getId(), result.getId());
        Assertions.assertEquals(studentDTO.getStudentName(), result.getStudentName());
        Assertions.assertEquals(studentDTO.getMessage(), result.getMessage());
    }

    @Test
    void secondTest() {
        StudentDTO studentDTO = StudentFactory.createStudentWithSubjects();

        StudentDTO studentUpdated = StudentFactory.createStudentWithSubjects("Anna");
        Mockito.when(studentDAO.findById(Mockito.any())).thenReturn(studentUpdated);

        this.studentService.update(studentUpdated);
    }

}
