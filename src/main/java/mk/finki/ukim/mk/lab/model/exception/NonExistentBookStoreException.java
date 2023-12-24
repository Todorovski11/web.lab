package mk.finki.ukim.mk.lab.model.exception;

public class NonExistentBookStoreException extends Exception{
    public NonExistentBookStoreException() {
        super("* Invalid bookStore Id - store does not exist! *");
    }
}