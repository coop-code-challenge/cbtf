package org.cbtf.f2f.domain.repository;

import org.cbtf.f2f.domain.entity.ChildDiagnosis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ChildDiagnosis", path = "ChildDiagnosis")
public interface ChildDiagnosisRepository extends CrudRepository<ChildDiagnosis, ChildDiagnosis.PK> {


}
