package com.challenge.mockito.services;

import com.challenge.mockito.models.Examen;
import com.challenge.mockito.repositories.ExamenRepository;
import com.challenge.mockito.repositories.ExamenRepositoryOtro;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExamenServiceImplTest {

  @Test
  void findExamenPorNombre() throws InterruptedException {
    ExamenRepository repository = mock(ExamenRepositoryOtro.class);
    ExamenService service = new ExamenServiceImpl(repository);

    List<Examen> datos = Arrays.asList(new Examen(5L, "Matemáticas"), new Examen(6L, "Idiomas"),
        new Examen(7L, "Historia"));

    when(repository.findAll()).thenReturn(datos);

    Examen examen = service.findExamenPorNombre("Matemáticas");

    assertNotNull(examen);
    assertEquals(5L, examen.getId());
    assertEquals("Matemáticas", examen.getNombre());

  }
}