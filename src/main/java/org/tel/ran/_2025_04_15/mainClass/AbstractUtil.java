package org.tel.ran._2025_04_15.mainClass;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public abstract class AbstractUtil {

    //TODO метод должен возвращать список, отфильтрованный по условию
    public abstract <T> List<T> filter(List<T> list, Predicate<? super T> predicate);

    //TODO метод должен возвращать элемент, удовлетворяющий условию сравнения
    public abstract <T> boolean compare(T a, T b, Comparator<? super T> comparator);

    //TODO метод должен записывать объект в файл байтовым потоком
    public abstract <D extends Serializable> void serialize(D data);

    //TODO метод должен читать объект из файла байтовым потоком
    public abstract <D extends Serializable> D deserialize();

    //TODO метод должен вернуть предикат с логикой, обратной переданному предикату
    public abstract <T> Predicate<T> negate(Predicate<T> original);
}
