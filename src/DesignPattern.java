import java.util.Random;

/**
 * DesignPattern enum for enemies
 */
public enum DesignPattern {
    FactoryMethod, AbstractFactory, Prototype, Builder, Singleton,
    Adaptor, Bridge, Composite, Decorator, Proxy, Flyweight, Facade,
    Iterator, Visitor, Command, Memento, Observer, Mediator, ChainOfResponsibility,
        Strategy, State, TemplateMethod, Interpreter;

    /**
     * Pick a random pattern of the DesignPattern enum.
     * @return a random DesignPattern.
     */
    public static DesignPattern getRandomPattern() {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)];
    }
}