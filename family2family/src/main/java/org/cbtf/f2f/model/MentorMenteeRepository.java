package org.cbtf.f2f.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "MentorMentee", path = "MentorMentee")
public interface MentorMenteeRepository extends CrudRepository<MentorMentee, Integer> {


}
