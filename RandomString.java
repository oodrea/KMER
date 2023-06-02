public class RandomString {

    public RandomString(){}


    public static String getAlphaNumericString(int n){
        String AlphaNumericString = "acgt";
        n = (int) Math.pow(10, n);
        StringBuilder sb = new StringBuilder(n);

        for(int i = 0; i < n; ++i) {
            int index = (int)((double)AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

}
