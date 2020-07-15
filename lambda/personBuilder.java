package lambda;

@FunctionalInterface
public interface personBuilder {
    // 根据name创建person
    person builderPerson(String name);
}
