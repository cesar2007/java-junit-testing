package com.challenge.mockito.services;

import com.challenge.mockito.models.Examen;

public interface ExamenService {
  Examen findExamenPorNombre(String nombre) throws InterruptedException;
}
