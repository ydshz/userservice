package com.socialnetwork.userservice.exceptions;

public class NonexistingUserException extends RuntimeException{
     public NonexistingUserException(String message) { super(message); }
}
