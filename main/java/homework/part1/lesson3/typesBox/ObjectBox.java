package homework.part1.lesson3.typesBox;
import java.util.*;
/**
 * Main class storing and operating the collection.
 *
 * @author Nail
 * @see MathBox
 * */
public class ObjectBox<T>{

    private Collection<T> objectsCollection;

    public ObjectBox(T[] objects, Collection<T> collection) {
        objectsCollection = collection;
        objectsCollection.addAll(Arrays.asList(objects));
    }

    public void addObject(T object) {
        objectsCollection.add(object);
    }

    public void deleteObject(T object) {
        objectsCollection.remove(object);
    }

    protected Collection<T> getCollection() {
        return objectsCollection;
    }

    //Display all collection items
    public void dump() {
        for (T tList : objectsCollection) {
            System.out.print(tList + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return String.valueOf(objectsCollection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox<?> objectBox = (ObjectBox<?>) o;
        return Objects.equals(objectsCollection, objectBox.objectsCollection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectsCollection);
    }
}
