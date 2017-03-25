package org.cbtf.f2f.domain.repository;

import org.cbtf.f2f.domain.entity.Child;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Child", path = "Child")
public interface ChildRepository extends CrudRepository<Child, Integer> {


}
