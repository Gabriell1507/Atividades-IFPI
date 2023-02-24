import Entidades.Banco;

import java.text.ParseException;


public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        try {
            banco.menu();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}