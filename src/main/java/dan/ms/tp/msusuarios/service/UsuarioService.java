package dan.ms.tp.msusuarios.service;

import java.util.List;

import dan.ms.tp.msusuarios.modelo.Usuario;

public interface UsuarioService {

    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Integer id);
    List<Usuario> getUsuariosByCliente(Integer idCliente);
    List<Usuario> getUsuariosByTipoUsuario(String tipoUsuario);
    Usuario createUsuario(Usuario usuario);
    Object updateUsuarioById(Integer id, Usuario usuario);
    void deleteUsuarioById(Integer id);
    Object updateUsuario(Integer id, Usuario usuario);
}
