package Main.Repositories;

import Main.Models.ResponsibleTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleTeamRepo extends JpaRepository<ResponsibleTeam, Long> {
}
