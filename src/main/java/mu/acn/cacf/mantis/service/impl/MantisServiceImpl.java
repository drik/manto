package mu.acn.cacf.mantis.service.impl;

import mu.acn.cacf.mantis.service.MantisService;
import mu.acn.cacf.mantis.domain.Mantis;
import mu.acn.cacf.mantis.repository.MantisRepository;
import mu.acn.cacf.mantis.service.dto.MantisDTO;
import mu.acn.cacf.mantis.service.mapper.MantisMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Mantis.
 */
@Service
@Transactional
public class MantisServiceImpl implements MantisService {

    private final Logger log = LoggerFactory.getLogger(MantisServiceImpl.class);

    private final MantisRepository mantisRepository;

    private final MantisMapper mantisMapper;

    public MantisServiceImpl(MantisRepository mantisRepository, MantisMapper mantisMapper) {
        this.mantisRepository = mantisRepository;
        this.mantisMapper = mantisMapper;
    }

    /**
     * Save a mantis.
     *
     * @param mantisDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public MantisDTO save(MantisDTO mantisDTO) {
        log.debug("Request to save Mantis : {}", mantisDTO);
        Mantis mantis = mantisMapper.toEntity(mantisDTO);
        mantis = mantisRepository.save(mantis);
        return mantisMapper.toDto(mantis);
    }

    /**
     * Get all the mantis.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<MantisDTO> findAll() {
        log.debug("Request to get all Mantis");
        return mantisRepository.findAll().stream()
            .map(mantisMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one mantis by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public MantisDTO findOne(Long id) {
        log.debug("Request to get Mantis : {}", id);
        Mantis mantis = mantisRepository.findOne(id);
        return mantisMapper.toDto(mantis);
    }

    /**
     * Delete the mantis by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Mantis : {}", id);
        mantisRepository.delete(id);
    }
}
