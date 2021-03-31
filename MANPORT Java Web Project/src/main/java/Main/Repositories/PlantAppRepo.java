package Main.Repositories;

import Main.Models.PlantApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantAppRepo extends JpaRepository<PlantApp, Long> {
}
