#include <iostream>
#include "Bag.hpp"

using namespace std;
int main() {
    Bag<int> b;
    b.add(1);
    b.add(2);

    for(auto i : b)
        cout << i << endl;

    return 0;
}