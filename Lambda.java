package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

enum Subject {
    ENGLISH,
    MATHS,
    TAMIL,
    SCIENCE,
    HISTORY
}

class Student {
    private String name;
    private Integer age;
    private Map<Subject, Integer> marks;

    Student(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.marks = new HashMap<>();
    }

    public void addMark(Subject name, Integer value) {
        marks.put(name, value);
    }

    public void writeStudent(Consumer<Student> studentConsumer) {
        studentConsumer.accept(this);
    }

}

class StudentUtils {

    private static final List<Subject> subjectList = Arrays.asList(Subject.values());
    private static final Predicate<Subject> isSubjectExist = subjectList::contains;
    private static final Predicate<Integer> isMarkValid =  mark -> mark >= 0 && mark <= 100;

    public static void addMark(Student student, Subject test, Integer mark) {
        if(isSubjectExist.test(test) && isMarkValid.test(mark)) {
            student.addMark(test, mark);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Lawrance", 19);
        StudentUtils.addMark(student, Subject.ENGLISH, 100);
        student.writeStudent(System.out::println);
    }
}
