package com.challenge.mockito.repositories;


import com.challenge.mockito.models.Examen;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExamenRepositoryOtro implements ExamenRepository{
  @Override
  public List<Examen> findAll() throws InterruptedException {
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch(InterruptedException e) {
      e.printStackTrace();
    }

    return null;
  }
}
