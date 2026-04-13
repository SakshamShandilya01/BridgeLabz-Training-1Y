class CompareValues {

    
    public static <T> boolean isEqual(T a, T b) {
        return a.equals(b);
    }

    public static void main(String[] args) {

        System.out.println(isEqual(10, 10));          // true
        System.out.println(isEqual("Hi", "Hello"));   // false
        System.out.println(isEqual(5.5, 5.5));        // true
    }
}