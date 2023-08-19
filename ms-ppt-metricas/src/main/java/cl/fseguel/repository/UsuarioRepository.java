package cl.fseguel.repository;

import cl.fseguel.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fseguel
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
