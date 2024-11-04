package org.cemiranda.junit5app.ejemplos.exceptions;

public class InsufficientFundsException extends RuntimeException{

  public InsufficientFundsException(String message) {
    super(message);
  }
}
