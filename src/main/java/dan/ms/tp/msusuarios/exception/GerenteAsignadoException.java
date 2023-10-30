package dan.ms.tp.msusuarios.exception;

public class GerenteAsignadoException extends Exception{

        public GerenteAsignadoException(){
            super("El cliente ya tiene un usuario GERENTE asignado.");
        }
}
