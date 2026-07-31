class DynamicArray {
    private int capacity;
    private int lastIdx;

    private int[] array;
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];

        lastIdx=0;
    }

    public int get(int i) {
        if(i > lastIdx) return -1;

        return array[i];
    }

    public void set(int i, int n) {
        array[i]=n;
    }

    public void pushback(int n) {
        if (lastIdx >= capacity){
            resize();
        }
        array[lastIdx++]=n;
    }

    public int popback() {
        lastIdx--;
        int last = array[lastIdx];
        return last;
    }

    private void resize() {
        capacity *=2;
        int[] newArr = new int[capacity];

        for (int i = 0; i<array.length; i++){
            newArr[i]=array[i];
        }

        array = newArr; 
    }

    public int getSize() {
        return lastIdx;
    }

    public int getCapacity() {
        return capacity;
    }
}
