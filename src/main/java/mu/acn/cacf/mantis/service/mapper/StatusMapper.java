package mu.acn.cacf.mantis.service.mapper;

import mu.acn.cacf.mantis.domain.*;
import mu.acn.cacf.mantis.service.dto.StatusDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Status and its DTO StatusDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StatusMapper extends EntityMapper<StatusDTO, Status> {



    default Status fromId(Long id) {
        if (id == null) {
            return null;
        }
        Status status = new Status();
        status.setId(id);
        return status;
    }
}