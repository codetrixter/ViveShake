#include <iostream>

/* class Move
{
private:
    int *data; // raw pointer
public:
    void set_data_value(int d) { *data = d; }
    int get_data_value() { return *data; }
    Move(int d);              // Constructor
    Move(const Move &source); // Copy Constructor
    Move(Move &&source);      // Move Constructor
    ~Move();                  // Destructor
};
Move::Move(Move &&source)
    : data{source.data}
{
    source.data = nullptr; // Steal the data and then null out the source pointer
}

int main(int argc, char const *argv[])
{
    return 0;
} */


class Abhi
{
    public:
    int *a;

    Abhi(int val):
    a{new int}
    {
        *a = val;
    }

    Abhi(const Abhi& ab)
    {
        
    }
};