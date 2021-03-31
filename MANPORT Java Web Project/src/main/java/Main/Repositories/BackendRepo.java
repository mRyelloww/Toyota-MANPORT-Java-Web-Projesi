package Main.Repositories;

import Main.Models.Backend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackendRepo extends JpaRepository<Backend, Long> {
}
