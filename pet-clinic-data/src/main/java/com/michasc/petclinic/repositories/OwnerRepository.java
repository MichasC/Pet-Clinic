package com.michasc.petclinic.repositories;

import com.michasc.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {


}
