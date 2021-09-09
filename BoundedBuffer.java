public class BoundedBuffer {
    int a[];
    int size;
    int pos;
    int count;

    public BoundedBuffer(int size, int pos, int count) {
        this.a = new int[size];
        this.size = size;
        this.pos = pos;
        this.count = count;
    }

    public void put(int n){
        a[this.pos] = n;
        this.pos +=1;
        this.count +=1;
    }

    public void remove(){
        a[this.pos] = 0;
        this.pos -= 1;
        this.count -= 1;
    }
}
