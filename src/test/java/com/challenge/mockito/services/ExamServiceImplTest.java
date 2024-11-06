package com.challenge.mockito.services;

import com.challenge.mockito.models.Exam;
import com.challenge.mockito.repositories.ExamRepository;
import com.challenge.mockito.repositories.ExamRepositoryOther;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExamServiceImplTest {

  @Test
  void findExamByName() throws InterruptedException {
    ExamRepository repository = mock(ExamRepositoryOther.class);
    ExamService service = new ExamServiceImpl(repository);

    List<Exam> datos = Arrays.asList(new Exam(5L, "Math"), new Exam(6L, "Languages"),
        new Exam(7L, "History"));

    when(repository.findAll()).thenReturn(datos);

    Exam exam = service.findExamByName("Math");

    assertNotNull(exam);
    assertEquals(5L, exam.getId());
    assertEquals("Math", exam.getName());

  }
}