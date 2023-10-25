package dan.ms.tp.msusuarios.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dan.ms.tp.msusuarios.modelo.Cliente;

@Repository
public interface ClienteJpaRepository extends JpaRepository<Cliente,Integer> {
    
}
