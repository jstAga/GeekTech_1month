public class Main {
    public static void main(String[] args) {
        System.out.println(walk(21, 29));
        System.out.println(walk(19, 27));
        System.out.println(walk(46, -9));
        System.out.println(walk(27, -30));
        System.out.println(walk(8, 35));
        System.out.println(" ");

        System.out.println(walk(generateRandomAge(), 23));
    }

    public static String walk(int age, int temperature) {

        if ((age > 20 && age < 45) && (temperature > -20 && temperature < 30)) {
            return ("Можно идти гулять");
        } else if (age < 20 && (temperature > 0 && temperature < 28)) {
            return ("Можно идти гулять");
        } else if (age > 45 && (temperature > -10 && temperature < 25)) {
            return ("Можно идти гулять");
        } else {
            return ("Оставайтесь дома");
        }
    }

    public static int generateRandomAge() {
        return (int) (Math.random() * 70);
    }
}