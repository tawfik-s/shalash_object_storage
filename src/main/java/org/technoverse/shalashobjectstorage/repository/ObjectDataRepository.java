package org.technoverse.shalashobjectstorage.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technoverse.shalashobjectstorage.domain.ObjectData;

@Repository
public interface ObjectDataRepository extends JpaRepository<ObjectData,Long>{

}
