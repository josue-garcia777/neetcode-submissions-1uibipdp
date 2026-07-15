/*
    total sum = include on expand.
    once a total sum is >= target then shrink - cause we want to get the min val
    keep the min window size
*/
func minSubArrayLen(target int, nums []int) int {
    minwindow := math.MaxInt
    totalsum := 0
    l := 0

    for r:=0; r<len(nums); r++ {
        totalsum += nums[r]
        
        for totalsum >= target{
            minwindow = min(minwindow, (r-l)+1)
            totalsum -= nums[l]
            l++
        }
    }

    if minwindow == math.MaxInt{
        return 0
    }

    return minwindow
}

func min(a,b int)int{
    if a < b{
        return a
    }

    return b
}