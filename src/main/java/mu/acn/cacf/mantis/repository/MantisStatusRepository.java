package mu.acn.cacf.mantis.repository;

import mu.acn.cacf.mantis.domain.MantisStatus;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import java.util.List;

/**
 * Spring Data JPA repository for the MantisStatus entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MantisStatusRepository extends JpaRepository<MantisStatus, Long>, JpaSpecificationExecutor<MantisStatus> {

    @Query("select mantis_status from MantisStatus mantis_status where mantis_status.user.login = ?#{principal.username}")
    List<MantisStatus> findByUserIsCurrentUser();

}
