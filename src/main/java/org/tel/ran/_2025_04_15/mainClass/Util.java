package org.tel.ran._2025_04_15.mainClass;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.tel.ran._2025_04_15.mainClass.Task.LOGGER;

public class Util extends AbstractUtil {

    @Override
    public <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        return list.stream().filter(predicate).toList();
    }

    @Override
    public <T> boolean compare(T a, T b, Comparator<? super T> comparator) {
        return comparator.compare(a, b) >= 0;
    }

    @Override
    public <D extends Serializable> void serialize(D data) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("files/object"))) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(),this.getClass());
        }
    }

    @Override
    public <D extends Serializable> D deserialize() {
//        Class<?>[] arguments = this.getClass().getMethod("deserialize").getParameterTypes();
//        Class<D> dClass = (Class<D>) arguments[0];
        try (FileInputStream fileInputStream = new FileInputStream(new File("files/object"))) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (D) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error(e.getMessage(),this.getClass());
        }
        return null;
    }

    @Override
    public <T> Predicate<T> negate(Predicate<T> original) {
        return original.negate();
    }
}
