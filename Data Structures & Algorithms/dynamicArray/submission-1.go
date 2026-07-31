type DynamicArray struct {
    lastIdx, capacity int
    array []int 
}

func NewDynamicArray(capacity int) *DynamicArray {
    return &DynamicArray{lastIdx:0, capacity: capacity, array: make([]int, capacity)}
}

func (da *DynamicArray) Get(i int) int {
    if i > da.lastIdx{
        return -1
    }

    return da.array[i]
}

func (da *DynamicArray) Set(i int, n int) {
    if i > da.lastIdx {
        return
    }

    da.array[i]=n
}

func (da *DynamicArray) Pushback(n int) {

    if da.lastIdx >= da.capacity{
        da.resize()
    }
    
    da.array[da.lastIdx]=n
    da.lastIdx++
}

func (da *DynamicArray) Popback() int {
    da.lastIdx--
    last := da.array[da.lastIdx]
    da.array[da.lastIdx]=0
    return last
}

func (da *DynamicArray) resize() {
     da.capacity *= 2
     newArr := make([]int, da.capacity)
     
     for i := range da.array{
        newArr[i]=da.array[i]
     }

     da.array = newArr
}

func (da *DynamicArray) GetSize() int {
    return da.lastIdx
}

func (da *DynamicArray) GetCapacity() int {
    return da.capacity
}
