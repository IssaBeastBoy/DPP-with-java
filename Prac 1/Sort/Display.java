package multithread;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoin{

  private static final int SIZE = 10000;

  public static void main(String[] args) {
    int[] data_Structure = new int[SIZE];
    Random rand = new Random();
    for (int i = 0; i < data_Structure.length; i++) {
      int generate_Rand = rand.nextInt((SIZE) + 1);
      data_Structure[i] = generate_Rand;

    }
    Sort recursiveQS = new Sort(data_Structure);

    ForkJoinPool pool = new ForkJoinPool();
    pool.invoke(recursiveQS);

    pool.shutdown();

    System.out.println("data = " + Arrays.toString(data_Structure));
  }
}