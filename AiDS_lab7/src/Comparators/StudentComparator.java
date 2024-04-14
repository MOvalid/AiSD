package Comparators;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        int name = o1.getName().compareTo(o2.getName());
        if(name == 0){
            int lastName = o1.getLastName().compareTo(o2.getLastName());
            if(lastName == 0){
                int age = o1.getAge() - o2.getAge();
                if(age == 0){
                    int size = o1.getGradesArray().length - o2.getGradesArray().length;
                    if(size == 0){
                        int max = o1.getGradesArray().length;
                        if(max > o2.getGradesArray().length){
                            max = o2.getGradesArray().length;
                        }
                        int grades;
                        for(int i = 0; i < max; i++){
                            grades = o1.getGradesArray()[i] - o2.getGradesArray()[i];
                            if(grades != 0){
                                return grades;
                            }
                        }
                        return 0;
                    }
                    return size;
                }
                return age;
            }
            return lastName;
        }
        return name;
    }
}
