package com.michasc.petclinic.repositories;

import com.michasc.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {

}
