package ca.georgiancollege.comp1011summer2024_sebastian_aguirre_200558953.WEEK8;

import java.util.*;

public class Week8{

    static void collectionIntro(){
        // Collection is an interface (godfather of interface)
        // List, Set, Queue, Map
        // List: ArrayList, LinkedList, Vector
        // Set: HashSet, LinkedHashSet, TreeSet
        // Queue: PriorityQueue
        // Deque: ArrayDeque
        // Map: HashMap, LinkedHashMap, TreeMap

        /*
           Collection

          List    Queue     Set    Map

          List: ordered (index) values
          Queue: ordered (values), natural ordering (Ascending), FIFO
          Set: unordered (values), no duplicates
          Map: key-value pairs aka arrays, dictionary

          You can no instantiate collections so:

            the objects of these interfaces are:
            List: ArrayList, LinkedList
            Queue: PriorityQueue
            Set: TreeSet, HashSet
            Map: TreeMap, HashMap
         */


        List<Integer> list1 = new ArrayList<>();
        List<Double>list2 = new LinkedList<>();
        Queue<Float> queue1 = new PriorityQueue<>();
        Set<String> set1 = new HashSet<>();
        Set<Character>set2 = new TreeSet<>();
        Stack<Short> stack= new Stack<>();


        //add
        list1.add(5);
        list1.add(10);
        list1.add(15);
        list1.add(20);
        list2.add(34.56);
        list1.add(-290);

        //FIFO - como una fila de tienda de HOMESENSE
        queue1.add(10f);
        queue1.add(-1f);
        queue1.add(5f);
        queue1.add(15f);


        //what is the ordering of the queue.
        // -1   5   10  15

        //how do I get the value 5?
        System.out.println(queue1.size());
        System.out.println(queue1.poll()); // get out
        System.out.println(queue1.poll());
        System.out.println(queue1.peek());
        System.out.println(queue1.size());

        System.out.println("*".repeat(10));
        //This is how we can iterate all the values of the queue
        while(queue1.size()>0){
            System.out.println(queue1.poll());
        }
        System.out.println("*".repeat(10));


        //iterator
        Iterator <Integer> iterator1 = list1.iterator();
//        list2.iterator();
//        queue1.iterator();
//        set1.iterator();

        /*
         5      10      15      20
         */

        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        ListIterator<Double> listIterator1 = list2.listIterator();
        ListIterator<Integer> listIterator2 = list1.listIterator();

        //5 10 15 20

        listIterator1.hasNext(); //true
        listIterator1.next(); // 5
        listIterator1.next(); // 10
        listIterator1.hasPrevious(); //True
        listIterator1.previous(); // 10
            System.out.println(listIterator1.previous());
    }

    static void collectionsPart2(){
        TreeSet<Integer> set1 = new TreeSet<>(); // garantee to be order in terms of values, it
        // has natural ordering (Ascending)
        HashSet<Double> set2 = new HashSet<>(); // not guarantee to be order in terms of values

        set1.add(10);
        set1.add(-200);
        set1.add(50);

        for (int value: set1.tailSet(0)){
            System.out.println(value);
            System.out.println("----".repeat(5));
        }

        for (int value: set1.headSet(0)){
            System.out.println(value);
        }
    }

    //Store your favourite movies
    // Set : HashSet

    //I want to answer student emails
    // Queue: PriorityQueue

    //Display the highest grades That I received this semester
    //TreeSet

    //Store all of the courses codes of school
    //HashSet => best b/c distinct
    //PriorityQueue

    static void collectionsPart3(){
        /*
                Map: key-value pairs
                      introducce categories as indexes (keys)
         */

        HashMap<String,String> favFoods = new HashMap<>();
        favFoods.put("1st","burger");
        favFoods.put("2st","ribs");

        System.out.println(favFoods.get("1st"));//burger
        System.out.println(favFoods.get("2st"));//ribs

        System.out.println(favFoods.containsKey("3st"));//null
        System.out.println(favFoods.containsValue("hot dog"));//false

        Set<String> favFoodsKeys = favFoods.keySet();

        for (String key: favFoodsKeys){
            System.out.println(key + " : " + favFoods.get(key));
        }
    }
    public static void main(String[] args) {
        collectionIntro();
//        collectionsPart3();
    }
}
