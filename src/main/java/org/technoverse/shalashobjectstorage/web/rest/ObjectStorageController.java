package org.technoverse.shalashobjectstorage.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.technoverse.shalashobjectstorage.domain.ObjectData;
import org.technoverse.shalashobjectstorage.service.ObjectStorageService;
import org.technoverse.shalashobjectstorage.service.dto.ObjectDataResponse;
import org.technoverse.shalashobjectstorage.util.ObjectUtils;

import java.io.IOException;

@RestController
@RequestMapping("/object")
public class ObjectStorageController {

    @Autowired
    private ObjectStorageService objectStorageService;

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("object")MultipartFile file) throws IOException {
        ObjectDataResponse objectData = objectStorageService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(objectData);

    }


    @GetMapping("/{id}")
    public ResponseEntity<?> downloadImage(@PathVariable Long id){
        ObjectData objectData = objectStorageService.downloadImagebyId(id);
        byte[] imageBinary = ObjectUtils.decompressImage(objectData.getObjectData());
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(objectData.getType()))
                .body(imageBinary);
    }
}
