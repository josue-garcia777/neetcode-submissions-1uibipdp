
/*
	Input: weights = [1,5,4,4,2,3], days = 3

we want to put packages on ships and ships can have a fixed capacity
the goal is to choose the capacity for the ship,
so that is theminimun capacity that we need for this ships.

instead of days things of ships

cap: at least max(weights)
right: sum(weights)

can ship -> 8 capacity days=3
[1][5][4][4][2,3] -> req-ships=5
[5,1],[4],[4],[2,3] -> req-ships=4
[1,5], [4,4], [2,3] -> req-ships=3
*/
func shipWithinDays(weights []int, ships int) int {
	left := max(weights)
	right := sum(weights)

	for left < right {
		cap := left + (right-left)/2

		reqships := canShip(weights, cap)
		//5 <= 3 shrink it from right.
		if reqships <= ships {
			right = cap
		} else {
			left = cap + 1
		}
	}

	return left
}

func canShip(weights []int, cap int) int {
	req := 1
	curr := 0

	for _, w := range weights {
		if curr+w > cap {
			req++
			curr = 0
		}
		curr += w
	}

	return req
}

func max(weights []int) int {
	max := 0

	for _, w := range weights {
		if max < w {
			max = w
		}
	}

	return max
}

func sum(weight []int) int {
	total := 0
	for _, w := range weight {
		total += w
	}

	return total
}
