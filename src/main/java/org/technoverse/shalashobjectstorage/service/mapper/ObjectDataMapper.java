package org.technoverse.shalashobjectstorage.service.mapper;


import org.springframework.stereotype.Component;
import org.technoverse.shalashobjectstorage.domain.ObjectData;
import org.technoverse.shalashobjectstorage.service.dto.ObjectDataResponse;

@Component
public class ObjectDataMapper {

    public ObjectDataResponse toDto(ObjectData objectData){
        return ObjectDataResponse.builder()
                .id(objectData.getId())
                .name(objectData.getName())
                .type(objectData.getType())
                .build();
    }
}
