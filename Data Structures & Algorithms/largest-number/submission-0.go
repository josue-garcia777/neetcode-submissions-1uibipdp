 /*
    The idea actually is treat numbers as String then use a comparator betwen curr and prev 
    and prev + curr and see which one is actually bigger

    */
func largestNumber(nums []int) string {
    arr := make([]string, 0, len(nums))

    for _,n := range nums{
        arr = append(arr, strconv.Itoa(n))
    }

    sort.Slice(arr, func(i,j int) bool {
        a := arr[i] + arr[j]
        b := arr[j] + arr[i]

        return a > b
    })

    if arr[0] == "0" {
        return "0"
    }
    
    sb := strings.Builder{}

    for _, s := range arr{
        sb.WriteString(s)
    }

    return sb.String()

}