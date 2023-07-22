def my_pow(x, n):
    if n == 0:
        return 1
    if n < 0:
        x = 1 / x
        n = -n
    if n % 2 == 0:
        return my_pow(x * x, n // 2)
    else:
        return x * my_pow(x * x, n // 2)

# 测试
base = float(input("请输入底数 x："))
exponent = int(input("请输入指数 n："))
print(f"{base} 的 {exponent} 次方结果为：{my_pow(base, exponent)}")
