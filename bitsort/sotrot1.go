package main

import (
	"fmt"
	"math/rand"
	"strconv"
	"time"
	"sort"
)

const BITPERINT = strconv.IntSize // int位数
const N = 10000000                // 10 000 000
const SHIFT = 6                   //
const MASK = uint64(0x3F)

var a [N/BITPERINT + 1]uint64         // 储存的位向量

// 将i存入到位向量中
func set(i uint64) {
	a[i>>SHIFT] |= (1 << (i & MASK))
}

// 将位向量中表示i的位清零
func clear(i uint64) {
	a[i>>SHIFT] &= ^(1 << (i & MASK))
}

// 判断i是否已存储
func test(i uint64) bool {
	if (a[i>>SHIFT] & (1 << (i & MASK))) != 0 {
		return true
	}
	return false
}

// 将输入文件存入位向量
func sortbit(in []int){
	for _, v := range in{
		set(uint64(v))
	}
}

// 排序
func Sort(in []int, out []int){
	sortbit(in)
	for i, j:=0,0; i<N; i++{
		if test(uint64(i)){
			out[j] = i
			j++
		}
	}
}


func main() {

	// 生成1 000 000个不重复整数的输入文件
	millionFile := rand.Perm(1000000)
	outFile := make([]int, 1000000)

	// fmt.Printf("millionFile \n")
	// for i:=0; i<10; i++{
	// 	fmt.Println(millionFile[i])
	// }

	// 
	start := time.Now()
	Sort(millionFile, outFile)
	used := time.Since(start)
	fmt.Println(used)


	start1 := time.Now()
	sort.Ints(millionFile)
	used = time.Since(start1)
	fmt.Println(used)

	// fmt.Printf("millionFile \n")
	// for i:=0; i<10; i++{
	// 	fmt.Println(millionFile[i])
	// }

	// 
	// fmt.Printf("outFile \n")
	// for i:=0; i<10; i++{
	// 	fmt.Println(outFile[i])
	// }
	

	// 
	// showTen()
}
