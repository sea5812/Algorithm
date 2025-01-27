#include <bits/stdc++.h>
using namespace std;

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


tuple<int,int,int> edge[100005];
int n,m,q;
int main(){
   ios::sync_with_stdio(0);
   cin.tie(0);

   cin >> n >> m;
   for (int i=0;i<m;i++){
      int a,b,c;
      cin >> a >> b >> c;
      edge[i]={c,a,b};
   }

   sort(edge,edge+m);

   cin >> q;
   while(q--){
      int x,y;
      int cnt=0,ans=0;
      for(int i=0;i<1005;i++){
         p[i]=-1;
      }
      cin >> x >> y;
      is_diff_group(x,y);
      for (int i=0;i<m;i++){
         int a,b,c;
         tie(c,a,b)=edge[i];
         if (!is_diff_group(a,b)) continue;
         ans+=c;
         cnt++;
         if (cnt==n-2) break;
      }
      cout << ans << '\n';
      }


}
   
