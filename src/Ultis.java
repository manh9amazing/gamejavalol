public class Ultis {

    /**
     * gioi han player
     * @param value
     * @param min
     * @param max
     * @return
     */
    public static int clamp(int value, int min, int max) {
        //von da tu tao 1 khoang bo nho trong may
        if (value < min){
            return min;
        }
        if (value> max){
            return max;
        }
        return value;
    }
}
