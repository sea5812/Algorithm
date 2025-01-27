#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

vector<int> p(100005,-1);

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


vector<tuple<int,int,int>> edge;
pair<int,int> xx[100005];
pair<int,int> yy[100005];
pair<int,int> zz[100005];
int n,c,cnt,ans;

int main(){

   ios::sync_with_stdio(0);
   cin.tie(0);

   cin >> n;

   for (int i=0;i<n;i++){
      int x,y,z;
      cin >> x >> y >> z;
      xx[i]={x,i+1};
      yy[i]={y,i+1};
      zz[i]={z,i+1};
   }

   sort(xx,xx+n);
   sort(yy,yy+n);
   sort(zz,zz+n);

   for (int i=0;i<n-1;i++){
      edge.push_back({xx[i+1].X-xx[i].X,xx[i+1].Y,xx[i].Y});
      edge.push_back({yy[i+1].X-yy[i].X,yy[i+1].Y,yy[i].Y});
      edge.push_back({zz[i+1].X-zz[i].X,zz[i+1].Y,zz[i].Y});
   }

   sort(edge.begin(),edge.end());

   for (int i=0;i<(n-1)*3;i++){
      int a,b,c;
      tie(c,a,b)=edge[i];
      if (!is_diff_group(a,b)) continue;
      ans+=c;
      cnt++;
      if (cnt==n-1) break;
   }

   cout << ans;
}
   
