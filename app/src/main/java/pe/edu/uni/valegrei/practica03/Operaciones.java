package pe.edu.uni.valegrei.practica03;

public class Operaciones {

    public static final int OP_SUMA = 1;
    public static final int OP_RESTA = 2;
    public static final int OP_MULTIPLICAR = 3;
    public static final int OP_DIVIDIR = 4;

    public static Long operar(Long a, Long b, int operador) throws DivisionEntreCeroException {
        switch (operador) {
            case OP_SUMA:
                return mas(a, b);
            case OP_RESTA:
                return menos(a, b);
            case OP_MULTIPLICAR:
                return multiplicar(a, b);
            case OP_DIVIDIR:
                return dividir(a, b);
            default:
                return 0L;
        }
    }

    public static String getOperadorSimbolo(int operador) {
        switch (operador) {
            case OP_SUMA:
                return "+";
            case OP_RESTA:
                return "-";
            case OP_MULTIPLICAR:
                return "x";
            case OP_DIVIDIR:
                return "/";
            default:
                return "";
        }
    }

    private static Long mas(Long a, Long b) {
        return a + b;
    }

    private static Long menos(Long a, Long b) {
        return a - b;
    }

    private static Long multiplicar(Long a, Long b) {
        return a * b;
    }

    private static Long dividir(Long a, Long b) throws DivisionEntreCeroException {
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
