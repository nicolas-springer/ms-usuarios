package dan.ms.tp.msusuarios.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dan.ms.tp.msusuarios.modelo.Cliente;
import dan.ms.tp.msusuarios.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        try {
            return ResponseEntity.ok(clienteService.getAllClientes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        if (id != null) {
            try {
                return ResponseEntity.ok(clienteService.getClienteById(id));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/cuit/{cuit}")
    public ResponseEntity<Cliente> getClienteByCuit(@PathVariable String cuit) {
        if(cuit != null){
            try {
                return ResponseEntity.ok(clienteService.getClienteByCuit(cuit));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        else return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        try {
            return ResponseEntity.ok(clienteService.createCliente(cliente));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        try {
            return ResponseEntity.ok(clienteService.updateClienteById(id, cliente));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Integer id) {
        try {
            clienteService.deleteClienteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/cuit/{cuit}")
    public ResponseEntity<Cliente> updateClienteByCuit(@PathVariable String cuit, @RequestBody Cliente cliente) {
        try {
            return ResponseEntity.ok(clienteService.updateClienteByCuit(cuit, cliente));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/cuit/{cuit}")
    public ResponseEntity<Void> deleteClienteByCuit(@PathVariable String cuit) {
        try {
            clienteService.deleteClienteByCuit(cuit);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
