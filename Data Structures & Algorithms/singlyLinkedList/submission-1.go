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
	head *Node
	tail *Node
	size int
}

func NewLinkedList() *LinkedList {
	return &LinkedList{}
}

func (l *LinkedList) Get(index int) int {
		if index < 0 || index >= l.size {
		return -1
	}

	node := l.head
	
	for i:=0; i<index; i++{
		node = node.next
	}

	return node.val
}

func (l *LinkedList) InsertHead(val int) {
	//newNode -> head -> tail

	newNode := NewNode(val)
	if l.size == 0{
		//first time
		l.head = newNode
		l.tail = newNode
		l.size++
		return
	}

	newNode.next = l.head
	l.head = newNode
	l.size++ 	
}

func (l *LinkedList) InsertTail(val int) {
	//head -> ... -> tail -> newNode
	newNode := NewNode(val)

	if l.tail == nil{
		l.head = newNode
		l.tail = newNode
		l.size++
		return
	}

	l.tail.next = newNode
	l.tail = newNode
	l.size++
}

func (l *LinkedList) Remove(index int) bool {
	if index < 0 || index >= l.size {
		return false
	}
	//remove head
	if index == 0 {
		//head -> next 
		l.head = l.head.next
		l.size--

		if l.size == 0{
			//empty list
			l.tail=nil
		}

		return true
	
	}


	// prev -> idxToRemove
	prev := l.head
	for i:= 0; i<index-1; i++ {
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

	node := l.head

	for  node != nil {
		res = append(res, node.val)
		node = node.next
	}

	return res
}
