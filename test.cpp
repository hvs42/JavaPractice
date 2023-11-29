// Online C++ compiler to run C++ program online
#include <bits/stdc++.h>
using namespace std;

int main() {
    // Write C++ code here
    string str;
    
    cin>>str;
    
    reverse(str.begin(), str.end());
    
    string res = "";
    string temp = "";
    for(int i=0; i<str.size(); i++)
    {
        temp += str[i];
        if((temp.length()==2))
        { 
            int tempnum = stoi(temp);
            if(tempnum == 32)
            {
                
                res += " ";
                // cout<<temp<<" "<<tempnum<<" "<<res<<endl;
                temp = "";
            }
            else if((tempnum>=65 && tempnum<=90) || (tempnum>=97 && tempnum<=99))
            {
                res += char(tempnum);
                // cout<<temp<<" "<<tempnum<<" "<<res<<endl;
                temp = "";
            }
        }
        else if(temp.length()==3)
        {
            int tempnum = stoi(temp);
            if(tempnum>=100 && tempnum<=122)
            {
                res += char(tempnum);
                // cout<<temp<<" "<<tempnum<<" "<<res<<endl;
                temp = "";
            }
        }
        else{
            // cout<<"Else : "<<temp<<" "<<res<<endl;
        }
    }
    // cout<<res;
    return 0;
}

//796115110113721110141108
//PrepInsta