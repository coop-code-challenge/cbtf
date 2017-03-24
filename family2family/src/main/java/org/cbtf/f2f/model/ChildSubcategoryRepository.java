package org.cbtf.f2f.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "ChildSubcategory", path = "ChildSubcategory")
public interface ChildSubcategoryRepository extends CrudRepository<ChildSubcategory, Integer> {


}
