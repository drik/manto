package mu.acn.cacf.mantis.service.mapper;

import mu.acn.cacf.mantis.domain.*;
import mu.acn.cacf.mantis.service.dto.MantisStatusDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity MantisStatus and its DTO MantisStatusDTO.
 */
@Mapper(componentModel = "spring", uses = {MantisMapper.class, StatusMapper.class, UserMapper.class, MantisApproverMapper.class})
public interface MantisStatusMapper extends EntityMapper<MantisStatusDTO, MantisStatus> {

    @Mapping(source = "mantis.id", target = "mantisId")
    @Mapping(source = "status.id", target = "statusId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "approver.id", target = "approverId")
    MantisStatusDTO toDto(MantisStatus mantisStatus);

    @Mapping(source = "mantisId", target = "mantis")
    @Mapping(source = "statusId", target = "status")
    @Mapping(source = "userId", target = "user")
    @Mapping(source = "approverId", target = "approver")
    MantisStatus toEntity(MantisStatusDTO mantisStatusDTO);

    default MantisStatus fromId(Long id) {
        if (id == null) {
            return null;
        }
        MantisStatus mantisStatus = new MantisStatus();
        mantisStatus.setId(id);
        return mantisStatus;
    }
}
