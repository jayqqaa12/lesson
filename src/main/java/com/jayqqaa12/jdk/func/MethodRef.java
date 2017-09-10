

public class MethodRef(){


  public void staticRef(){
   
   Person [] persons = new Person[10];

//使用匿名类
Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.birthday.compareTo(o2.birthday);
            }
 });

//使用lambda表达式
Arrays.sort(persons, (o1, o2) -> o1.birthday.compareTo(o2.birthday));

//使用lambda表达式和类的静态方法
Arrays.sort(persons, (o1, o2) -> Person.compareByAge(o1,o2));

//使用方法引用
//引用的是类的静态方法
Arrays.sort(persons, Person::compareByAge);
   

  }


class ComparisonProvider{
            public int compareByName(Person a,Person b){
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(Person a,Person b){
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }


public  void instaceRef(){


	ComparisonProvider provider = new ComparisonProvider();

//使用lambda表达式
//对象的实例方法
Arrays.sort(persons,(a,b)->provider.compareByAge(a,b));

//使用方法引用
//引用的是对象的实例方法
Arrays.sort(persons, provider::compareByAge);
}





public  void instaceClassRef(){


	String[] stringsArray = {"Hello","World"};

//使用lambda表达式和类型对象的实例方法
Arrays.sort(stringsArray,(s1,s2)->s1.compareToIgnoreCase(s2));

//使用方法引用
//引用的是类型对象的实例方法
Arrays.sort(stringsArray, String::compareToIgnoreCase);
}



public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(SOURCE sourceColletions, Supplier<DEST> colltionFactory) {
        DEST result = colltionFactory.get();
        for (T t : sourceColletions) {
            result.add(t);
        }
        return result;
    }
 


public  void constuctRef(){


 
final List<Person> personList = Arrays.asList(persons);

//使用lambda表达式
Set<Person> personSet = transferElements(personList,()-> new HashSet<>());

//使用方法引用
//引用的是构造方法
Set<Person> personSet2 = transferElements(personList, HashSet::new); 
}




}