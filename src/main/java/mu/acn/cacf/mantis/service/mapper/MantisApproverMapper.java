package mu.acn.cacf.mantis.service.mapper;

import mu.acn.cacf.mantis.domain.*;
import mu.acn.cacf.mantis.service.dto.MantisApproverDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity MantisApprover and its DTO MantisApproverDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MantisApproverMapper extends EntityMapper<MantisApproverDTO, MantisApprover> {



    default MantisApprover fromId(Long id) {
        if (id == null) {
            return null;
        }
        MantisApprover mantisApprover = new MantisApprover();
        mantisApprover.setId(id);
        return mantisApprover;
    }
}
