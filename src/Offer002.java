public class Offer002 {
    public static String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while ( i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            builder.append(sum);
        }

        if (carry == 1) {
            builder.append(carry);
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args){
        System.out.println(addBinary("11", "10"));
    }
}
