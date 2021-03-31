package Main.Repositories;

import Main.Models.BusinessArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessAreaRepo extends JpaRepository<BusinessArea, Long> {
}
