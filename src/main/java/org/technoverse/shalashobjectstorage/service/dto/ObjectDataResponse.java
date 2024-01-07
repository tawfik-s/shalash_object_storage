package org.technoverse.shalashobjectstorage.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectDataResponse {

    private Long id;

    private String name;

    private String type;
}
