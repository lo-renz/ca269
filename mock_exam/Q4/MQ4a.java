class Factory<T> {
    T item;
    public T getItem() { return this.item; }
    public void setItem(T item) { this.item = item; }
}

class Apple { }
class AppleFactory extends Factory<Apple> {}

class Orange { }
class OrangeFactory extends Factory<Orange> {}


class Lemon { }
class LemonFactory extends Factory<Lemon> {
    public void removeItem() {
        this.item = null;
    }

    @Override
    public void setItem(Lemon item) {
        if(this.item == null) {
            this.item = item;
        }
    }
}
