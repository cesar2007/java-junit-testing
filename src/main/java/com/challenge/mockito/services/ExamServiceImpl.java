package com.challenge.mockito.services;

import com.challenge.mockito.models.Exam;
import com.challenge.mockito.repositories.ExamRepository;

import java.util.Optional;

public class ExamServiceImpl implements ExamService {
  private ExamRepository examRepository;

  public ExamServiceImpl(ExamRepository examRepository) {
    this.examRepository = examRepository;
  }

  @Override
  public Exam findExamByName(String nombre) throws InterruptedException {
    Optional<Exam> examOptional = examRepository.findAll()
        .stream()
        .filter(e -> e.getName().contains(nombre))
        .findFirst();
    Exam exam = null;
    if(examOptional.isPresent()) {
      exam = examOptional.orElseThrow();
    }
    return exam;
  }
}
