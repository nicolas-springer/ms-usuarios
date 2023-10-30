package dan.ms.tp.msusuarios.exception;

public class ClienteNoEncontradoException extends Exception{
    
    public ClienteNoEncontradoException(String cuit) {
        super("No se encontró el cliente con el CUIT: " + cuit);
    }
    public ClienteNoEncontradoException(Integer id) {
        super("No se encontró el cliente con el ID: " + id);
    }
}
