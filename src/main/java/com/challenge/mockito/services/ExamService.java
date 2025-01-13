package com.challenge.mockito.services;

import com.challenge.mockito.models.Exam;

import java.util.Optional;

public interface ExamService {
  Optional<Exam> findExamByName(String name) throws InterruptedException;
  Exam findExamByNameWithQuestions(String name);
}
