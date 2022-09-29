package africa.semicolon.lumexpress;

public class Product {
    public static void main(String[] args) {

        int[] list = {1, 10, 2, 6, 5, 3};
        System.out.println(highestProduct(list));

    }

    public static Integer highestProduct(int[] arr) {

        if ((arr == null) || (arr.length < 3)) {
            return null;
        }
        else {
            int maxInteger = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    for (int k = j + 1; k < arr.length; k++) {
                        int product = arr[i] * arr[j] * arr[k];
                        if (product >= maxInteger) {
                            maxInteger = product;
                        }
                    }
                }
            }
            return maxInteger;
        }
    }

}


