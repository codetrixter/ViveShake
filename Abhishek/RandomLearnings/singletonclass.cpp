#include <iostream>

class single
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
};

single* single::instance = NULL;
int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}
