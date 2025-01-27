#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second

const int INF=1e9+10;
vector<pair<int,int>> adj[505];
vector<int> sw[505];


int main(){

   ios::sync_with_stdio(0);
   cin.tie(0);
   

   while (true){
      int n,m;
      cin >> n >> m;
      if (n==0 && m==0) break;
      int st,en;
      cin >> st >> en;
      for (int i=0; i<505;i++){
         adj[i].clear();
         sw[i].clear();
      } 
      while (m--){
      int u,v,w;
      cin >> u >> v >> w;
      adj[u].push_back({w,v});
      }

      int d[505]={0,};
      bool vis[505]={0,};
      fill(d,d+n,INF);
      priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
      d[st]=0;
      pq.push({d[st],st});
      while (!pq.empty()){
         auto cur = pq.top(); pq.pop();
         if (d[cur.Y]!=cur.X) continue;
         for (auto nxt : adj[cur.Y]){
            if(d[nxt.Y]>d[cur.Y]+nxt.X){
               d[nxt.Y]=d[cur.Y]+nxt.X;
               pq.push({d[nxt.Y],nxt.Y});
               sw[nxt.Y].clear();
               sw[nxt.Y].push_back(cur.Y);
            }
            else if(d[nxt.Y]==d[cur.Y]+nxt.X){
               sw[nxt.Y].push_back(cur.Y);
            }
         }
      }

      queue<int> Q;
      Q.push(en);
      while(!Q.empty()){
         int cur = Q.front(); Q.pop();
         if (vis[cur]==true) continue; 
         vis[cur]=true;
         for (int i=0;i<sw[cur].size();i++){
            int x=sw[cur][i];
            for (int j=0;j<adj[x].size();j++){
               if (adj[x][j].Y==cur) adj[x][j].X=-1;
            }
            Q.push(x);
         }
      }

      fill(d,d+n,INF);
      d[st]=0;
      pq.push({d[st],st});
      while (!pq.empty()){
         auto cur = pq.top(); pq.pop();
         if (d[cur.Y]!=cur.X) continue;
         for (auto nxt : adj[cur.Y]){
            if(nxt.X==-1) continue;
            if(d[nxt.Y]<=d[cur.Y]+nxt.X) continue;
            d[nxt.Y]=d[cur.Y]+nxt.X;
            pq.push({d[nxt.Y],nxt.Y});
         }
      }
      if (d[en]==INF) cout << -1 << '\n';
      else cout << d[en] << '\n';
   }
}

