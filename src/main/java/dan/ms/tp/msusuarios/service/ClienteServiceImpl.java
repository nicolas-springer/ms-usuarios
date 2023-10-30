package dan.ms.tp.msusuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dan.ms.tp.msusuarios.dao.ClienteJpaRepository;
import dan.ms.tp.msusuarios.exception.ClienteNoEncontradoException;
import dan.ms.tp.msusuarios.modelo.Cliente;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteJpaRepository clienteJpaRepository;
    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;
    @Override
    public List<Cliente> getAllClientes() {
        // TODO Auto-generated method stub
        return clienteJpaRepository.findAll();
        
    }

    @Override
    public Cliente getClienteById(Integer id) throws ClienteNoEncontradoException{
        return clienteJpaRepository.findById(id)
            .orElseThrow(() -> new ClienteNoEncontradoException(id));
    }

    @Override
    public Cliente getClienteByCuit(String cuit) throws ClienteNoEncontradoException {
        return clienteJpaRepository.findByCuit(cuit)
            .orElseThrow(() -> new ClienteNoEncontradoException(cuit));
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteJpaRepository.save(cliente);
    }

    @Override
    public Cliente updateClienteById(Integer id, Cliente clienteNuevo) throws ClienteNoEncontradoException {
        Cliente clienteActualizar = getClienteById(id);
        
        clienteActualizar.setCorreoElectronico(clienteNuevo.getCorreoElectronico());
        clienteActualizar.setHabilitadoOnline(clienteNuevo.getHabilitadoOnline());
        clienteActualizar.setRazonSocial(clienteNuevo.getRazonSocial());
        clienteActualizar.setMaximoCuentaCorriente(clienteNuevo.getMaximoCuentaCorriente());

        return clienteActualizar;
    }

    @Override
    public void deleteClienteById(Integer id) {
        if (clienteJpaRepository.existsById(id)) {
            clienteJpaRepository.deleteById(id);
        }
    }

    @Override
    public Cliente updateClienteByCuit(String cuit, Cliente clienteNuevo) throws ClienteNoEncontradoException {
        Cliente clienteActualizar = getClienteByCuit(cuit);
        
        clienteActualizar.setCorreoElectronico(clienteNuevo.getCorreoElectronico());
        clienteActualizar.setHabilitadoOnline(clienteNuevo.getHabilitadoOnline());
        clienteActualizar.setRazonSocial(clienteNuevo.getRazonSocial());
        clienteActualizar.setMaximoCuentaCorriente(clienteNuevo.getMaximoCuentaCorriente());

        return clienteActualizar;
    }

    @Override
    public void deleteClienteByCuit(String cuit) throws ClienteNoEncontradoException {
        Cliente existingCliente = getClienteByCuit(cuit);
        if (existingCliente != null) {
            clienteJpaRepository.delete(existingCliente);
        }
    }
    @Override
    public boolean hasGerente(Integer id) {
        return usuarioServiceImpl.existeUsuarioGerenteParaCliente(id);
    }
}
