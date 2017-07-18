package java8.classes;

import java.util.function.Consumer;

public class Mailer {
  public static void print(String msg) {
    System.out.println(msg);
  }

  public Mailer from(String addr) {
    print(addr);
    return this;
  }
  public Mailer to(String addr) {
    print(addr);
    return this;
  }
  public Mailer subject(String line) {
    print(line);
    return this;
  }
  public Mailer body(String msg) {
    print(msg);
    return this;
  }
  public static void send(Consumer<Mailer> block) {
    Mailer mailer = new Mailer();
    block.accept(mailer);
    print("sending...");
  }
}
