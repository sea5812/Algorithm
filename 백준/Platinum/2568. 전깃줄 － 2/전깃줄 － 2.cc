#include <bits/stdc++.h>
using namespace std;

int ans[1000002];
int idx_list[1000002];
vector<pair<int,int>> vv;
vector<int> v;
stack<pair<int,int>> s;

int main(){
   ios::sync_with_stdio(0);
   cin.tie(0);

   int n,x,y;
   cin >> n;

   for (int i=0;i<n;i++){
      cin >> x >> y;
      vv.push_back({x,y});
   }
   sort(vv.begin(),vv.end());

   for (int i=0;i<n;i++){
      if (v.empty() || v.back() < vv[i].second){
         v.push_back(vv[i].second);
         idx_list[i]=v.size()-1;
      }
      else {
         int lo = 0;
         int hi=v.size()-1;
         while (lo<hi){
            int mid = (lo+hi)/2;
            if(v[mid]<vv[i].second) lo=mid+1;
            else hi=mid;
         }
         v[lo]=vv[i].second;
         idx_list[i]=lo;
      }
   }
   cout << n-v.size() << '\n';

   int idx=v.size()-1;
   for (int i=n-1;i>=0;i--){
      if (idx_list[i]==idx) idx--;
      else s.push(vv[i]);
   }

   int i=0;
   while (!s.empty()){
      ans[i]=s.top().first;
      s.pop();
      i++;
   }
   sort(ans,ans+i);
   for (int j=0;j<i;j++){
      cout << ans[j] << '\n';
   }
}
