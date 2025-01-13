package com.challenge.mockito.services;

import com.challenge.mockito.models.Exam;

import java.util.Arrays;
import java.util.List;

public class ExamData {
    public final static List<Exam> EXAMS = Arrays.asList(new Exam(5L, "Math"), new Exam(6L, "Languages"),
            new Exam(7L, "History"));

    public final static List<String> QUESTIONS = Arrays.asList("arithmetic",
            "calculus", "trigonometry", "geometry");
}
