class Solution:
    #Backtracking
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        res, quad = [],[]
        nums.sort()
        k=4
        n = len(nums)

        def ksum(k,startidx,target):
            if (k != 2):
                #start backtrack
                for i in range(startidx, n-k+1):
                    if i > startidx and nums[i] == nums[i-1]:
                        continue

                    quad.append(nums[i])
                    ksum(k-1, i+1, target-nums[i])
                    quad.pop()
                return
            else:
                #Two Sum
                l = startidx
                r = n -1

                while l<r:
                    currsum = nums[l] + nums[r]
                    if currsum < target:
                        l+=1
                    elif currsum > target:
                        r-=1
                    else:
                        #move 1 does not matter who but checks next are not same
                        res.append(quad + [nums[l], nums[r]])

                        l+=1

                        while l<r and nums[l] == nums[l-1]:
                            l+=1 

        ksum(k,0,target)

        return res             
        