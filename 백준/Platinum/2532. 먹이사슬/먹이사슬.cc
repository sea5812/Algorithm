#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
pair<int,int> arr[500002];
vector<int> v;
int n,p,r,l;

bool compare(const pair<int, int> &a, const pair<int, int> &b)
{
    if (a.X == b.X)
    {
        return a.Y > b.Y;
    }
    return a.X < b.X;
}
int main(){

   
   cin >> n;
   for (int i=0;i<n;i++){
      cin >> p >> arr[i].X >> arr[i].Y;
   }

   sort(arr,arr+n,compare);

   for (int i=0;i<n;i++){
      int x=-arr[i].Y;
      if(i>0 && arr[i].X==arr[i-1].X&&arr[i].Y==arr[i-1].Y) continue;
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
   