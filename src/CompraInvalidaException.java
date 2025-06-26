/*
Rafael de Godoy Vianna
R.A: 2649160
*/

public class CompraInvalidaException extends Exception {
    public CompraInvalidaException() { super("Compra inválida."); }
    public CompraInvalidaException(String msg) { super(msg); }
}