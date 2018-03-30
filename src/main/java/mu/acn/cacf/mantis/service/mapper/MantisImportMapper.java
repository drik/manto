package mu.acn.cacf.mantis.service.mapper;

import mu.acn.cacf.mantis.domain.*;
import mu.acn.cacf.mantis.service.dto.MantisImportDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity MantisImport and its DTO MantisImportDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface MantisImportMapper extends EntityMapper<MantisImportDTO, MantisImport> {

    @Mapping(source = "user.id", target = "userId")
    MantisImportDTO toDto(MantisImport mantisImport);

    @Mapping(source = "userId", target = "user")
    MantisImport toEntity(MantisImportDTO mantisImportDTO);

    default MantisImport fromId(Long id) {
        if (id == null) {
            return null;
        }
        MantisImport mantisImport = new MantisImport();
        mantisImport.setId(id);
        return mantisImport;
    }
}
