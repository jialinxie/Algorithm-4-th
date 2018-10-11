#include <iostream>
#include "BinarySearch.hpp"

int main() {
    std::cout << "Hello, World!" << std::endl;
    BinarySearch *a = new BinarySearch;

    std::vector<int> v = {1,2,3,4,5};
    v.push_back(6);
    v.push_back(7);
    int ret = a->rank(3, v, false);
    printf("ret = %d\n", ret);
    return 0;
}