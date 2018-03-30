package mu.acn.cacf.mantis.service.mapper;

import mu.acn.cacf.mantis.domain.*;
import mu.acn.cacf.mantis.service.dto.MantisDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Mantis and its DTO MantisDTO.
 */
@Mapper(componentModel = "spring", uses = {ProjectMapper.class})
public interface MantisMapper extends EntityMapper<MantisDTO, Mantis> {

    @Mapping(source = "project.id", target = "projectId")
    MantisDTO toDto(Mantis mantis);

    @Mapping(source = "projectId", target = "project")
    Mantis toEntity(MantisDTO mantisDTO);

    default Mantis fromId(Long id) {
        if (id == null) {
            return null;
        }
        Mantis mantis = new Mantis();
        mantis.setId(id);
        return mantis;
    }
}
