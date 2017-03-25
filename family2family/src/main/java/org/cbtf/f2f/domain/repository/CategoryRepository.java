package org.cbtf.f2f.domain.repository;

import org.cbtf.f2f.domain.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Category", path = "Category")
public interface CategoryRepository extends CrudRepository<Category, Integer> {


}
