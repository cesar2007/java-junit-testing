package com.challenge.junit5app.exceptions;

public class InsufficientFundsException extends RuntimeException{

  public InsufficientFundsException(String message) {
    super(message);
  }
}
