package model;

/**
 * Created by grazi on 15/06/17.
 */
public class InvalidMoveException extends Exception {
    public InvalidMoveException() { super(); }
    public InvalidMoveException(String message) { super(message); }
}