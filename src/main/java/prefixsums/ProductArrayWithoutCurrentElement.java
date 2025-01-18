package prefixsums;

import java.util.Arrays;

public class ProductArrayWithoutCurrentElement {
    public static void main(String[] args) {
        int[] nums = {2,3,1,4,5};
        System.out.println("Arr : " + Arrays.toString(nums));
        System.out.println("Product Array : " + Arrays.toString((new ProductArrayWithoutCurrentElement()).productArrayWithoutCurrentElement(nums)));
    }

    private int[] productArrayWithoutCurrentElement(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        for(int j = 0; j < n; j++){
            result[j] = 1;
        }

        for(int i = 1; i < n; i++){
            result[i] = result[i - 1] * nums[i - 1];
        }
        int rightProduct = 1;
        for(int i = n-1; i >= 0; i--){
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
