package com.challenge.mockito.repositories;


import com.challenge.mockito.models.Exam;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExamRepositoryOther implements ExamRepository {
  @Override
  public List<Exam> findAll() throws InterruptedException {
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch(InterruptedException e) {
      e.printStackTrace();
    }

    return null;
  }
}
