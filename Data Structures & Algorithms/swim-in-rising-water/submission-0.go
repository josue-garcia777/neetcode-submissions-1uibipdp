type Path struct {
    r,c, cost int
}

func newPath(r,c, cost int) Path {
    return Path{r,c,cost}
}

type MinHeap []Path

func newMinHeap() *MinHeap{
    h := &MinHeap{}
    heap.Init(h)
    return h
}

func (h MinHeap) Swap(a,b int){
    h[a], h[b] = h[b], h[a]
}

func (h MinHeap) Less(a,b int) bool{
    return h[a].cost < h[b].cost
}

func (h MinHeap) Len() int{
    return len(h)
}

func (h *MinHeap) Push(x any){
    *h = append(*h, x.(Path))
}
func (h *MinHeap) Pop() any {
    old := *h
    n := len(old)
    item := old[n-1]
    *h = old[:n-1]
    return item
}
/*
Dijstra 
*/
func swimInWater(grid [][]int) int {
    row := len(grid)
    col := len(grid[0])
    
    visited := make([][]bool, row)

    for i := 0; i < row; i++ {
        visited[i] = make([]bool, col)
    }

    bestcost := make([][]int, row)
    for i := 0; i < row; i++ {
        bestcost[i] = make([]int, col)
        for j := 0; j < col; j++ {
            bestcost[i][j] = math.MaxInt
        }
    }


    minheap := newMinHeap()
    
    heap.Push(minheap, newPath(0,0,grid[0][0]))//r,c,cost
    bestcost[0][0]=grid[0][0]

    dirs := [][]int{ {-1,0}, {1,0}, {0,-1}, {0,1} };

    for minheap.Len() > 0 {
        curr := heap.Pop(minheap).(Path)
        
        if visited[curr.r][curr.c]{
            continue;
        }

        visited[curr.r][curr.c] = true

        if (curr.r == row-1 && curr.c == col-1){
            return curr.cost
        }
        
        for _,dir := range dirs {
            r, c := curr.r + dir[0], curr.c + dir[1]
            if r<0 || c<0 || r >= row || c >= col {
                continue
            }
            if visited[r][c]{
                continue
            }
            nextcost := grid[r][c]
            newcost := max(curr.cost, nextcost)
            
            if newcost < bestcost[r][c]{
                bestcost[r][c]=newcost
                heap.Push(minheap, newPath(r,c, newcost))
            }
            
        } 
    }

    return -1
}

  func max(a,b int) int {
        if a>b {
            return a
        }
        return b
    }  