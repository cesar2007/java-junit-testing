package com.challenge.mockito.models;

import java.util.ArrayList;
import java.util.List;

public class Exam {
  private Long id;
  private String name;
  private List<String> questions;

  public Exam(Long id, String name) {
    this.id = id;
    this.name = name;
    this.questions = new ArrayList<>();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}
