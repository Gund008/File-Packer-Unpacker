#include<iostream>
#include<algorithm>

using namespace std;
int main()
{
    int arr[]={3,5,1,2,4};

    std::sort(std::begin(arr),std::end(arr));

    //Traversalfor(int i=0;i<5;i++)
    for(int i:arr)
    {
        std::cout<<i<<" ";
    }
    return 0;
}


