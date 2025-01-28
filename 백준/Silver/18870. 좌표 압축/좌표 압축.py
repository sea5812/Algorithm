import sys
input = sys.stdin.readline

n = int(input())
arr=list(map(int,input().split()))

arrr=sorted(list(set(arr)))

dict_num={arrr[i] : i for i in range(len(arrr))}

for i in arr:
    print(dict_num[i], end=' ')