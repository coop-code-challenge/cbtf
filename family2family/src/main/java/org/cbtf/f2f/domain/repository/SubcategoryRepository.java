package org.cbtf.f2f.domain.repository;

import org.cbtf.f2f.domain.entity.Subcategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Subcategory", path = "Subcategory")
public interface SubcategoryRepository extends CrudRepository<Subcategory, Integer> {


}
