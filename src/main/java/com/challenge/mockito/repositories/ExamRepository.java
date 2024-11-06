package com.challenge.mockito.repositories;

import com.challenge.mockito.models.Exam;

import java.util.List;

public interface ExamRepository {
  List<Exam> findAll() throws InterruptedException;
}
