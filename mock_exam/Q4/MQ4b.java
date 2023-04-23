class NoCakeFoundException extends Exception {
    NoCakeFoundException() {}
    NoCakeFoundException(String message) {}

    public String toString() {
        return "This Cake is a Lie!";
    }
}

class Cake {
    public void getCake() throws NoCakeFoundException {
        throw new NoCakeFoundException();
    }

    public void eatCake() {
        try {
            getCake();
        } catch (NoCakeFoundException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Cake cake = new Cake();
        cake.eatCake();
    }
}
