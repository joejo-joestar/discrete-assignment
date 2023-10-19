/*  Write a program to determine whether a relation is a function from a set
    X to a set Y. */

// Joseph Cijo - 2022A7PS0019U

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

// Class to define a relation
class Relation {

    private HashSet<Integer> domainSet;
    private HashSet<Integer> coDomainSet;
    private HashSet<OrderedPair> relations;
    private HashSet<Integer> relationsX = new HashSet<>();
    private HashSet<Integer> relationsRange = new HashSet<>();

    public Relation(HashSet<Integer> domainSet, HashSet<Integer> coDomainSet,
            HashSet<OrderedPair> relations) {
        this.domainSet = domainSet;
        this.coDomainSet = coDomainSet;
        this.relations = relations;

        for (OrderedPair pair : relations) {
            relationsX.add(pair.getEl1());
            relationsRange.add(pair.getEl2());

        }

    }

    public boolean isRelation() {
        if (!domainSet.containsAll(relationsX) ||
                !coDomainSet.containsAll(relationsRange)) {
            return false;

        }

        else {
            return true;

        }
    }

    public boolean isFunction() {

        HashSet<Integer> testForX = new HashSet<>();

        for (OrderedPair pair : relations) {
            int xValue = pair.getEl1();
            if (testForX.contains(xValue)) {
                return false;

            }

            testForX.add(xValue);

        }
        return testForX.equals(domainSet);

    }

}

// Class to store Objects as Ordered Pairs
class OrderedPair implements Comparable<OrderedPair> {
    private int el1;
    private int el2;

    public int getEl1() {
        return el1;

    }

    public int getEl2() {
        return el2;

    }

    public OrderedPair(int el1, int el2) {
        this.el1 = el1;
        this.el2 = el2;

    }

    // Methods to make the class "Hashable" (i.e., to remove duplicate elements)
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof OrderedPair))
            return false;
        OrderedPair casted = ((OrderedPair) obj);

        return el1 == casted.el1 && el2 == casted.el2;

    }

    @Override
    public int compareTo(OrderedPair o) {
        int compare1 = Integer.compare(el1, o.el1);
        int compare2 = Integer.compare(el2, o.el2);
        return (compare1 != 0) ? compare1 : compare2;

    }

    @Override
    public int hashCode() {
        return Objects.hash(el1, el2);

    }

    @Override
    public String toString() {
        return "(" + el1 + ", " + el2 + ")";

    }

}

// Class to display Sets
class Print {
    // Method to display HashSet as a Set
    public static void printSet(HashSet<Integer> set) {
        Iterator<Integer> setCursor = set.iterator();
        System.out.print("  {");
        while (setCursor.hasNext()) {
            for (int i = 0; i < (set.size() - 1); i++) {
                System.out.print(setCursor.next() + ", ");

            }
            System.out.println(setCursor.next() + "}");

        }

    }

    // Method to display Ordered Pairs as a Set
    public static void printOrderedPairs(HashSet<OrderedPair> relations) {
        // Print the set of Relations
        Iterator<OrderedPair> relationsCursor = relations.iterator();
        System.out.print("  {");
        while (relationsCursor.hasNext()) {
            for (int i = 0; i < (relations.size() - 1); i++) {
                System.out.print(relationsCursor.next() + ", ");

            }
            System.out.println(relationsCursor.next() + "}");

        }

    }

}

// Main Class
public class Code {
    // Method to accept and set the user inputs
    public static HashSet<Integer> inputSet(Scanner sc) {
        // Initializing variable to take user input of any set
        HashSet<Integer> set = new HashSet<>();
        String[] domainInput = sc.nextLine().split(",");

        for (String num : domainInput) {
            String stripped = num.strip();

            // Converting valid inputs to integers in the try block
            try {
                set.add(Integer.parseInt(stripped));

            } catch (Exception e) {
                System.out.println("\tInvalid Input: " + stripped);

            }

        }
        return set;

    }

    // Method to input and return orderedPairs
    public static OrderedPair inputOrderedPair(Scanner sc) {
        while (true) {
            System.out.print("  ==> ");
            String[] input = sc.nextLine().split(",", 3);
            if (input.length < 2) {
                continue;

            }

            try {
                return new OrderedPair(
                        Integer.parseInt(input[0].strip()),
                        Integer.parseInt(input[1].strip()));
            } catch (Exception e) {
                System.out.println("  Please enter in x,y format, " +
                        "try again:");
                continue;

            }

        }

    }

    // Main Method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Initializing variables to take user input
        System.out.println("\nPlease enter the Elements of Domain " +
                "(in one line separated by ','):");
        System.out.print("  ==> ");
        HashSet<Integer> domainSet = inputSet(input);

        System.out.println("\nPlease enter the Elements of CoDomain " +
                "(in one line separated by ','):");
        System.out.print("  ==> ");
        HashSet<Integer> coDomainSet = inputSet(input);

        // Accepting user input relations as ordered pairs
        HashSet<OrderedPair> relations = new HashSet<>();
        System.out.print("\nPlease enter the number of Relations: ");
        int numberOfRelations = input.nextInt();

        input.nextLine();
        System.out.println("Enter the ordered pairs, one by one, " +
                "in x,y form:");
        for (int i = 0; i < numberOfRelations; i++) {
            relations.add(inputOrderedPair(input));

        }

        Relation testObject = new Relation(domainSet, coDomainSet, relations);

        // Printing the sets
        System.out.println("\nThe Domain is:");
        Print.printSet(domainSet);
        System.out.println();

        System.out.println("The CoDomain is:");
        Print.printSet(coDomainSet);
        System.out.println();

        System.out.println("The Set of Relations is:");
        Print.printOrderedPairs(relations);
        System.out.println();

        // Printing outputs
        if (testObject.isRelation()) {
            if (testObject.isFunction()) {
                System.out.println("The input is a valid Relation and is a " +
                        "Function of the Domain and the CoDomain");

            }

            else {
                System.out.println("The input is a valid Relation but is Not " +
                        "a Function of the Domain and the CoDomain");

            }

        }

        else {
            System.out.println("The input is Not a valid Relation " +
                    "of the Domain and the CoDomain");

        }

    }

}
