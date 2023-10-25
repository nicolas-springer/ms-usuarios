package dan.ms.tp.msusuarios.service;

import org.springframework.stereotype.Service;

import dan.ms.tp.msusuarios.modelo.Cliente;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Override
    public List<Cliente> getAllClientes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllClientes'");
    }

    @Override
    public Cliente getClienteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCliente'");
    }

    @Override
    public Cliente getClienteByCuit(String cuit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCliente'");
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCliente'");
    }

    @Override
    public Cliente updateClienteById(Integer id, Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateClienteById'");
    }

    @Override
    public void deleteClienteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteClienteById'");
    }

    @Override
    public Cliente updateClienteByCuit(String cuit, Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateClienteByCuit'");
    }

    @Override
    public void deleteClienteByCuit(String cuit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteClienteByCuit'");
    }
    
}
