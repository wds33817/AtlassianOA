//第一题 easy中的easy sort后 按题目要求减下就是结果

//第二题炒股票原题 多加了个条件，整个数组递减或者平着来 return -1

//第三题anagram


//第四题用最大堆来做 easy

//第五题
package Atlassian;

public class Q5 {
    /*
            A sequence of numbers is said to be good if it satisfies the
            following two conditions:
            1. All elements in the sequence are unique.
            2. If the minimum element in the sequence is a, and the maximum
            element in the sequence is b, then all numbers in the range
            [a,b] are present in the sequence.

            For example, (4,2,5,1,3) is a good sequence, while (2,2,1) or
            (3,7) are not.

            A subsequence of an array arr is a sequence that can be derived from
            the array arr by deleting some or no elements without changing
            the order of the remaining elements. Given an array of n integers,
            find the number of different good subsequences. Two subsequences
            are considered different if they include at least one different index.
            For example, for the sequence (2,2,1), both (2,1) formed by indice
            1 and 2 and (2,1) formed by indices 0 and 2 are considered different
            subsequences.


            Examples:
            Consider the array arr = [13, 11, 4, 12, 5, 4]. We can form the
            following good subsequences:
            length1 : [13],[11],[4],[12],[5],[4]
            length2 : [13,12],[11,12],[4,5],[5,4]
            length3 : [13,11,12]

            the answer is 6 + 4 + 1 = 11




            STDIN     FUNCTION
            -----     --------
            5    ->   arr[]  size  n=5
            3    ->   arr[] = [3, 1, 1, 2, 8]
            1
            1
            2
            8

            Sample Output
            -------------
            10

            Explanation
            Given n = 5, arr = [3, 1, 1, 2, 8]. We can form the following
            good subsequences:
            length 1: [3],[1],[1],[2],[8]
            length 2: [3,2],[1,2],[1,2]
            length 3: [3,1,2],[3,1,2]
            Thus, the answer is 5 + 3 + 2 = 10

     */
    public static long countGoodSubsequences(int[] arr) {
        
    }
    public static void main(String[] args) {

    }
}




// Editorial:

We try to find the number of subsequences with each element having a fixed frequency and add them all.
First let's find the frequencies of all the elements and keep them in sorted order. Let it be f1, f2, .., fr.
No of subsequences with each element having frequency k will be- ( 1+C(f1, k) ) ( 1+C(f2, k) ) ...( 1+C(fr, k) ) -1 where C(n, r) is the combinatorial function.
Now if we iterate k from 1 to n, it will be an O(n2) solution. Now we just need to iterate over elements which are greater than k in the frequency array which can easily be done using binary search.
Now each fi 


const int M = 1e9 + 7;
int expo(int a, int b, int mod){
    int ans = 1;
    while(b){
        if(b&1)
            ans = (ans * 1LL * a)%mod;
        a = (a * 1LL * a)%mod;
        b >>= 1;
    }
    return ans;
}
const int N=500005;
int f[N], inv[N];
void preprocess()
{
    f[0] = 1;
    for(int i = 1; i < N; i++)
        f[i] = (i* 1LL *f[i-1])%M;
    inv[N-1] = expo(f[N-1],M-2,M);
    for(int i = N-2; i >= 0; i--)
        inv[i] = ((i+1) * 1LL * inv[i+1])%M;
}
int C(int n,int r){
	if(r>n)
		return 0;
    return (((f[n] * 1LL * inv[r])%M) * 1LL * inv[n-r])%M;
}
int Solution::solve(vector<int> &A) {
    preprocess();
    map<int,int>m;
    for(auto i:A)
        m[i]++;
    vector<int>v;
    for(auto i:m)
        v.push_back(i.second);
    sort(v.begin(),v.end());
    int ans=0;
    for(int i=1;i<=v.back();i++){
        int res = 1;
        for(auto it=lower_bound(v.begin(),v.end(),i); it != v.end(); it++)
            res=(res * 1LL * (1+C(*it,i)))%M;
        ans=(ans+res-1)%M;
    }
    return ans;
}







