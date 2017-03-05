#include <stdio.h>
#include <string.h>

#define N 100
#define M 10000

char a[N + 2][N + 2];
int vdir[][2] =
{
    {0, -1}, {1, -1}, {1, 0}, {1, 1},
    {0, 1}, {-1, 1}, {-1, 0}, {-1, -1},
};
char words[M][2*N];
int next[M][2*N];
int x, y, m;

void get_next(int *next, char *s)
{
    int i = 0, j = 1;

    next[0] = -1;
    while (s[j] != '\0')
    {
        if (s[i] == s[j])
            next[j] = next[i];
        else
        {
            next[j] = i;
            while (next[i] != -1 && s[next[i]] != s[j])
                i = next[i];
        }
        ++i, ++j;
    }
}

int kmp_search(int i, int j, int k, char *s, int *next)
{
    int si = 0;
    while (a[i][j] != '\0')
    {
        if (si == -1 || a[i][j] == s[si])
        {
            i += vdir[k][1], j += vdir[k][0];
            ++si;
            if (s[si] == '\0')
                break;
        }
        else
            si = next[si];
    }
    return s[si] == '\0';
}

void solve(void)
{
    int a = y, b = 1, i = 0, j, k;

    while (i < 4)
    {
        for (j = 0; j < m; ++j)
        {
            if (words[j][0] != '\0')
            {
                for (k = 0; k < 8; ++k)
                    if (kmp_search(a, b, k, words[j], next[j]))
                    {
                        puts(words[j]);
                        words[j][0] = '\0';
                        break;
                    }
            }
        }

        a += vdir[i<<1][1], b += vdir[i<<1][0];
        if (a <= 0 || a > y || b <= 0 || b > x)
        {
            a -= vdir[i<<1][1], b -= vdir[i<<1][0];
            ++i;
            a += vdir[i<<1][1], b += vdir[i<<1][0];
        }
    }
}

int main(void)
{
    while (scanf("%d%d", &x, &y) == 2)
    {
        int i, j;

        for (i = 0; i < y + 1; ++i)
            a[i][0] = a[i][x+1] = 0;
        for (j = 0; j < x + 1; ++j)
            a[0][j] = a[y+1][j] = 0;
        for (i = 1; i <= y; ++i)
            for (j = 1; j <= x; ++j)
                scanf(" %c", &a[i][j]);
        scanf("%d", &m);
        for (i = 0; i < m; ++i)
        {
            scanf("%s", words[i]);
            get_next(next[i], words[i]);
        }
        solve();
    }
    return 0;
}
/* - cc: run+='<in' */
