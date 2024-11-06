package com.challenge.mockito.repositories;

import com.challenge.mockito.models.Examen;

import java.util.List;

public interface ExamenRepository {
  List<Examen> findAll() throws InterruptedException;
}
