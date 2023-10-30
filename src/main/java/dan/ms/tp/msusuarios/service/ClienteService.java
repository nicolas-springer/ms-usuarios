package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.exception.ClienteNoEncontradoException;
import dan.ms.tp.msusuarios.modelo.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Cliente getClienteById(Integer id) throws  ClienteNoEncontradoException;
    Cliente getClienteByCuit(String cuit) throws ClienteNoEncontradoException;
    Cliente createCliente(Cliente cliente);
    Cliente updateClienteById(Integer id, Cliente cliente) throws ClienteNoEncontradoException;
    void deleteClienteById(Integer id);
    Cliente updateClienteByCuit(String cuit, Cliente cliente) throws ClienteNoEncontradoException;
    void deleteClienteByCuit(String cuit) throws ClienteNoEncontradoException;
    boolean hasGerente(Integer id);
}
