#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
vector<pair<int,int>> arr;
vector<int> v;

int main(){

   
   int n,r,c,l,xx,yy;
   cin >> r >> c;

   cin >> n;
   for (int i=0;i<n;i++){
      cin >> xx >> yy;
      if (xx>r || yy>c) continue;
      arr.push_back({xx,yy});
   }
   l=arr.size();
   sort(arr.begin(),arr.end());

   for (int i=0;i<l;i++){
      int x=arr[i].Y;
      if(v.empty() || v.back() <= x){
         v.push_back(x);
      }
      else {
         int lo=0;
         int hi=v.size();
         while (lo<hi){
            int mid=(lo+hi)/2;
            if(v[mid]<=x) lo=mid+1;
            else hi=mid;
         }
         v[hi]=x;
      }
   }

   cout << v.size();


}
   