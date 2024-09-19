class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        if(expression.isEmpty()) return result;
        if(expression.length() == 1 ) {
            result.add(Integer.parseInt(expression));
            return result;
        }
        if(expression.length() == 2 
            && Character.isDigit(expression.charAt(0))){
                result.add(Integer.parseInt(expression));
                return result;
            }
        
        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);

            if(Character.isDigit(ch)) continue;

            List<Integer> left = diffWaysToCompute(expression.substring(0,i));
            List<Integer> right = diffWaysToCompute(expression.substring(i+1));

            for(int leftValue : left){
                for(int rightValue : right){
                    int currentValue = 0;

                    switch(ch){
                        case '+': currentValue = leftValue+rightValue; break;
                        case '-': currentValue = leftValue-rightValue; break;
                        case '*': currentValue = leftValue*rightValue; break;
                    }

                    result.add(currentValue);
                }
            }
        }
        return result;
    }
}