// // Write a program to determine whether a relation is a function from a set X to a set Y.
// // Joseph Cijo - 2022A7PS0019U

// import java.util.*;

// // class to define a relation
// class Relation {

//     private HashSet<Integer> domainSet;
//     private HashSet<Integer> coDomainSet;
//     private HashSet<OrderedPair> relations;
//     private HashSet<Integer> relationsX = new HashSet<>();
//     private HashSet<Integer> relationsRange = new HashSet<>();

//     // public Relation()

//     public Relation(HashSet<Integer> domainSet, HashSet<Integer> coDomainSet, HashSet<OrderedPair> relations) {
//         this.domainSet = domainSet;
//         this.coDomainSet = coDomainSet;
//         this.relations = relations;

//         for (OrderedPair pair : relations) {
//             relationsX.add(pair.getEl1());
//             relationsRange.add(pair.getEl2());

//         }

//     }

//     public boolean isRelation() {
//         if (!domainSet.containsAll(relationsX) || !coDomainSet.containsAll(relationsRange)) {
//             return false;

//         }

//         else {
//             return true;

//         }
//     }

//     public boolean isFunction() {

//         HashSet<Integer> testForX = new HashSet<>();

//         for (OrderedPair pair : relations) {
//             int xValue = pair.getEl1();
//             if (testForX.contains(xValue)) {
//                 return false;

//             }

//             testForX.add(xValue);

//         }
//         return true;

//     }

// }

// class OrderedPair implements Comparable<OrderedPair> {
//     private int el1;
//     private int el2;

//     public int getEl1() {
//         return el1;

//     }

//     public int getEl2() {
//         return el2;

//     }

//     public OrderedPair(int el1, int el2) {
//         this.el1 = el1;
//         this.el2 = el2;

//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (!(obj instanceof OrderedPair))
//             return false;
//         OrderedPair casted = ((OrderedPair) obj);

//         return el1 == casted.el1 && el2 == casted.el2;

//     }

//     @Override
//     public int compareTo(OrderedPair o) {
//         int compare1 = Integer.compare(el1, o.el1);
//         int compare2 = Integer.compare(el2, o.el2);
//         return (compare1 != 0) ? compare1 : compare2;

//     }

//     @Override
//     public int hashCode() {
//         return Objects.hash(el1, el2);

//     }

//     @Override
//     public String toString() {
//         return "(" + el1 + ", " + el2 + ")";

//     }

// }

// public class Testbench {

//     // Method to accept and set the user inputs
//     public static HashSet<Integer> inputSet() {
//         // initializing variable to take user input of a set
//         HashSet<Integer> set = new HashSet<>();
//         Scanner input = new Scanner(System.in);

//         // separates string input at specified delimiter
//         String[] domainInput = input.nextLine().split(",");

//         for (String num : domainInput) {
//             String stripped = num.strip();

//             // converting valid inputs to integers in the try block
//             try {
//                 set.add(Integer.parseInt(stripped));

//             } catch (Exception e) {
//                 System.out.println("\tInvalid Input: " + stripped);

//             }

//         }
//         return set;

//     }

//     // method to input and return orderedPairs
//     public static OrderedPair inputOrderedPair(Scanner sc) {
//         while (true) {
//             System.out.print("  ==> ");
//             String[] input = sc.nextLine().split(",", 3);
//             if (input.length < 2) {
//                 continue;

//             }

//             try {
//                 return new OrderedPair(
//                         Integer.parseInt(input[0].strip()),
//                         Integer.parseInt(input[1].strip()));
//             } catch (Exception e) {
//                 System.out.println("  Please enter in x,y format, try again:");
//                 continue;

//             }

//         }

//     }

//     // Method to display Sets
//     public static void printSet(HashSet<Integer> domainSet, HashSet<Integer> coDomainSet,
//             HashSet<OrderedPair> relations) {

//         // Print the set X (Domain)
//         Iterator<Integer> domainCursor = domainSet.iterator();
//         System.out.println("\nThe Domain is:");
//         System.out.print("{");
//         while (domainCursor.hasNext()) {
//             for (int i = 0; i < (domainSet.size() - 1); i++) {
//                 System.out.print(domainCursor.next() + ", ");

//             }
//             System.out.print(domainCursor.next() + "}");

//         }

//         Iterator<Integer> coDomainCursor = coDomainSet.iterator();
//         // Print the set Y (CoDomain)
//         System.out.println("\nThe CoDomain is:");
//         System.out.print("{");
//         while (coDomainCursor.hasNext()) {
//             for (int i = 0; i < (coDomainSet.size() - 1); i++) {
//                 System.out.print(coDomainCursor.next() + ", ");

//             }
//             System.out.print(coDomainCursor.next() + "}");

//         }

//         // Print the set of Relations
//         Iterator<OrderedPair> relationsCursor = relations.iterator();
//         System.out.println("\nThe Relations is / are:");
//         System.out.print("{");
//         while (relationsCursor.hasNext()) {
//             for (int i = 0; i < (relations.size() - 1); i++) {
//                 System.out.print(relationsCursor.next() + ", ");

//             }
//             System.out.print(relationsCursor.next() + "}");

//         }

//     }

//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);

//         // initializing variables to take user input
//         System.out.println("Please enter the Elements of Domain (in one line separated by ','): ");
//         System.out.print("  ==> ");

//         HashSet<Integer> domainSet = inputSet();

//         System.out.println("Please enter the Elements of CoDomain (in one line separated by ','): ");
//         System.out.print("  ==> ");

//         HashSet<Integer> coDomainSet = inputSet();

//         // accepting user input relations as ordered pairs
//         HashSet<OrderedPair> relations = new HashSet<>();
//         Scanner joe = new Scanner(System.in);
//         System.out.print("Please enter the number of relations: ");
//         int numberOfRelations = joe.nextInt();
//         joe.nextLine();

//         Integer i = 0;
//         System.out.println("Enter the ordered pairs, one by one, in x,y form:");
//         for (i = 0; i < numberOfRelations; i++) {
//             relations.add(inputOrderedPair(joe));

//         }

//         // test var
//         Relation check = new Relation(domainSet, coDomainSet, relations);

//         // test op

//         printSet(domainSet, coDomainSet, relations);

//         if (check.isFunction() && check.isRelation()) {
//             System.out.println("The relation is a Function of the Domain and the CoDomain");

//         }

//         else {
//             System.out.println("The relation is not a Function of the Domain and the CoDomain");

//         }

//     }

// }
