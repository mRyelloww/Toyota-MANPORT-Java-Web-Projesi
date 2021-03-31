package Main.Repositories;

import Main.Models.DatabaseName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseNameRepo extends JpaRepository<DatabaseName, Long> {
}
