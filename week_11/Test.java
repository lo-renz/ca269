import com.google.gson.Gson;

class Data {
    int id;
    String name;

    Data() {
        this.id = 0;
        this.name = "Unknown";
    }

    Data(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Test {
    public static void main(String args[]) {
        Data d1 = new Data();
        Gson gson = new Gson();
        String json = gson.toJson(d1);
        System.out.println(json);

        Data d2 = new Data(1, "Jane Doe");
        gson = new Gson();
        json = gson.toJson(d2);
        System.out.println(json);
    }
}