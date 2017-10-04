public class Driver {

    public static void main(String[] args) {

        MyLinkedList ll = new MyLinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(2);
        if (ll.toString().compareTo("1 2 3 2") != 0) {
            System.err.println("Failed toString");
            System.exit(1);
        }

        if (ll.delete(2) != 1 || ll.toString().compareTo("1 3 2") != 0) {
            System.err.println("Failed valid delete");
            System.exit(1);
        }

        if (ll.delete(20) == 1) {
            System.err.println("Failed invalid delete");
            System.exit(1);
        }

        if (ll.search(2) != true) {
            System.err.println("Failed valid search");
            System.exit(1);
        }

        if (ll.search(20) == true) {
            System.err.println("Failed invalid search");
            System.exit(1);
        }

        ll.reverse();

        if (ll.toString().compareTo("2 3 1") != 0) {
            System.err.println("Failed list reverse");
            System.exit(1);
        }

        MyLinkedList merge = new MyLinkedList();
        merge.insert(100);
        merge.insert(777);

        MyLinkedList res = ll.merge(merge);

        if (res.toString().compareTo("2 100 3 777 1") != 0) {
            System.err.println("Failed list merge");
            System.exit(1);
        }

        System.out.println("Passed tests");

    }

}