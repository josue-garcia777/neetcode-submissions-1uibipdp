type Node struct {
	val int
	next *Node
}

func NewNode(val int) *Node{
	newNode := &Node{}
	newNode.val = val
	return newNode
}

type LinkedList struct {
	dummy *Node
	tail *Node
	size int
}

func NewLinkedList() *LinkedList {
	dummy := &Node{}

	return &LinkedList{
		dummy: dummy,
		tail: dummy,
	}
}

func (l *LinkedList) Get(index int) int {
	if index < 0 || index >= l.size {
		return -1
	}

	curr := l.dummy.next
	
	for i:=0; i<index; i++{
		curr = curr.next
	}

	return curr.val
}

func (l *LinkedList) InsertHead(val int) {
	//newNode -> dummy -> tail
	newNode := NewNode(val)

	newNode.next = l.dummy.next
	l.dummy.next = newNode
	
	// The list was empty, new node is also the tail.
	if l.size == 0 {
		l.tail = newNode
	}

	l.size++ 	
}

func (l *LinkedList) InsertTail(val int) {
	//dummy -> ... -> tail -> newNode
	newNode := NewNode(val)

	l.tail.next = newNode
	l.tail = newNode
	l.size++
}

func (l *LinkedList) Remove(index int) bool {
	if index < 0 || index >= l.size {
		return false
	}

	// prev -> idxToRemove
	prev := l.dummy

	for i:= 0; i<index; i++ {
		prev = prev.next
	}

	remove := prev.next
	prev.next = remove.next //skip

	if remove == l.tail{
		// prev -> tail(removing tail) 
		l.tail = prev
	}

	l.size--

	return true
}

func (l *LinkedList) GetValues() []int {
	res := make([]int, 0, l.size)

	node := l.dummy.next

	for  node != nil {
		res = append(res, node.val)
		node = node.next
	}

	return res
}
