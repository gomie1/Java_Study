import sys

N, M = map(int, input().split())
city = [list(map(int, input().split())) for _ in range(N)]
home, chicken = [], []
res = sys.maxsize

# 집과 치킨집의 좌표를 모음
for r in range(0, N):
    for c in range(0, N):
        if city[r][c] == 1:
            home.append((r, c))
        elif city[r][c] == 2:
            chicken.append((r, c))

visited = [False for _ in range(len(chicken))]


def backtraking(level, idx):
    global res

    # 종료 조건
    if level == M:  # 최대 M개의 치킨집을 고른 경우
        sub_sum = 0
        # 각 집과 선택한 치킨집들 사이의 거리를 구하고,
        # 최소 거리인 경우들로 도시의 치킨 거리를 계산
        for i in home:
            r1, c1 = i
            dist = sys.maxsize
            for j in range(len(visited)):
                if visited[j]:
                    r2, c2 = chicken[j]
                    dist = min(dist, abs(r1 - r2) + abs(c1 - c2))
            sub_sum += dist
        res = min(res, sub_sum)

        return

    for i in range(idx, len(chicken)):
        if not visited[i]:
            visited[i] = True
            backtraking(level+1, i+1)
            visited[i] = False


backtraking(0, 0)
print(res)
