package Main.Repositories;

import Main.Models.MiddleWare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiddleWareRepo extends JpaRepository<MiddleWare, Long> {
}
