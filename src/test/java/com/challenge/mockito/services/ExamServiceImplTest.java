package com.challenge.mockito.services;

import com.challenge.mockito.models.Exam;
import com.challenge.mockito.repositories.ExamRepository;
import com.challenge.mockito.repositories.ExamRepositoryOther;
import com.challenge.mockito.repositories.QuestionsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExamServiceImplTest {

  @Mock
  ExamRepository repository;
  @Mock
  QuestionsRepository questionsRepository;
  @InjectMocks
  ExamServiceImpl service;
  @BeforeEach
  void setUp() {
    //MockitoAnnotations.openMocks(this);
    // repository = mock(ExamRepositoryOther.class);
    // questionsRepository = mock(QuestionsRepository.class);
    // service = new ExamServiceImpl(repository, questionsRepository);
  }

  @Test
  void findExamByName() throws InterruptedException {

    when(repository.findAll()).thenReturn(ExamData.EXAMS);
    Optional<Exam> exam = service.findExamByName("Math");

    assertTrue(exam.isPresent());
    assertEquals(5L, exam.orElseThrow().getId());
    assertEquals( "Math", exam.orElseThrow().getName());

  }

  @Test
  void findExamByNameEmptyList() throws InterruptedException {
    List<Exam> data = Collections.emptyList();

    when(repository.findAll()).thenReturn(data);
    Optional<Exam> exam = service.findExamByName("Math");

    assertFalse(exam.isPresent());
  }

  @Test
  void testQuestionsExam() throws InterruptedException {
    when(repository.findAll()).thenReturn(ExamData.EXAMS);
    when(questionsRepository.findQuestionsByExamId(anyLong())).thenReturn(ExamData.QUESTIONS);
    Exam exam = service.findExamByNameWithQuestions("Math");
    assertEquals(4, exam.getQuestions().size());
    assertTrue(exam.getQuestions().contains("calculus"));
  }

  @Test
  void testQuestionsExamVerify() throws InterruptedException {
    when(repository.findAll()).thenReturn(ExamData.EXAMS);
    when(questionsRepository.findQuestionsByExamId(anyLong())).thenReturn(ExamData.QUESTIONS);
    Exam exam = service.findExamByNameWithQuestions("Math");
    assertEquals(4, exam.getQuestions().size());
    assertTrue(exam.getQuestions().contains("calculus"));

    verify(repository).findAll();
    verify(questionsRepository).findQuestionsByExamId(5L);
  }

  @Test
  void testNoExamExamVerify() throws InterruptedException {
    when(repository.findAll()).thenReturn(Collections.emptyList());
    when(questionsRepository.findQuestionsByExamId(anyLong())).thenReturn(ExamData.QUESTIONS);
    Exam exam = service.findExamByNameWithQuestions("Math");
    assertNull(exam);
    verify(repository).findAll();
    verify(questionsRepository).findQuestionsByExamId(5L);
  }
}