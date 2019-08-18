package com.michasc.petclinic.bootstrap;

import com.michasc.petclinic.model.Owner;
import com.michasc.petclinic.model.PetType;
import com.michasc.petclinic.model.Vet;
import com.michasc.petclinic.services.OwnerService;
import com.michasc.petclinic.services.PetTypeService;
import com.michasc.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setFirstName("Piterson");
        owner2.setLastName("Glamor");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ...");
        Vet vet1 = new Vet();
        vet1.setFirstName("Maks");
        vet1.setLastName("Boski");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dor");
        vet2.setLastName("Lasdt");

        vetService.save(vet2);

        System.out.println("Loaded Vets ...");

    }
}
