package com.michasc.petclinic.bootstrap;

import com.michasc.petclinic.model.*;
import com.michasc.petclinic.services.OwnerService;
import com.michasc.petclinic.services.PetTypeService;
import com.michasc.petclinic.services.SpecialtyService;
import com.michasc.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;



    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);


        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgey = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);


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
        vet1.getSpecialities().add(savedRadiology);


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dor");
        vet2.setLastName("Lasdt");
        vet2.getSpecialities().add(savedSurgey);

        vetService.save(vet2);

        System.out.println("Loaded Vets ...");
    }
}
