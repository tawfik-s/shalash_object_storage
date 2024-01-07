package org.technoverse.shalashobjectstorage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.technoverse.shalashobjectstorage.domain.ObjectData;
import org.technoverse.shalashobjectstorage.repository.ObjectDataRepository;
import org.technoverse.shalashobjectstorage.service.dto.ObjectDataResponse;
import org.technoverse.shalashobjectstorage.service.mapper.ObjectDataMapper;
import org.technoverse.shalashobjectstorage.util.ObjectUtils;

import java.io.IOException;

@Repository
public class ObjectStorageService {

    @Autowired
    private ObjectDataRepository objectDataRepository;

    @Autowired
    private ObjectDataMapper objectDataMapper;
    public ObjectDataResponse uploadImage(MultipartFile file) throws IOException {
        ObjectData objectData = objectDataRepository.save(ObjectData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .ObjectData(ObjectUtils.compressImage(file.getBytes())).build());
        return objectDataMapper.toDto(objectData);
    }


    public ObjectData downloadImagebyId(Long fileId){
        ObjectData objectData =  objectDataRepository.findById(fileId).orElseThrow();
        return objectData;
    }




}
