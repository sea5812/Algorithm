#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

vector<int> p(10005,-1);

int find(int x){
   if(p[x] < 0) return x;
   return p[x] = find(p[x]);
}

bool is_diff_group(int u, int v){
   u=find(u); v=find(v);
   if(u==v) return 0;
   if(p[u]>p[v]) swap(u,v);
   p[u]+=p[v];
   p[v]=u;
   return 1;
}

tuple<int,int,int> edge[100005];
int cost[10005];
int n,m,cnt;
ll ans;
int main(){
   ios::sync_with_stdio(0);
   cin.tie(0);

   cin >> n >> m;
   for (int i=1;i<=n;i++){
      cin >> cost[i];
   }
   for (int i=0;i<m;i++){
      int a,b,c;
      cin >> a >> b >> c;
      int cc = c*2+cost[a]+cost[b];
      edge[i]={cc,a,b};
   }
   sort(edge,edge+m);
   for (int i=0;i<m;i++){
      int a,b,c;
      tie(c,a,b)=edge[i];
      if (!is_diff_group(a,b)) continue;
      cnt++;
      ans+=c;
      if (cnt==n-1) break;
   }
   int *min=min_element(cost+1,cost+1+n);
   ans+=*min;
   cout << ans;


}
   