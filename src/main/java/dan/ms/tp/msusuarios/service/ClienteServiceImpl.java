package dan.ms.tp.msusuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dan.ms.tp.msusuarios.dao.ClienteJpaRepository;
import dan.ms.tp.msusuarios.modelo.Cliente;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteJpaRepository clienteJpaRepository;

    @Override
    public List<Cliente> getAllClientes() {
        // TODO Auto-generated method stub
        return clienteJpaRepository.findAll();
        
    }

   @Override
    public Cliente getClienteById(Integer id) {
        Optional<Cliente> optionalCliente = clienteJpaRepository.findById(id);
        return optionalCliente.orElse(null);
    }

    @Override
    public Cliente getClienteByCuit(String cuit) {
        return clienteJpaRepository.findByCuit(cuit).orElse(null);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteJpaRepository.save(cliente);
    }

    @Override
    public Cliente updateClienteById(Integer id, Cliente cliente) {
        if (clienteJpaRepository.existsById(id)) {
            cliente.setId(id);
            return clienteJpaRepository.save(cliente);
        }
        return null;
    }

    @Override
    public void deleteClienteById(Integer id) {
        if (clienteJpaRepository.existsById(id)) {
            clienteJpaRepository.deleteById(id);
        }
    }

    @Override
    public Cliente updateClienteByCuit(String cuit, Cliente cliente) {
        Cliente existingCliente = getClienteByCuit(cuit);
        if (existingCliente != null) {
            cliente.setId(existingCliente.getId());
            return clienteJpaRepository.save(cliente);
        }
        return null;
    }

    @Override
    public void deleteClienteByCuit(String cuit) {
        Cliente existingCliente = getClienteByCuit(cuit);
        if (existingCliente != null) {
            clienteJpaRepository.delete(existingCliente);
        }
    }
}