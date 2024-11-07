package com.challenge.mockito.repositories;

import java.util.List;

public interface QuestionsRepository {
    List<String> findQuestionsByExamId(Long id);
}
