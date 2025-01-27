#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

vector<int> p(1005,-1);

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

vector<int> adj[1005];
void dfs(int cur, int prev){
   for (auto nxt:adj[cur]){
      if(nxt==prev) continue;
      dfs(nxt, cur);
   }
   if (prev!=0) cout << prev << " " << cur << '\n';
}

vector<tuple<int,int,int>> edge;
int chef[1005][3];
int n;
int main(){

   ios::sync_with_stdio(0);
   cin.tie(0);

   cin >> n;
   for (int i=1;i<=n;i++){
      int p,c;
      cin >> p >> c;
      chef[i][0]=i;
      chef[i][1]=p;
      chef[i][2]=c;
   }

   for (int i=1;i<n;i++){
      for (int j=i+1;j<=n;j++){
         int rating = (chef[j][2]+chef[i][2])/abs(chef[j][1]-chef[i][1]);
         edge.push_back({rating,chef[i][0],chef[j][0]});
      }
   }

   sort(edge.begin(),edge.end(),greater<tuple<int,int,int>>());

   int cnt=0;
   long long ans=0;
   int s=edge.size();
   for (int i=0;i<s;i++){
      int a,b,c;
      tie(c,a,b)=edge[i];
      if (!is_diff_group(a,b)) continue;
      ans+=c;
      cnt++;
      adj[a].push_back(b);
      adj[b].push_back(a);
      if (cnt==n-1) break;
      }
   cout << ans << '\n';
   dfs(1,0);
}
   