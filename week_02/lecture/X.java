class X {
    int num = 1;
    int getNum() {
        return num;
    }
}

class Y extends X {
    @Override
    int getNum() {
        return super.getNum();
    }
}
