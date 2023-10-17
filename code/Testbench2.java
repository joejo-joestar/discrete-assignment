// import java.util.*;

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

// public class Testbench2 {
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

//     // method to return user input relations as ordered pairs as a set
//     public static HashSet<OrderedPair> inputOrderedPairs() {
//         HashSet<OrderedPair> Pairs = new HashSet<>();
//         Scanner joe = new Scanner(System.in);
//         System.out.print("Please enter the number of relations: ");
//         int numberOfRelations = joe.nextInt();
//         joe.nextLine();

//         System.out.println("Enter the ordered pairs, one by one, in x,y form:");
//         for (int i = 0; i < numberOfRelations; i++) {
//             Pairs.add(inputOrderedPair(joe));

//         }
//         return Pairs;

//     }

//     public static void main(String[] args) {
//         System.out.println(inputOrderedPairs());

//     }

// }
