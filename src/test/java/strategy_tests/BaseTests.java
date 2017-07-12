package strategy_tests;

import strategy.Animal;
import strategy.Bird;
import strategy.Dog;
import strategy.interfaces.ItFlys;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseTests {

    private Animal kirk;
    private Animal blaze;

    @Before
    public void setUp() {
        kirk = new Dog();
        blaze = new Bird();
    }

    @Test
    public void validateDogsBehaviour() {
        kirk.setName("Kirk");
        assertThat(kirk.tryToFly()).isEqualTo("Can't flI");
        assertThat(kirk.getName()).isEqualTo("Kirk");
        assertThat(kirk.getSound()).isEqualTo("Bark");

        kirk.setFlyingAbility(new ItFlys());
        assertThat(kirk.tryToFly()).isEqualTo("Flying!");

    }

    @Test
    public void validateBirdsBehaviour() {
        blaze.setName("Blaze");
        assertThat(blaze.getName()).isEqualTo("Blaze");
        assertThat(blaze.getSound()).isEqualTo("Bloop");
        assertThat(blaze.tryToFly()).isEqualTo("Flying!");
    }
}
