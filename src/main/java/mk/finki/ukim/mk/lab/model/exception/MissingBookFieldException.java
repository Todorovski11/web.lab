package mk.finki.ukim.mk.lab.model.exception;

public class MissingBookFieldException extends Exception{
    public MissingBookFieldException() {
        super("* All fields are required! *");
    }
}