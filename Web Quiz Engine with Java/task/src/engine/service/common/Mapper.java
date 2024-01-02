package engine.service.common;

import java.util.Collection;

@SuppressWarnings("java:S119")
public interface Mapper<ENTITY, DTO> {

    ENTITY mapToEntity(DTO dto);

    DTO mapToDto(ENTITY entity);

    Collection<DTO> mapToDtos(Collection<ENTITY> entities);
}
