class Solution {
    /*
    The idea actually is treat numbers as String then use a comparator betwen curr and prev 
    and prev + curr and see which one is actually bigger

    */
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        int idx = 0;
        for (int num : nums){
            arr[idx++] = String.valueOf(num);
        }

        
        Arrays.sort(arr, (a,b) ->{
            String orda = a + b;
            String ordb = b + a;

            return ordb.compareTo(orda);
        });

         if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr){
            sb.append(s);
        }

        return sb.toString();
    }

}