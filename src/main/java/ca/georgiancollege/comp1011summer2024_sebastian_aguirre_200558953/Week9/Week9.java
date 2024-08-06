package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.Week9;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Week9 {

    static void example1(){

        IntStream is = IntStream.range(1, 11);
        is.forEach(System.out::println);
    }

    static void example2(){
        IntStream.range(1,21)
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

    }

    static void example3(){

//        IntStream.range(1, 101)
//                .filter(v -> v % 5 == 0)
//                .forEach(v -> System.out.println(v)
//                );
//

        IntStream.range(1, 21)
                .map(v -> v * 5)
                .forEach(System.out::println
                );

    }

    static void example4(){

        //generate values between 1 and 100
        //discard values where the first digit is a 6
        //output 3 times the value of the remaining numbers

        IntStream.rangeClosed(1,100)
                .filter(v -> v/10 != 6)
                .map(v -> v*3) // do/ alter sth to each value
                .forEach(System.out::println);
    }

    static void example5(){
        Random rand = new Random();

        SecureRandom srand = new SecureRandom();

        IntStream tenRandomNumsBetween1and100 =
                rand.ints(10,1,101);

        //tenRandomNumsBetween1and100.forEach(System.out::println);

        int[] values = tenRandomNumsBetween1and100.toArray();
        //Arrays.asList(values).stream().forEach(System.out::println);
        for(int value : values){
            System.out.println(value);
        }


    }

    static void example6(){
        Stream <Object> values = Stream.of(1,1.2,true,"hi");

        values.filter(v -> String.valueOf(v).length() >= 3)
                .forEach(System.out::println);

        Stream.builder().add(1234).add(false).add("blah").build()
        .filter(s->String.valueOf(s).contains("e"))
                .forEach(System.out::println);


    }

    static void example7(){

        ArrayList<String> names = new ArrayList<>();

        names.add("Mary Brown");
        names.add("kernel Sanders");
        names.add("John Doe");
        names.add("Jane Smith");

        //MODO TRADICIONAL
        ArrayList<String> namesContainingDVersion1 = new ArrayList<>();
        for (String name : names){
            if (name.toLowerCase().contains("d")){
                namesContainingDVersion1.add(name);
            }
        }

        for(String name : namesContainingDVersion1){
            System.out.println(name);
        }

        //MODO CON PROGRAMACION FUNCIONAL
            //SE NOTA MUCHO LA DIFERENCIA!!!!
        names.stream().filter (s -> s.toLowerCase().contains("d")).forEach(System.out::println);
    }


    static void funtask1(){

        LinkedList<Student> students = new LinkedList<>();
        int numberOfValuesToGenerate = 1000;
        SecureRandom srand = new SecureRandom();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();

        firstNames.add("John");
        firstNames.add("Mary");
        firstNames.add("Paul");
        firstNames.add("Jennifer");
        firstNames.add("Sue");
        firstNames.add("Larry");

        lastNames.add("Smith");
        lastNames.add("Johnson");
        lastNames.add("Edwards");
        lastNames.add("James");
        lastNames.add("Ronaldo");
        lastNames.add("Hamilton");

        int[] ageValues =  srand.ints(numberOfValuesToGenerate, 18, 66).toArray();
        int[] gradeValues =  srand.ints(numberOfValuesToGenerate, 40,101).toArray();

        for(int i = 0; i < numberOfValuesToGenerate; i++){
            students.add(new Student(
                    srand.nextInt(1000,100000),
                    firstNames.get(srand.nextInt(firstNames.size())),
                    lastNames.get(srand.nextInt(lastNames.size())),
                    ageValues[i],
                    gradeValues[i]
            ));
        }

        System.out.println("Failing Students");
        students.stream().filter(s-> s.getGrade() < 50).forEach(s-> System.out.printf("Name = %s, Grade=%.1f\n",
                s.getFirstName() +" " + s.getLastName(), s.getGrade()));

        System.out.println("*".repeat(20));

        System.out.println("Mature Students");
        students.stream().filter(s-> s.getAge() >= 30).forEach(s-> System.out.printf("Name = %s, Age=%d\n",
                s.getFirstName() +" " + s.getLastName(), s.getAge()));

        System.out.println("*".repeat(20));

        System.out.println("Young(18-25) Honor Roll Students");
        students.stream().filter(s-> s.getAge() < 26 && s.getGrade() >= 80 ).forEach(s-> System.out.printf("Name = %s, Age=%d, Grade=%.1f\n",
                s.getFirstName() +" " + s.getLastName(), s.getAge(), s.getGrade()));

    }

    static void example8(){

        Thread t1 = new Thread();//Thread-N, N starts at 0
        t1.start();
        Thread t2 = new Thread("My Thread");
        t2.start();

        Scanner scanner = new Scanner(System.in);

        Runnable task = ()->{
            System.out.println("Hello from thread " + Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            //Integer.parseInt("abc");
            System.out.println("Thanks for coming by! " + Thread.currentThread().getName());
        };

        Thread t3 = new Thread(task);
        t3.start();

        //scanner.nextLine();

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getState());
        System.out.println("End of example8");

        System.out.println("*".repeat(10));
        task.run();

    }
    public static void main(String[] args) {
        example8();
    }
}
