class Duck {}
class Swan {}
class Heron {}

public class GenericFactory<T> {
    private T singleton;
    public T getNewItem() {
        return singleton;
    }
    GenericFactory(T singleton) {
        this.singleton = singleton;
    }

    public static void main(String[] args) {
        GenericFactory<Duck> DuckFactory = new GenericFactory<Duck>(new Duck());
        GenericFactory<Swan> SwanFactory = new GenericFactory<Swan>(new Swan());
        GenericFactory<Heron> HeronFactory = new GenericFactory<Heron>(new Heron());

        System.out.println(DuckFactory.getNewItem());
        System.out.println(SwanFactory.getNewItem());
        System.out.println(HeronFactory.getNewItem());
    }
}