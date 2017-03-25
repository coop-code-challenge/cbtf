package org.cbtf.f2f.domain.repository;

import org.cbtf.f2f.domain.entity.Diagnosis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Diagnosis", path = "Diagnosis")
public interface DiagnosisRepository extends CrudRepository<Diagnosis, Integer> {


}
