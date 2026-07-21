type RandomizedSet struct {
    store map[int]int
	list []int
}

func Constructor() RandomizedSet {
    return RandomizedSet{make(map[int]int), make([]int,0)}
}

func (t *RandomizedSet) Insert(val int) bool {
    if _, ok := t.store[val]; ok{
		return false
	}

	t.store[val]=len(t.list)
	t.list = append(t.list, val)

	return true
}

func (this *RandomizedSet) Remove(val int) bool {
    if _, ok := this.store[val]; !ok{
		return false;
	}
	//get id to remove. swap it for the last value in the list and then remove it from the map, update new mapping in the map
	id := this.store[val]
	last := this.list[len(this.list)-1]
	this.list[id]=last
	this.store[last]=id
	//remove last and from map
	this.list = this.list[:len(this.list)-1]
	delete(this.store, val)
	return true
}

func (this *RandomizedSet) GetRandom() int {
    return this.list[rand.Intn(len(this.list))]
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */
 