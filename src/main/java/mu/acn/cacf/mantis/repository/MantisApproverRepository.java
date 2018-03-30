package mu.acn.cacf.mantis.repository;

import mu.acn.cacf.mantis.domain.MantisApprover;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the MantisApprover entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MantisApproverRepository extends JpaRepository<MantisApprover, Long>, JpaSpecificationExecutor<MantisApprover> {

}
