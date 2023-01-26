#include <iostream>

/* class single
{
    public:
    static single* getInstance()
    {
        if(instance == NULL)
        {
            instance  = new single();
        }
        
        return instance;
    }

    single(const single& obj)  = delete;
    
    private:
    static single* instance;

    single() = default;
}; */

//-------------------Alternate Myers thread safe singleton class---
class single
{
    public:
    static single& getInstance()
    {
        static single s;
        return s;
    }

    private:
    single() = default;
    ~single() = default;
    single(const single&) = delete;
    single& operator=(const single&) = delete;
};

//single* single::instance = NULL;
int main(int argc, char const *argv[])
{
    single::getInstance();
    return 0;
}
