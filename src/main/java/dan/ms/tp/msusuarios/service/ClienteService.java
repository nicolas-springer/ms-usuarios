package dan.ms.tp.msusuarios.service;

import dan.ms.tp.msusuarios.modelo.Cliente;
import java.util.List;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Cliente getClienteById(Integer id);
    Cliente getClienteByCuit(String cuit);
    Cliente createCliente(Cliente cliente);
    Cliente updateClienteById(Integer id, Cliente cliente);
    void deleteClienteById(Integer id);
    Cliente updateClienteByCuit(String cuit, Cliente cliente);
    void deleteClienteByCuit(String cuit);
}
