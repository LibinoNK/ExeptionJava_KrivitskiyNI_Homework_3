package Homework_3;

public class ItIsNotLocalDateExcepton extends ClassCastException{
    public ItIsNotLocalDateExcepton() {
        super("Невозможно перевести в тип данных LocalDate!");
    }
}
