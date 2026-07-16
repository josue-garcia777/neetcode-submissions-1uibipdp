/*
    have 2 fixed sum? then do 2 sum JAJAJAJA
    cuadruples has to be unique.

    generic solution using sum + k
    the idea is to use recursion

    k=4
    .
    k=3
    .
    k=2
    two sum base case

    as we pick one value target will be substracted from picked values
*/
func fourSum(nums []int, target int) [][]int {
    n := len(nums)
    k := 4
    sort.Ints(nums)

    res := make([][]int, 0)
    
    quad := make([]int, 0, 4) //currquadruple

    var ksum func(k, startIdx, target int)

    ksum = func(k, startIdx, target int){
        if k != 2 { 
                //from start to end -k we do this cause we want at 
                //least 3 values to came after to form a cuadriplet
            for i:= startIdx; i< n - k +1; i++{
                if i > startIdx && nums[i] == nums[i-1]{ //not the start and same as prev
                    continue
                }
                quad = append(quad, nums[i])
                ksum(k-1, i+1, target - nums[i])
                //backtrack
                quad = quad[:len(quad)-1]//pop
            }

            return
        }

        //two sum
        l := startIdx
        r := n-1

        for l<r{
            if nums[l]+nums[r] > target{
                r--;
            }else if nums[l]+nums[r] < target{
                l++;
            }else{
                twosum := []int{nums[l], nums[r]}
                twosum = append(twosum, quad...) //apend 2 sum
                
                //apend to result
                res = append(res, twosum)
                l++
        
                for l<r && nums[l] == nums[l-1]{
                    l++
                }
            }
        }
    }

    ksum(k, 0, target)

    return res
}
