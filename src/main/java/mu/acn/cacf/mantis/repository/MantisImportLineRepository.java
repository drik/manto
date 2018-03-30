package mu.acn.cacf.mantis.repository;

import mu.acn.cacf.mantis.domain.MantisImportLine;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the MantisImportLine entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MantisImportLineRepository extends JpaRepository<MantisImportLine, Long>, JpaSpecificationExecutor<MantisImportLine> {

}
