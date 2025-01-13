package com.challenge.mockito.services;

import com.challenge.mockito.models.Exam;
import com.challenge.mockito.repositories.ExamRepository;
import com.challenge.mockito.repositories.QuestionsRepository;

import java.util.List;
import java.util.Optional;

public class ExamServiceImpl implements ExamService {
  private ExamRepository examRepository;

  private QuestionsRepository questionsRepository;

  public ExamServiceImpl(ExamRepository examRepository,
                         QuestionsRepository questionsRepository) {
    this.examRepository = examRepository;
    this.questionsRepository = questionsRepository;
  }

  @Override
  public Optional<Exam> findExamByName(String nombre) {
      try {
          return examRepository.findAll()
              .stream()
              .filter(e -> e.getName().contains(nombre))
              .findFirst();
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
  }

  @Override
  public Exam findExamByNameWithQuestions(String name) {
    Optional<Exam> examOptional = findExamByName(name);
    Exam exam = null;
    if(examOptional.isPresent()) {
      exam = examOptional.orElseThrow();
      List<String> questions = questionsRepository.findQuestionsByExamId(exam.getId());
      exam.setQuestions(questions);
    }
    return exam;
  }
}
