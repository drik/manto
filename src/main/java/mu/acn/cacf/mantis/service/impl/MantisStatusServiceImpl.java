package mu.acn.cacf.mantis.service.impl;

import mu.acn.cacf.mantis.service.MantisStatusService;
import mu.acn.cacf.mantis.domain.MantisStatus;
import mu.acn.cacf.mantis.repository.MantisStatusRepository;
import mu.acn.cacf.mantis.service.dto.MantisStatusDTO;
import mu.acn.cacf.mantis.service.mapper.MantisStatusMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing MantisStatus.
 */
@Service
@Transactional
public class MantisStatusServiceImpl implements MantisStatusService {

    private final Logger log = LoggerFactory.getLogger(MantisStatusServiceImpl.class);

    private final MantisStatusRepository mantisStatusRepository;

    private final MantisStatusMapper mantisStatusMapper;

    public MantisStatusServiceImpl(MantisStatusRepository mantisStatusRepository, MantisStatusMapper mantisStatusMapper) {
        this.mantisStatusRepository = mantisStatusRepository;
        this.mantisStatusMapper = mantisStatusMapper;
    }

    /**
     * Save a mantisStatus.
     *
     * @param mantisStatusDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public MantisStatusDTO save(MantisStatusDTO mantisStatusDTO) {
        log.debug("Request to save MantisStatus : {}", mantisStatusDTO);
        MantisStatus mantisStatus = mantisStatusMapper.toEntity(mantisStatusDTO);
        mantisStatus = mantisStatusRepository.save(mantisStatus);
        return mantisStatusMapper.toDto(mantisStatus);
    }

    /**
     * Get all the mantisStatuses.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<MantisStatusDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MantisStatuses");
        return mantisStatusRepository.findAll(pageable)
            .map(mantisStatusMapper::toDto);
    }

    /**
     * Get one mantisStatus by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public MantisStatusDTO findOne(Long id) {
        log.debug("Request to get MantisStatus : {}", id);
        MantisStatus mantisStatus = mantisStatusRepository.findOne(id);
        return mantisStatusMapper.toDto(mantisStatus);
    }

    /**
     * Delete the mantisStatus by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete MantisStatus : {}", id);
        mantisStatusRepository.delete(id);
    }
}
