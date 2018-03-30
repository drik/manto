package mu.acn.cacf.mantis.service.mapper;

import mu.acn.cacf.mantis.domain.*;
import mu.acn.cacf.mantis.service.dto.ReferentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Referent and its DTO ReferentDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ReferentMapper extends EntityMapper<ReferentDTO, Referent> {



    default Referent fromId(Long id) {
        if (id == null) {
            return null;
        }
        Referent referent = new Referent();
        referent.setId(id);
        return referent;
    }
}
