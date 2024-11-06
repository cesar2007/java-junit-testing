package com.challenge.mockito.services;

import com.challenge.mockito.models.Exam;

public interface ExamService {
  Exam findExamByName(String name) throws InterruptedException;
}
