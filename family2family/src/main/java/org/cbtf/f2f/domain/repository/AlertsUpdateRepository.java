package org.cbtf.f2f.domain.repository;

import org.cbtf.f2f.domain.entity.AlertsUpdate;
import org.cbtf.f2f.domain.entity.CategoryNote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "AlertsUpdate", path = "AlertsUpdate")
public interface AlertsUpdateRepository extends CrudRepository<AlertsUpdate, Integer> {


}
