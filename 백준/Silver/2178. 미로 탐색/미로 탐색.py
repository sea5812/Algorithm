import sys
sys.setrecursionlimit(10**6)
from collections import deque
input = sys.stdin.readline

def is_on_board(point, N, M):
    return 0 <= point[0] < N and 0 <= point[1] < M

def bfs(board, start, target):
    M, N = len(board[0]), len(board)
    vst = set([start])
    q = deque([(start, 0)])

    while q:
        curr, dist = q.popleft()
        if curr == target:
            return dist+1
        for dx, dy in [(1,0), (-1,0), (0,1), (0,-1)]:
            nxt = (curr[0]+dy, curr[1]+dx)
            if is_on_board(nxt, N, M) and \
                board[nxt[0]][nxt[1]] == 1 and nxt not in vst:
                q.append((nxt,dist+1))
                vst.add(nxt)
    return

N, M = map(int,input().split())
board=[]
for _ in range(N):
    board.append(list(map(int,input().strip())))

print(bfs(board, (0,0), (N-1,M-1)))