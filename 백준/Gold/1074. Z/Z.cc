#include <bits/stdc++.h>
using namespace std;

int func(int n, int r, int c) {
    if (n == 0)
        return 0;
    if (r < pow(2, n - 1) && c < pow(2, n - 1))
        return func(n - 1, r, c);
    if (r < pow(2, n - 1) && c >= pow(2, n - 1))
        return pow(2, 2 * (n - 1)) + func(n - 1, r, c - pow(2, n - 1));
    if (r >= pow(2, n - 1) && c < pow(2, n - 1))
        return 2 * pow(2, 2 * (n - 1)) + func(n - 1, r - pow(2, n - 1), c);
    if (r >= pow(2, n - 1) && c >= pow(2, n - 1))
        return 3 * pow(2, 2 * (n - 1)) + func(n - 1, r - pow(2, n - 1), c - pow(2, n - 1));
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, r, c;

    cin >> n >> r >> c;
    cout << func(n, r, c);
}