#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
int a[100002];
int b[100002];
int arr[100002];
vector<int> v;

int main(){

   ios::sync_with_stdio(0);
   cin.tie(0);

   int n;
   cin >> n;
   for (int i=0;i<n;i++){
      cin >> a[i];
   }

   for (int i=0;i<n;i++){
      cin >> b[i];
   }

   for (int i=0;i<n;i++){
      int k=find(begin(b),end(b),a[i])-begin(b);
      arr[i]=k;
   }

   for (int i=0;i<n;i++){
      cin >> arr[i];

      if (v.empty() || v.back() < arr[i]){
         v.push_back(arr[i]);
      }
      else {
         int lo = 0;
         int hi=v.size()-1;
         while (lo<hi){
            int mid = (lo+hi)/2;
            if(v[mid]<arr[i]) lo=mid+1;
            else hi=mid;
         }
         v[lo]=arr[i];
      }
   }
   cout << v.size();
}
   