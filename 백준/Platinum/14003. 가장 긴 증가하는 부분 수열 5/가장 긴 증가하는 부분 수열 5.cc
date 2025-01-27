#include <bits/stdc++.h>
using namespace std;

int arr[1000002];
int idx_list[1000002];
vector<int> v;
stack<int> s;

int main(){
   ios::sync_with_stdio(0);
   cin.tie(0);

   int n;

   cin >> n;

   for (int i=0;i<n;i++){
      cin >> arr[i];

      if (v.empty() || v.back() < arr[i]){
         v.push_back(arr[i]);
         idx_list[i]=v.size()-1;
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
         idx_list[i]=lo;
      }
   }
   cout << v.size() << '\n';

   int idx=v.size()-1;
   for (int i=n-1;i>=0;i--){
      if (idx_list[i]==idx){
         s.push(arr[i]);
         idx--;
      }
   }
   while (!s.empty()){
      cout << s.top() << ' ';
      s.pop();
   }

}
