package strategy_tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import strategy.Animal;
import strategy.Bird;
import strategy.Dog;
import strategy.interfaces.ItFlys;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseTests {

  private Animal kirk;
  private Animal blaze;
  private Bird bird;
  private Dog dog;
  private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Before
  public void setUp() {
    kirk = new Dog();
    blaze = new Bird();
    bird = new Bird();
    dog = new Dog();
    System.setOut(new PrintStream(outContent));
  }

  @Test
  public void positiveSetHeightTest() {
    kirk.setHeight(5);
    assertThat(kirk.getHeight()).isEqualTo(5);
  }

  @Test
  public void negativeValueSetToHeightTest() {
    kirk.setHeight(-1);
    assertThat(kirk.getHeight()).isEqualTo(1);
  }

  @Test
  public void nullValueSetToHeightTest() {
    kirk.setHeight(0);
    assertThat(kirk.getHeight()).isEqualTo(1);
  }

  @Test
  public void positiveSetWeightTest() {
    kirk.setWeight(5);
    assertThat(kirk.getWeight()).isEqualTo(5);
  }

  @Test
  public void negativeValueSetToWeightTest() {
    kirk.setWeight(-1);
    assertThat(kirk.getWeight()).isEqualTo(1);
  }

  @Test
  public void nullValueSetToWeightTest() {
    kirk.setWeight(0);
    assertThat(kirk.getWeight()).isEqualTo(1);
  }

  @Test
  public void validateDogsBehaviour() {
    kirk.setName("Kirk");
    assertThat(kirk.tryToFly()).isEqualTo("Can't fly");
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

  @Test
  public void birdSystemOutTest() {
    bird.beRude();
    assertThat("You are fat, boy!").isEqualTo(outContent.toString());
  }

  @Test
  public void dogSystemOutTest() {
    dog.digHole();
    assertThat("Dug a hole").isEqualTo(outContent.toString());
  }

  @After
  public void cleanUp() {
    System.setOut(null);
  }
}
