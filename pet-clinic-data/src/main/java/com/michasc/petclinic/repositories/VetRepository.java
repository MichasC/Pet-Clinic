package com.michasc.petclinic.repositories;

import com.michasc.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {

}
