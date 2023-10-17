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

// public class Testbench {
//     public static void main(String[] args) {
//         OrderedPair pair1 = new OrderedPair(1, 2);
//         OrderedPair pair2 = new OrderedPair(1, 2);
//         OrderedPair pair3 = new OrderedPair(14, 2);

//         HashSet<OrderedPair> ops = new HashSet<>();
//         ops.add(pair1);
//         ops.add(pair3);
//         System.out.println(ops);

//         System.out.println(ops.contains(pair1));
//         System.out.println(ops.contains(pair2));
//         System.out.println(pair3);
//         System.out.println(ops);



//         // System.out.println(pair1.equals(pair1));

//         System.out.println(pair1.equals(pair2));
//     }
// }