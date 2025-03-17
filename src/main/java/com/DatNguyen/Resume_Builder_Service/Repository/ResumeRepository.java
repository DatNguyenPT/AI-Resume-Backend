package com.DatNguyen.Resume_Builder_Service.Repository;

import com.DatNguyen.Resume_Builder_Service.Entity.Resume;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends ReactiveMongoRepository<Resume, String> {}