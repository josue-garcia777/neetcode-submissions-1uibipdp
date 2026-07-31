type DynamicArray struct {
    len,
    cap int
    arr []int 
}

func NewDynamicArray(cap int) *DynamicArray {
    
    return &DynamicArray{
        len:0,
        cap: cap,
        arr: make([]int, cap),
    }
}

func (da *DynamicArray) Get(i int) int {
    if i > da.len{
        return -1
    }

    return da.arr[i]
}

func (da *DynamicArray) Set(i int, n int) {
    if i > da.len {
        return
    }

    da.arr[i]=n
}

func (da *DynamicArray) Pushback(n int) {
    if da.len >= da.cap{
        da.resize()
    }
    
    da.arr[da.len]=n
    da.len++
}

func (da *DynamicArray) Popback() int {
    da.len--
    last := da.arr[da.len]
    da.arr[da.len]=0
    return last
}

func (da *DynamicArray) resize() {
     da.cap *= 2
     newArr := make([]int, da.cap)
     
     for i := range da.arr{
        newArr[i]=da.arr[i]
     }

     da.arr = newArr
}

func (da *DynamicArray) GetSize() int {
    return da.len
}

func (da *DynamicArray) GetCapacity() int {
    return da.cap
}
