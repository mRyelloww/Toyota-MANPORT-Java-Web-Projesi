package Main.Repositories;

import Main.Models.Frontend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrontendRepo extends JpaRepository<Frontend, Long> {
}
