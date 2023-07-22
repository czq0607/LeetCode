package Java;
import java.util.Scanner;

public class myPow {
        public static double myPow(double x, int n) {
            if (n == 0) {
                return 1.0;
            }
            if (n < 0) {
                x = 1.0 / x;
                n = -n;
            }
            if (n % 2 == 0) {
                return myPow(x * x, n / 2);
            } else {
                return x * myPow(x * x, n / 2);
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入底数 x：");
            double base = scanner.nextDouble();
            System.out.print("请输入指数 n：");
            int exponent = scanner.nextInt();
            scanner.close();

            System.out.println(base + " 的 " + exponent + " 次方结果为：" + myPow(base, exponent));
        }
}
