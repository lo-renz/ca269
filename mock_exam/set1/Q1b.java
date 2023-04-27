class MirrorMirror {
    /**
    * a method which checks whether one string is the roated version of the other.
    *
    * @param s1 and s2 are the strings to be checked if one is the rotated version of the other.
    * @return a boolean value depending on whether one string is the roated version of the other.
    */
    public static boolean isRotated(String s1, String s2) {
        for(int i=0; i < s1.length(); ++i) {
            if(s1.charAt(i) != s2.charAt(s2.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    /**
    * a method which rotates a string to the right once.
    *
    * @param str, the string you want to rotate to the right once.
    * @return a string which is the rotated version of str.
    */
    public static String rotateRight(String str) {
        String rotated = "";
        for(int i=0; i<str.length(); i++) {
            rotated += str.charAt(str.length()-i-1);
        }
        return rotated;
    }

    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "olleH";
        System.out.println(isRotated(s1, s2));

        String name = "osner";
        System.out.println(rotateRight(name));
    }
}
