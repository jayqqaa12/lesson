
public  class GenStreamTest{


  @Test
  public void gen(){

Random seed = new Random();
Supplier<Integer> random = seed::nextInt;
Stream.generate(random).limit(10).forEach(System.out::println);
//Another way
IntStream.generate(() -> (int) (System.nanoTime() % 100)).
limit(10).forEach(System.out::println);

  }


  @Test 

  public void itorection(){

Stream.iterate(0, n -> n + 3).limit(10). forEach(x -> System.out.print(x + " "));.

 }


}