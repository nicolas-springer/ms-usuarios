package dan.ms.tp.msusuarios.service;

import java.util.List;

import dan.ms.tp.msusuarios.exception.GerenteAsignadoException;
import dan.ms.tp.msusuarios.exception.UsuarioPasswordFormatoIncorrecto;
import dan.ms.tp.msusuarios.modelo.Usuario;

public interface UsuarioService {

    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Integer id);
    List<Usuario> getUsuariosByCliente(Integer idCliente);
    List<Usuario> getUsuariosByTipoUsuario(String tipoUsuario);
    Usuario createUsuario(Usuario usuario) throws UsuarioPasswordFormatoIncorrecto;
    Usuario updateUsuarioById(Integer id, Usuario usuario) throws GerenteAsignadoException;
    void deleteUsuarioById(Integer id);
    boolean existeUsuarioGerenteParaCliente(Integer idCliente);

}
