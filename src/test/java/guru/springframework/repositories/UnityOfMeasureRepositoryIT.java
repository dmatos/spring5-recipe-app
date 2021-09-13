package guru.springframework.repositories;

import guru.springframework.model.UnityOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnityOfMeasureRepositoryIT {

    @Autowired
    UnityOfMeasureRepository unityOfMeasureRepository;

    @Before
    public void setUp() throws Exception{

    }

    @Test
    @DirtiesContext //reload no Spring Context
    public void findByDescription() {

        Optional<UnityOfMeasure> uomOptional = unityOfMeasureRepository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() {

        Optional<UnityOfMeasure> uomOptional = unityOfMeasureRepository.findByDescription("Cup");

        assertEquals("Cup", uomOptional.get().getDescription());
    }
}