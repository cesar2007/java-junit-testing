package com.challenge.mockito.services;

import com.challenge.mockito.models.Examen;
import com.challenge.mockito.repositories.ExamenRepository;

import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{
  private ExamenRepository examenRepository;

  public ExamenServiceImpl(ExamenRepository examenRepository) {
    this.examenRepository = examenRepository;
  }

  @Override
  public Examen findExamenPorNombre(String nombre) throws InterruptedException {
    Optional<Examen> examenOptional = examenRepository.findAll()
        .stream()
        .filter(e -> e.getNombre().contains(nombre))
        .findFirst();
    Examen examen = null;
    if(examenOptional.isPresent()) {
      examen = examenOptional.orElseThrow();
    }
    return examen;
  }
}
