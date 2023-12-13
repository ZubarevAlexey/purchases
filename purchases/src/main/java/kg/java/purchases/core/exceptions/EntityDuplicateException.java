package kg.java.purchases.core.exceptions;

public class EntityDuplicateException extends Exception{
    public EntityDuplicateException() {
        super("entity exist");
    }
}
