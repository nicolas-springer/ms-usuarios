package dan.ms.tp.msusuarios.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dan.ms.tp.msusuarios.modelo.Usuario;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario,Integer>{

    @Query("SELECT COUNT(u) = 1 FROM Usuario u WHERE u.id_cliente = :idCliente AND u.id_tipo_usuario = 1")
    boolean existeUsuarioGerenteParaCliente(@Param("idCliente") Integer idCliente);

    Usuario getUsuarioById(Integer id);

}
