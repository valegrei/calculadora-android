package pe.edu.uni.valegrei.practica03;

public class Operaciones {

    public static Integer mas(Integer a, Integer b) {
        return a + b;
    }

    public static Integer menos(Integer a, Integer b) {
        return a - b;
    }

    public static Integer multiplicar(Integer a, Integer b) {
        return a * b;
    }

    public static Integer dividir(Integer a, Integer b) throws DivisionEntreCeroException {
        if (b == 0) {
            throw new DivisionEntreCeroException();
        }
        return a / b;
    }

    public static class DivisionEntreCeroException extends Exception {
        public DivisionEntreCeroException() {
            super("División entre Cero.");
        }
    }
}
