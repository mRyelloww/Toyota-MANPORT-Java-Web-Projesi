package Main.Repositories;


import Main.Models.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepo extends JpaRepository<Production, Long> {
}
