package com.unifacisa.tap.usuarioservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

    DocumentDTO find(@Param("id") Integer id);

    List<DocumentDTO> findByIdIn(@Param("ids") List<Integer> ids);
}
