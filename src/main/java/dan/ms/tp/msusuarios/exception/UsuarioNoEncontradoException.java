package dan.ms.tp.msusuarios.exception;

public class UsuarioNoEncontradoException extends Exception{
    
    public UsuarioNoEncontradoException(Integer id) {
        super("No se encontró el usuario con el ID: " + id);
    }

}
