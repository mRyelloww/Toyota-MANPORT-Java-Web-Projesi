package Main.Repositories;

import Main.Models.Impact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpactRepo extends JpaRepository<Impact, Long> {
}
