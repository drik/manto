package mu.acn.cacf.mantis.service.mapper;

import mu.acn.cacf.mantis.domain.*;
import mu.acn.cacf.mantis.service.dto.MantisImportLineDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity MantisImportLine and its DTO MantisImportLineDTO.
 */
@Mapper(componentModel = "spring", uses = {StateMapper.class, MantisImportMapper.class, MantisMapper.class})
public interface MantisImportLineMapper extends EntityMapper<MantisImportLineDTO, MantisImportLine> {

    @Mapping(source = "state.id", target = "stateId")
    @Mapping(source = "mantisImport.id", target = "mantisImportId")
    @Mapping(source = "mantis.id", target = "mantisId")
    MantisImportLineDTO toDto(MantisImportLine mantisImportLine);

    @Mapping(source = "stateId", target = "state")
    @Mapping(source = "mantisImportId", target = "mantisImport")
    @Mapping(source = "mantisId", target = "mantis")
    MantisImportLine toEntity(MantisImportLineDTO mantisImportLineDTO);

    default MantisImportLine fromId(Long id) {
        if (id == null) {
            return null;
        }
        MantisImportLine mantisImportLine = new MantisImportLine();
        mantisImportLine.setId(id);
        return mantisImportLine;
    }
}
