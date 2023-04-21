class Q1c {
    public static int countFives(int[] nums) {
        int counter = 0;

        for(int i: nums) {
            if(i == 5) {
                counter += 1;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 5, 7, 11, 13, 17, 5, 0, -5, 5};
        Q1c Test = new Q1c();

        System.out.println(Test.countFives(num));
    }
}
