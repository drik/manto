package mu.acn.cacf.mantis.service;

import mu.acn.cacf.mantis.service.dto.MantisDTO;
import java.util.List;

/**
 * Service Interface for managing Mantis.
 */
public interface MantisService {

    /**
     * Save a mantis.
     *
     * @param mantisDTO the entity to save
     * @return the persisted entity
     */
    MantisDTO save(MantisDTO mantisDTO);

    /**
     * Get all the mantis.
     *
     * @return the list of entities
     */
    List<MantisDTO> findAll();

    /**
     * Get the "id" mantis.
     *
     * @param id the id of the entity
     * @return the entity
     */
    MantisDTO findOne(Long id);

    /**
     * Delete the "id" mantis.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
