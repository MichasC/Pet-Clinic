package com.michasc.petclinic.bootstrap;

import com.michasc.petclinic.model.Owner;
import com.michasc.petclinic.model.Pet;
import com.michasc.petclinic.model.PetType;
import com.michasc.petclinic.model.Vet;
import com.michasc.petclinic.services.OwnerService;
import com.michasc.petclinic.services.PetTypeService;
import com.michasc.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123123213");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);


        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setFirstName("Piterson");
        owner2.setLastName("Glamor");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("123123213");

        Pet fionasCat = new Pet();
        fionasCat.setName("just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

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
