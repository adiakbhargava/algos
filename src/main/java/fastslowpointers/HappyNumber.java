package fastslowpointers;

public class HappyNumber {
    public static void main(String[] args) {
        // happy numbers
        int num = 1;
        System.out.println("Original Num : " + num
        + "\nIS NUM HAPPY? : "
                + ((new HappyNumber()).isHappyNumber(num) ? "YES" : "NO"));

        num = 7;
        System.out.println("\nOriginal Num : " + num
                + "\nIS NUM HAPPY? : "
                + ((new HappyNumber()).isHappyNumber(num) ? "YES" : "NO"));

        num = 10;
        System.out.println("\nOriginal Num : " + num
                + "\nIS NUM HAPPY? : "
                + ((new HappyNumber()).isHappyNumber(num) ? "YES" : "NO"));

        num = 13;
        System.out.println("\nOriginal Num : " + num
                + "\nIS NUM HAPPY? : "
                + ((new HappyNumber()).isHappyNumber(num) ? "YES" : "NO"));

        num = 19;
        System.out.println("\nOriginal Num : " + num
                + "\nIS NUM HAPPY? : "
                + ((new HappyNumber()).isHappyNumber(num) ? "YES" : "NO"));

        num = 23;
        System.out.println("\nOriginal Num : " + num
                + "\nIS NUM HAPPY? : "
                + ((new HappyNumber()).isHappyNumber(num) ? "YES" : "NO"));

        num = 28;
        System.out.println("\nOriginal Num : " + num
                + "\nIS NUM HAPPY? : "
                + ((new HappyNumber()).isHappyNumber(num) ? "YES" : "NO"));

        num = -28;
        System.out.println("\nOriginal Num : " + num
                + "\nIS NUM HAPPY? : "
                + ((new HappyNumber()).isHappyNumber(num) ? "YES" : "NO"));

        num = 32;
        System.out.println("\nOriginal Num : " + num
                + "\nIS NUM HAPPY? : "
                + ((new HappyNumber()).isHappyNumber(num) ? "YES" : "NO"));

        // unhappy number
        num = 5;
        System.out.println("\nOriginal Num : " + num
                + "\nIS NUM HAPPY? : "
                + ((new HappyNumber()).isHappyNumber(num) ? "YES" : "NO"));

    }

    private boolean isHappyNumber(int num){
        // declare fast and slow 'pointers'
        int fast = num;
        int slow = num;
        do{
            // advance slow pointer by one number at a time
            slow = getNextNum(slow);
            // advance fast pointer by two numbers at a time
            fast = getNextNum(getNextNum(fast));
            // if fast is equal to one, we know that we have reached the final number in which our original number is a happy number
            if(fast == 1){
                return true;
            }
            // if fast and slow pointers ever 'meet' (have same number), then we know that we don't have a happy number and we can break out of the loop
            // this prevents the loop going on infinitely
        } while(fast != slow);

        return false;
    }

    private int getNextNum(int num){
        // declare nextNum and set to 0
        int nextNum = 0;
        // sum the squares of the individual digit comprising num
        while(num > 0){
            // get rightmost digit of num
            int digit = num % 10;
            // truncate the last digit, positioning next digit as the new last digit
            num = num / 10;
            // add the square of the digit to the nextNum
            nextNum = nextNum + ((int)Math.pow(digit, 2));
        }

        return nextNum;
    }

}
