package dan.ms.tp.msusuarios.service;

import java.util.List;

import dan.ms.tp.msusuarios.modelo.Usuario;

public interface UsuarioService {

    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Integer id);
    List<Usuario> getUsuariosByCliente(Integer idCliente);
    List<Usuario> getUsuariosByTipoUsuario(String tipoUsuario);
    Usuario createUsuario(Usuario usuario);
    Usuario updateUsuarioById(Integer id, Usuario usuario);
    void deleteUsuarioById(Integer id);
    boolean existeUsuarioGerenteParaCliente(Integer idCliente);

}
