package com.meli.obterdiploma.service;


import com.meli.obterdiploma.factory.StudentFactory;
import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.repository.StudentDAO;
import com.meli.obterdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.CoreMatchers.*;


import java.util.Arrays;


@ExtendWith(MockitoExtension.class)
public class ObterDiplomaTest {

    @Mock
    private IStudentDAO studentDAO;
    @InjectMocks
    private ObterDiplomaService obterDiplomaService;

    @Test
    void primaryTest() {
        StudentDTO expectedResult = StudentFactory.createStudentWithSubjects();
        Mockito.when(studentDAO.findById(Mockito.any())).thenReturn(expectedResult);
        StudentDTO result = obterDiplomaService.analyzeScores(1L);

        Mockito.verify(studentDAO, Mockito.times(1)).findById(1L);

        Assertions.assertEquals(result.getId(), expectedResult.getId());
        Assertions.assertEquals(result.getStudentName(), expectedResult.getStudentName());
        Assertions.assertArrayEquals(result.getSubjects().toArray(), expectedResult.getSubjects().toArray());
    }

    @Test
    void secondTest() {
        StudentDTO expectedResult = StudentFactory.createStudentWithSubjects();

        Mockito.when(studentDAO.findById(Mockito.any())).thenReturn(expectedResult);
        StudentDTO result = obterDiplomaService.analyzeScores(Mockito.any());

        // check
        Assertions.assertEquals(result.getMessage(), "O aluno "+expectedResult.getStudentName()+" obteve uma média de 9. Você pode melhorar.");
    }

    @Test
    void thirdTest() {
        StudentDTO expectedResult = StudentFactory.createStudentWithSubjects(Arrays.asList(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Portugues", 10.0)
        ));

        Mockito.when(studentDAO.findById(Mockito.any())).thenReturn(expectedResult);
        StudentDTO result = obterDiplomaService.analyzeScores(Mockito.any());

        // check
        Assertions.assertEquals(result.getMessage(), "O aluno "+expectedResult.getStudentName()+" obteve uma média de 10. Parabéns!");
    }



}
