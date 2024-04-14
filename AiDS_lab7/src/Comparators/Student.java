package Comparators;

public class Student {
    private String name;
    private String lastName;
    private int age;
    private int[] gradesArray;

    public Student(String name, String lastName, int age, int[] gradesArray){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gradesArray = gradesArray;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int[] getGradesArray() {
        return gradesArray;
    }

    public void setGradesArray(int[] gradesArray) {
        this.gradesArray = gradesArray;
    }

    public String toString(){
        StringBuilder text = new StringBuilder("(" + this.name + ", " + this.lastName + ", " + this.age + ", oceny:[");
        for(int i = 0; i < gradesArray.length; i++){
            text.append(gradesArray[i] + ", ");
        }
        if(gradesArray.length>0){
            text.delete(text.length()-2, text.length());
        }
        text.append("])");
        return text.toString();
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash ^= this.name.hashCode();
        hash ^= this.lastName.hashCode();
        hash ^= this.age;
        return hash;
    }

}
