package com.michasc.petclinic.services;

import com.michasc.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);
}
