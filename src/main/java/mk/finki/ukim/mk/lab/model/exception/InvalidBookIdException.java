package mk.finki.ukim.mk.lab.model.exception;

public class InvalidBookIdException extends Exception{
    public InvalidBookIdException() {
        super("* Invalid book Id - book does not exist! *");
    }
}