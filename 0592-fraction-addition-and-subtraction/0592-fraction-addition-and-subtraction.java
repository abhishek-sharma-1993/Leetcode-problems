class Solution {
    public String fractionAddition(String input) {
        List<int[]> list = new ArrayList<>();
        int denominator = 1;
        char sign = '+';
        int i=0;
        while (i < input.length()) {
            char c = input.charAt(i);
            if(c == '-' || c == '+'){
                sign = c;
                i++;
            }
            int a = Integer.parseInt(String.valueOf(input.charAt(i)));
            if(input.charAt(i+1) != '/'){
                a = a*10+Integer.parseInt(String.valueOf(input.charAt(i+1)));
                i++;
            }
            i += 2;

            int b = Integer.parseInt(String.valueOf(input.charAt(i)));
            if(i+1< input.length() && input.charAt(i+1) != '-' && input.charAt(i+1) != '+'){
                b = b*10+Integer.parseInt(String.valueOf(input.charAt(i+1)));
                i++;
            }

            denominator = lcm(denominator, b);
            int numerator = sign == '-' ? -1 * a: a;
            list.add(new int[]{numerator,b});
            i++;
        }

        int numerator = 0;
        for(int[] num: list){
            int a = num[0];
            int b = num[1];
            numerator += a * (denominator/b);
        }

        int gcd = gcd(numerator, denominator);
  
        gcd = Math.abs(gcd);
        numerator /= gcd;
        denominator /= gcd;

        return (numerator+"/"+denominator);
    }
    private static int lcm(int a, int b) {
        return (a*b)/ gcd(a,b);
    }
    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}