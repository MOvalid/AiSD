package HashFunctions;

import Comparators.Student;

public class StudentHashFunction implements HashFunction<Student> {
    @Override
    public int hashCode(Student object) {
        int hash = object.hashCode();
        return object.hashCode();
    }
}
