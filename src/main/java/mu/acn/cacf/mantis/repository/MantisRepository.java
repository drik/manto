package mu.acn.cacf.mantis.repository;

import mu.acn.cacf.mantis.domain.Mantis;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Mantis entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MantisRepository extends JpaRepository<Mantis, Long>, JpaSpecificationExecutor<Mantis> {

}
