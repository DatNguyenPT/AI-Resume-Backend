package com.DatNguyen.Resume_Builder_Service.Repository;

import com.DatNguyen.Resume_Builder_Service.Entity.Resume;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends MongoRepository<Resume, String> {}