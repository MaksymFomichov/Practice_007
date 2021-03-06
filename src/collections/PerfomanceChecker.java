package collections;

import java.util.*;

public class PerfomanceChecker {

    // Скорости вставки в коллекции - checkAdding(int count)
    // Функция создает пустую коллекцию, запускает таймер и начинает заполнять пустую коллекцию элементами по одному. Кол-во элементов = count
    public void checkAdding(int count) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.println("Добавление в коллекцию, count = " + count);
        System.out.println("ArrayList = " + getTimeAdd(arrayList, count));
        System.out.println("LinkedList = " + getTimeAdd(linkedList, count));
        System.out.println("TreeSet = " + getTimeAdd(treeSet, count));
        System.out.println("HashSet = " + getTimeAdd(hashSet, count));
    }

    private long getTimeAdd(Collection collection, int count) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            collection.add(i);
        }
        long timeSpent = System.currentTimeMillis();
        return timeSpent - startTime;
    }

    // Скорости считывания с коллекции - checkReading(int count)
    // Функция должна создать коллекцию, заполнить ее на count элементов. Запустить таймер и начать count раз брать рандомный индекс элемента в коллекции и считывать его по индексу.
    public void checkReading(int count, int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            arrayList.add(i);
            linkedList.add(i);
            treeSet.add(i);
            hashSet.add(i);
        }
        System.out.println("\nРандомное считывание, count = " + count);
        System.out.println("ArrayList = " + getTimeRandom(arrayList, count, array));
        System.out.println("LinkedList = " + getTimeRandom(linkedList, count, array));
        System.out.println("TreeSet = " + getTimeRandomHashSet(treeSet, count, array));
        System.out.println("HashSet = " + getTimeRandomHashSet(hashSet, count, array));
    }

    private long getTimeRandom(List collection, int count, int[] array) {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            collection.get(array[i]);
        }
        long timeSpent = System.currentTimeMillis();
        return timeSpent - startTime;
    }

    private long getTimeRandomHashSet(Set collection, int count, int[] array) {
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = collection.iterator();
        for (int i = 0; i < count; i++) {
            int tempRandom = array[i];
            int tempCount = 0;
            while (iterator.hasNext()) {
                if (tempCount == tempRandom) {
                    Integer s = iterator.next();
                    break;
                }
                tempCount++;
            }
        }
        long timeSpent = System.currentTimeMillis();
        return timeSpent - startTime;
    }

    // Скорости удаления из коллекции - checkRemoving(int count)
    // Функция должна создать коллекцию, заполнить ее на count элементов. Запустить таймер и начать count раз брать рандомный индекс элемента в коллекции и удалять его по индексу.
    public void checkRemoving(int count, int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            arrayList.add(i);
            linkedList.add(i);
            treeSet.add(i);
            hashSet.add(i);
        }
        System.out.println("\nРандомное удаление, count = " + count);
        System.out.println("ArrayList = " + getTimeRemove(arrayList, count, array));
        System.out.println("LinkedList = " + getTimeRemove(linkedList, count, array));
        System.out.println("TreeSet = " + getTimeRemove(treeSet, count, array));
        System.out.println("HashSet = " + getTimeRemove(hashSet, count, array));
    }

    private long getTimeRemove(Collection collection, int count, int[] array) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            collection.remove(array[i]);
        }
        long timeSpent = System.currentTimeMillis();
        return timeSpent - startTime;
    }

    public int getRandom(int count) {
        int min = 0;
        int max = count - 1;
        return min + (int) (Math.random() * max);
    }

}