// Fast:

#include<bits/stdc++.h>
#include<ext/pb_ds/assoc_container.hpp>
#include<ext/pb_ds/tree_policy.hpp>
#define ll long long
#define M 1000000007
#define sz(a) (ll)a.size()
#define pll pair<ll,ll>
#define rep(i,a,b) for(ll i=(ll)a;i<(ll)b;i++)
#define sep(i,a,b) for(ll i=(ll)a;i>=(ll)b;i--)
#define mll map<ll,ll>
#define vl vector<ll>
#define pb push_back
#define lb lower_bound
#define ub upper_bound
#define all(a) a.begin(),a.end()
#define F first
#define S second
using namespace __gnu_pbds;
using namespace std;
template <typename T>
using ordered_set = tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;
ll expo(ll a,ll b,ll mod)
{
    ll ans=1;
    while(b)
    {
        if(b&1)
            ans=(ans*a)%mod;
        a=(a*a)%mod;
        b>>=1;
    }
    return ans;
}
const ll N=200005;
ll f[N],inv[N];
void preprocess()
{
    f[0]=1;
    rep(i,1,N)
        f[i]=(i*f[i-1])%M;
    inv[N-1]=expo(f[N-1],M-2,M);
    sep(i,N-2,0)
        inv[i]=((i+1)*inv[i+1])%M;
}
ll C(ll n,ll r)
{
    return (((f[n]*inv[r])%M)*inv[n-r])%M;
}
int Solution::solve(vector<int> &a) {
    preprocess();
    sort(all(a));
    int n=sz(a);
    vl v;
    ll i=0;
    while(i<n)
    {
        ll j=i;
        while(j<n and a[j]==a[i])
            j++;
        v.pb(j-i);
        i=j;
    }
    sort(all(v));
    ll ans=0;
    rep(i,1,n+1)
    {
        ll r=1;
        for(auto it=lb(all(v),i);it!=v.end();it++)
            r=(r*(1+C(*it,i)))%M;
        ans=(ans+(r-1+M)%M)%M;
    }
    return ans;
}


//Lightweight:

#include<ext/pb_ds/assoc_container.hpp>
#include<ext/pb_ds/tree_policy.hpp>
#define ll long long
#define M 1000000007
#define sz(a) (ll)a.size()
#define pll pair<ll,ll>
#define rep(i,a,b) for(ll i=(ll)a;i<(ll)b;i++)
#define sep(i,a,b) for(ll i=(ll)a;i>=(ll)b;i--)
#define mll map<ll,ll>
#define vl vector<ll>
#define pb push_back
#define lb lower_bound
#define ub upper_bound
#define all(a) a.begin(),a.end()
#define F first
#define S second
using namespace __gnu_pbds;
using namespace std;
template <typename T>
using ordered_set = tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;
ll expo(ll a,ll b,ll mod)
{
    ll ans=1;
    while(b)
    {
        if(b&1)
            ans=(ans*a)%mod;
        a=(a*a)%mod;
        b>>=1;
    }
    return ans;
}
const ll N=200005;
ll f[N],inv[N];
void preprocess()
{
    f[0]=1;
    rep(i,1,N)
        f[i]=(i*f[i-1])%M;
    inv[N-1]=expo(f[N-1],M-2,M);
    sep(i,N-2,0)
        inv[i]=((i+1)*inv[i+1])%M;
}
ll C(ll n,ll r)
{
    return (((f[n]*inv[r])%M)*inv[n-r])%M;
}

int Solution::solve(vector<int> &a) {
    preprocess();
    sort(all(a));
    int n=sz(a);
    vl v;
    ll i=0;
    while(i<n)
    {
        ll j=i;
        while(j<n and a[j]==a[i])
            j++;
        v.pb(j-i);
        i=j;
    }
    sort(all(v));
    ll ans=0;
    rep(i,1,n+1)
    {
        ll r=1;
        for(auto it=lb(all(v),i);it!=v.end();it++)
            r=(r*(1+C(*it,i)))%M;
        ans=(ans+(r-1+M)%M)%M;
    }
    return ans;
}


