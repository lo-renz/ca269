import java.util.List;
import java.util.ArrayList;

class Mute {
    private List<Integer> list;
    public Mute() {
        this.list = new ArrayList<Integer>();
    }

    public int getListCount() {
        return this.list.size();
    }

    public String getListItem(int position) {
        if(position < getListCount()) {
            return "The number at " + position + " is " + this.list.get(position);
        }
        return "Error, that position does not exist!";
    }

    public static void main(String[] args) {
        Mute l = new Mute();
        System.out.println(l.getListCount());
        System.out.println(l.getListItem(1));
        System.out.println(l.getListCount());
    }
}
