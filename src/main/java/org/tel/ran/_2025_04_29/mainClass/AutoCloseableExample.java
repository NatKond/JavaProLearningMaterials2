package org.tel.ran._2025_04_29.mainClass;

public class AutoCloseableExample {

    static class MyResource implements AutoCloseable {

        @Override
        public void close() throws Exception {
            throw new RuntimeException("Error when closing a resource.");
        }
    }

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        try(MyResource resource = new MyResource()) {
            throw new RuntimeException("Error in try with resources.");
        } catch (Exception e) {
            System.out.println("Error in main : " + e.getMessage());
            for (Throwable throwable : e.getSuppressed()){
                System.out.println("Suppressed exception : " + throwable.getMessage());
            }
        }
    }
}
