package strategy;

import strategy.interfaces.IFlys;

public class Animal {
  private String name;
  private int height;
  private int weight;
  private String sound;

  public String getSound() {
    return sound;
  }

  public void setSound(String sound) {
    this.sound = sound;
  }

  public IFlys flyingType;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    if (height > 0) {
      this.height = height;
    } else {
      this.height = 1;
    }
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    if (weight > 0) {
      this.weight = weight;
    } else {
      this.weight = 1;
    }
  }

  public String tryToFly() {
    return flyingType.fly();
  }

  public void setFlyingAbility(IFlys newFlyType) {
    flyingType = newFlyType;
  }
}
