package dan.ms.tp.msusuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dan.ms.tp.msusuarios.dao.UsuarioJpaRepository;
import dan.ms.tp.msusuarios.exception.GerenteAsignadoException;
import dan.ms.tp.msusuarios.exception.UsuarioPasswordFormatoIncorrecto;
import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.modelo.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioJpaRepository usuarioJpaRepository;
    @Autowired
    ClienteServiceImpl clienteServiceImpl;

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
    public Usuario createUsuario(Usuario usuario) throws UsuarioPasswordFormatoIncorrecto {

        if(checkPassword(usuario.getPassword())){
            return usuarioJpaRepository.save(usuario);
        }
        else{
            throw new UsuarioPasswordFormatoIncorrecto();
        }

    }

    @Override
    public Usuario updateUsuarioById(Integer id, Usuario usuarioNuevo) throws GerenteAsignadoException {
        Usuario usuarioActualizar = usuarioJpaRepository.getUsuarioById(id);
        
        usuarioActualizar.setCorreoElectronico(usuarioNuevo.getCorreoElectronico());
        usuarioActualizar.setUserName(usuarioNuevo.getUserName());
        usuarioActualizar.setPassword(usuarioNuevo.getPassword());

        if (usuarioNuevo.getTipoUsuario().getTipo() == "GERENTE") {
        // Verificar si el cliente ya tiene un gerente asignado
            Cliente cliente = usuarioNuevo.getCliente();
            if (clienteServiceImpl.hasGerente(cliente.getId())) {
                throw new GerenteAsignadoException();
            }
            else{
                usuarioActualizar.setTipoUsuario(usuarioNuevo.getTipoUsuario());
                usuarioActualizar.setCliente(usuarioNuevo.getCliente());
                return usuarioJpaRepository.save(usuarioActualizar);
            }
        }
        usuarioActualizar.setTipoUsuario(usuarioNuevo.getTipoUsuario());
        usuarioActualizar.setCliente(usuarioNuevo.getCliente());
        return usuarioJpaRepository.save(usuarioActualizar);

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
