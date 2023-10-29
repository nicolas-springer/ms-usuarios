package dan.ms.tp.msusuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dan.ms.tp.msusuarios.dao.UsuarioJpaRepository;
import dan.ms.tp.msusuarios.modelo.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioJpaRepository usuarioJpaRepository;

    @Override
    public List<Usuario> getAllUsuarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsuarios'");
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsuarioById'");
    }

    @Override
    public List<Usuario> getUsuariosByCliente(Integer idCliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsuariosByCliente'");
    }

    @Override
    public List<Usuario> getUsuariosByTipoUsuario(String tipoUsuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsuariosByTipoUsuario'");
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {

        if(checkPassword(usuario.getPassword())){
            
        }
        else{
            throw new UnsupportedOperationException("Contraseña no cumple requisitos.");
        }

        throw new UnsupportedOperationException("Unimplemented method 'createUsuario'");
    }

    @Override
    public Usuario updateUsuarioById(Integer id, Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUsuarioById'");
    }

    @Override
    public void deleteUsuarioById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUsuarioById'");
    }

    @Override
    public boolean existeUsuarioGerenteParaCliente(Integer idCliente) {
        return usuarioJpaRepository.existeUsuarioGerenteParaCliente(idCliente);
    }

    private boolean checkPassword(String password) { 
        if (password.length() < 12 || 
        !password.matches(".*[A-Z].*") || 
        !password.matches(".*[a-z].*") || 
        !password.matches(".*\\d.*") || 
        !password.matches(".*[@#$%^&+=!].*")) {
            return false;
        }
        return true;
    }
    
}
