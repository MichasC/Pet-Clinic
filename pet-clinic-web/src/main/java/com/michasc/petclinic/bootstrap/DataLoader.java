package com.michasc.petclinic.bootstrap;

import com.michasc.petclinic.model.Owner;
import com.michasc.petclinic.model.Vet;
import com.michasc.petclinic.services.OwnerService;
import com.michasc.petclinic.services.VetService;
import com.michasc.petclinic.services.map.OwnerServiceMap;
import com.michasc.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;



    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 =  new Owner();
        owner1.setId(1L);
        owner1.setFirstName("michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);
        Owner owner2 =  new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Piterson");
        owner2.setLastName("Glamor");

        ownerService.save(owner2);

        System.out.println("Loades Owners ...");
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Maks");
        vet1.setLastName("Boski");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Dor");
        vet2.setLastName("Lasdt");

        vetService.save(vet2);

        System.out.println("Loades Vets ...");

    }
}
