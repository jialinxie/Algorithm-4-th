#include <ostream>
#include <vector>
#include <iostream>

using namespace std;


class BHeap{
private:
    vector<int> heap;
    int l(int par);
    int r(int par);
    int par(int child);
    void heapifyUp(int index);
    void heapifyDown(int index);
    int Size();
public:
    void show();
    void Insert(int ele);
    int ExtractMin();
    void deleteMin();
};

void BHeap::deleteMin() {
    if(heap.size() == 0) {
        cout << "heap is null!" << endl;
        return;
    }

    heap[0] = heap[heap.size() - 1];
    heap.pop_back();
    heapifyDown(0);
}

int BHeap::ExtractMin() {
    if(heap.size() == 0){
        cout << "heap is null" << endl;
        return -1;
    }
    return heap[0];
}

void BHeap::heapifyDown(int index) {
    int child = l(index);
    int child1 = r(index);

    if(heap[child] < heap[child1])
        child = child1;

    if(index >= 0 && child1 >= 0 && heap[index] < heap[child]){
        int temp = heap[index];
        heap[index] = heap[child];
        heap[child] = temp;
        heapifyDown(child);
    }
}

void BHeap::heapifyUp(int index) {
    if(index >= 0 && par(index) >= 0 && heap[index] < heap[par(index)]){
        int temp = heap[index];
        heap[index] = heap[par(index)];
        heap[par(index)] = temp;
        heapifyUp(par(index));
    }
}

void BHeap::Insert(int ele) {
    heap.push_back(ele);
    heapifyUp(heap.size() - 1);
}

int BHeap::l(int par) {
    int index = par * 2 + 1;

    if(index > heap.size())
        return -1;
    return index;
}

int BHeap::r(int par) {
    int index = par * 2 + 2;
    if(index > heap.size())
        return -1;
    return index;
}

int BHeap::par(int child) {
    if(child == 0)
        return -1;
    return (child - 1) / 2;
}

void BHeap::show() {
    vector<int>::iterator pos = heap.begin();
    while(pos != heap.end()){
        cout << *pos << " ";
        pos++;
    }
    cout << endl;
}

int BHeap::Size() {
    return heap.size();
}

int main(int argc, char* argv[]){
    BHeap h;
    int cmd, data;

    while(1){
        cout << "please select operation: " << endl;
        cout << "1.Insert Element " << endl;
        cout << "2.Delete Minimum Element: "<< endl;
        cout << "3.Extract Minimum Element" << endl;
        cout << "4.Show Heap << endl;" << endl;
        cout << "5.Exit << endl; " << endl;
        cin >> cmd;
        switch(cmd){
            case 1: {
                cout<<"Enter the element to be inserted: ";
                cin >> data;
                h.Insert(data);
                break;
            }
            case 2:{
                h.deleteMin();
                break;
            }
            case 3:{
                int t = h.ExtractMin();
                cout << "min :" << t << endl;
                break;
            }
            case 4:{
                h.show();
                break;
            }
            case 5:{
                break;
            }
            default:
                break;
        }
    }

    return 0;
}