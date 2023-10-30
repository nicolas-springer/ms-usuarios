package dan.ms.tp.msusuarios.exception;

public class UsuarioPasswordFormatoIncorrecto extends Exception {
    
    public UsuarioPasswordFormatoIncorrecto(){
        super("El formato de la contraseña es incorrecto.");
    }

}
