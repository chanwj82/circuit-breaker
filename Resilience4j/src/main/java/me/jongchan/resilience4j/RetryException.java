package me.jongchan.resilience4j;

public class RetryException extends Exception {

  public RetryException(String message) {
    super(message);
  }
}
