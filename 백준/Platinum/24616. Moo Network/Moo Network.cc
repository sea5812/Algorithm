#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
typedef long long ll;

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


vector<tuple<ll,ll,ll>> edge;
tuple<ll,ll,ll> coord[100005];
ll n,cnt,x,y;
ll ans;
int main(){

   ios::sync_with_stdio(0);
   cin.tie(0);

   cin >> n;
   for (ll i=0;i<n;i++){
      cin >> x >> y;
      coord[i]={x,y,i+1};
   }
   sort(coord,coord+n);
   for (ll i=0;i<n-1;i++){
      for (ll j=i+1;j<i+100;j++){
         if (j>=n) continue;
         ll dst=((get<0>(coord[j])-get<0>(coord[i]))*(get<0>(coord[j])-get<0>(coord[i]))+(get<1>(coord[j])-get<1>(coord[i]))*(get<1>(coord[j])-get<1>(coord[i])));
         edge.push_back({dst,get<2>(coord[i]),get<2>(coord[j])});
      }
   }

   sort(edge.begin(),edge.end());
   ll s=edge.size();
   for (ll i=0;i<s;i++){
      ll c;
      ll a,b;
      tie(c,a,b)=edge[i];
      if (!is_diff_group(a,b)) continue;
      ans+=c;
      cnt++;
      if (cnt==n-1) break;
   }

   cout << ans;
   
}
   
