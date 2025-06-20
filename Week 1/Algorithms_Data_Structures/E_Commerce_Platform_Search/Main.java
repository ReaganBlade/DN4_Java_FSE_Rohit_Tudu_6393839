import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        System.out.println("E_Commerce_Platform_Search");

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(10, "CellPhone", "Electronics"));
        products.add(new Product(5, "Shoes", "Fashion"));
        products.add(new Product(20, "Laptop", "Electronics"));

        // Sorting the prodcut Array
        products.sort(Comparator.comparingInt(p -> p.productId));

        // Sample Search
        Product toFind = new Product(20, "Laptop", "Electronics");

        // Linear Search Test phrase
        boolean resultLinear = LinearSearch(products, toFind);
        System.out.println("Linear Search Found: " + resultLinear);

        // Binary Search Test phrase
        boolean resultBinary = BinarySearch(products, toFind);
        System.out.println("Binary Search Found: " + resultBinary);

    }

    // Code For Linear Search -> using boolean output (true or false)
    public static Boolean LinearSearch(ArrayList<Product> products, Product tofind){
        int size = products.size();

        for (int i = 0; i < size; i++){
            if ( tofind.productId == products.get(i).productId){
                return true;
            }
        }

        return false;
    }

    // Code for Binary Search -> Using boolean output (true or false)
    public static Boolean BinarySearch(ArrayList<Product> products, Product tofind){
        int size = products.size();
        int low = 0, high = size - 1;

        while (low <= high){
            int mid = ((low + high) / 2);

            Product curProduct = products.get(mid);

            if (curProduct.productId == tofind.productId){
                return true;
            }

            if (curProduct.productId < tofind.productId){
                low = mid - 1;
            } else {
                high = mid + 1;
            }

        }

        return false;
    }
}