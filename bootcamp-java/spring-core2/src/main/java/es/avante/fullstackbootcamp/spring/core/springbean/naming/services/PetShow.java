package es.avante.fullstackbootcamp.spring.core.springbean.naming.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.avante.fullstackbootcamp.spring.core.springbean.naming.component.Animal;

public class PetShow {
	@Autowired
    @Qualifier("dog")
    private Animal dog;

    @Autowired
    @Qualifier("cat")
    private Animal cat;

    public Animal getDog() {
        return dog;
    }

    public Animal getCat() {
        return cat;
    }
}
