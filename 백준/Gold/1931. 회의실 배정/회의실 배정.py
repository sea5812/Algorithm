import sys
input = sys.stdin.readline

N=int(input())
arr=[]
for i in range(N):
    asdf=list(map(int,input().split()))
    arr.append(asdf)
arr.sort(key=lambda x:(x[1],x[0])) #두 번째 값 기준 오름차순 정렬

cnt=0
a=0
for i in range(N):
    if arr[i][0]>=a:
        cnt+=1
        a=arr[i][1]
print(cnt)