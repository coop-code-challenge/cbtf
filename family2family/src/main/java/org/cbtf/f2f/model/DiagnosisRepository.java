package org.cbtf.f2f.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Diagnosis", path = "Diagnosis")
public interface DiagnosisRepository extends CrudRepository<Diagnosis, Integer> {


}
