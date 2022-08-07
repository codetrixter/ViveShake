/**
 * @file overloadingInputOutput.cpp
 * @author Abhishek
 * @brief Here we discuss about overloading stream operators:
 * 1- Overloading ostream "<<" operator: 
 * @version 0.1
 * @date 2022-08-07
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>

class Point
{
private:
    double m_x{};
    double m_y{};
    double m_z{};

public:
    Point(double x=0.0, double y=0.0, double z=0.0)
      : m_x{x}, m_y{y}, m_z{z}
    {
    }

    double getX() const { return m_x; }
    double getY() const { return m_y; }
    double getZ() const { return m_z; }

    friend std::ostream& operator<<(const std::ostream& out, const Point& p);
};

std::ostream& operator<<(std::ostream& out, const Point& p)
{
    // return std::ostream so we can chain calls to operator<<
    return (out << "Point(" << p.getX() << ", " << p.getY() << ", " << p.getZ() << ")");
}

int main(int argc, char const *argv[])
{
    Point p1{ 10, 20, 30 };
    Point p2{ 40, 50, 60 };

    /**
     * @brief By returning the out parameter as the return type instead, (std::cout<< p1) returns std::cout. 
     * Then our partially evaluated expression becomes: std::cout << p2; which becomes: std::cout << std::endl; 
     * which then gets evaluated itself!
     * 
     */
    std::cout << p1 << " " << p2 << std::endl;
    return 0;
}
