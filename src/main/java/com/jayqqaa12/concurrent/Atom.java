

@ThreadSafe
public class Atom{

AtomicInteger atomicInteger = new AtomicInteger();


for(int b = 0; b < numThreads; b++) {
  new Thread(() -> {
    for(int a = 0; a < iteration; a++) {
      atomicInteger.incrementAndGet();
    }
  }).start();
}


}