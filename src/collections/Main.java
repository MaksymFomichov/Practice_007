package collections;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Иван1", 1));
        students.add(new Student("Иван2", 2));
        students.add(new Student("Иван3", 1));
        students.add(new Student("Иван4", 2));
        students.add(new Student("Иван5", 3));
        students.add(new Student("Иван6", 2));
        students.add(new Student("Иван7", 5));
        students.add(new Student("Иван8", 1));
        students.add(new Student("Иван9", 3));
        students.add(new Student("Иван10", 2));
        students.add(new Student("Иван11", 3));
        students.add(new Student("Иван12", 2));
        students.add(new Student("Иван12", 3));
        students.add(new Student("Иван14", 3));
        students.add(new Student("Иван15", 3));
        students.add(new Student("Иван16", 3));
        students.add(new Student("Иван17", 3));
        students.add(new Student("Иван18", 2));
        students.add(new Student("Иван19", 3));
        students.add(new Student("Иван20", 2));

//        printStudents(students, 2);

        HashSet<String> boy1 = new HashSet<>();
        HashSet<String> boy2 = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            boy1.add("boy" + i);
            boy2.add("boy" + (i+1));
        }

//        printCollection(boy1);
//        printCollection(boy2);

//        System.out.println();


        HashSet<String> union = union(boy1, boy2);
        HashSet<String> intersect = intersect(boy1, boy2);

//        printCollection(union);
//        System.out.println();
//        printCollection(intersect);

        PerfomanceChecker perfomanceChecker = new PerfomanceChecker();
        int count = 100000;
        int[] array =  new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = i; //perfomanceChecker.getRandom(count);
        }

        perfomanceChecker.checkAdding(count);
        perfomanceChecker.checkReading(count, array);
        perfomanceChecker.checkRemoving(count, array);
    }

    private static HashSet<String> union(Set<String> boyl, Set<String> boy2) {
        HashSet<String> union = (HashSet<String>) boyl;
        Iterator<String> iterator = boy2.iterator();
        while (iterator.hasNext()) {
            union.add(iterator.next());
        }
        return union;
    }

    private static HashSet<String> intersect(Set<String> boy1, Set<String> boy2) {
        HashSet<String> intersect = new HashSet<>();
        Iterator<String> itBoy1 = boy1.iterator();
        Iterator<String> itBoy2 = boy2.iterator();
        while (itBoy1.hasNext()){
            String sb1 = itBoy1.next();
            while (itBoy2.hasNext()){
                String sb2 = itBoy2.next();
                if (sb1.equals(sb2)){
                    intersect.add(sb2);
                }
            }
            itBoy2 = boy2.iterator();
        }
        return intersect;
    }

    private static void printStudents(ArrayList<Student> students, int i) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            Student s = iterator.next();
            if (s.getCourse() == i) {
                System.out.println(s.getName());
            }
        }
    }

    private static void printCollection(Collection collection) {
        for(Object element : collection)
            System.out.print("" + element + " ");
        System.out.println();
    }

}
