package org.cbtf.f2f.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "CategoryNote", path = "CategoryNote")
public interface CategoryNoteRepository extends CrudRepository<CategoryNote, Integer> {


}
