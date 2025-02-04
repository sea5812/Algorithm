#include <bits/stdc++.h>
using namespace std;

int main(){
   ios::sync_with_stdio(0);
   cin.tie(0);

   int t,k;
   cin >> t;
   while (t--){
      multiset<int> ms;
      cin >> k;
      while (k--){
         char q; int n;
         cin >> q >> n;
         if (q=='I'){
            ms.insert(n);
         }
         else {
            if (!ms.empty()){
               if (n==1) ms.erase(prev(ms.end()));
               else ms.erase(ms.begin());
            }
            else continue;
         }
      }
      if (ms.empty()) cout << "EMPTY" << '\n';
      else cout << *prev(ms.end()) << ' ' << *(ms.begin()) << '\n';
   }
}