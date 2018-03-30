package mu.acn.cacf.mantis.repository;

import mu.acn.cacf.mantis.domain.Status;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Status entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StatusRepository extends JpaRepository<Status, Long>, JpaSpecificationExecutor<Status> {

}
