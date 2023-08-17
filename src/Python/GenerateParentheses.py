def generateParenthesis(n):
    if n == 0:
        return []

    dp = [[] for _ in range(n + 1)]
    dp[0].append("")

    for i in range(1, n + 1):
        for j in range(i):
            for left in dp[j]:
                for right in dp[i - 1 - j]:
                    dp[i].append("(" + left + ")" + right)

    return dp[n]

n = 3
result = generateParenthesis(n)
print(result)