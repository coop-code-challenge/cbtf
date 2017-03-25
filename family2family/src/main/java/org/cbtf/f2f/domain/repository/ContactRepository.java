package org.cbtf.f2f.domain.repository;

import org.cbtf.f2f.domain.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Contact", path = "Contact")
public interface ContactRepository extends CrudRepository<Contact, Integer> {



    Contact findFirstByPrimaryEmailIsLike(String primaryEmail);

}
