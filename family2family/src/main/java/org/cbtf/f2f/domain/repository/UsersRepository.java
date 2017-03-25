package org.cbtf.f2f.domain.repository;

import org.cbtf.f2f.domain.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Users", path = "Users")
public interface UsersRepository extends CrudRepository<Users, String> {


}
