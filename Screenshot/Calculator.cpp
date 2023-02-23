#include<iostream>
using namespace std;
#define PI 3.14

template <class T>
T AreaOfReactangle(T iHeight,T Width)
{
    T iArea;
    iArea=Width * iHeight;
    return iArea;
}

//////////////////////////////////////////////////////////////
template<class T>
T AreaOfSquare(T iSide)
{
    T iArea;
    iArea=(iSide * iSide);
    return iArea;
}

//////////////////////////////////////////////////////////////


float AreaOfCircle(float iRadius)
{
    float fArea=0.0f;
    fArea=PI * iRadius * iRadius;
    //return fArea;
}

/////////////////////////////////////////////////////////////

float AreaOfTriangle(float iBase,float iHeight)
{
    float fArea=0.0f;
    float fNo=0.5;
    fArea=fNo * iBase * iHeight;
    return fArea;
}

////////////////////////////////////////////////////////////

float AreaOfTrapezoid(float fBase1,float fBase2,float fHeight)
{
    float fArea=0.0f;
    float fNo=0.5f;
    fArea=fNo * fBase1 + fBase2 * fHeight;
    return fArea;
}

////////////////////////////////////////////////////////////

float AreaOfellipse(float fLength1,float fLength2)
{
    float fArea=0.0f;
    fArea=PI * fLength1 * fLength2;
    return fArea;
}

////////////////////////////////////////////////////////////
int main()
{
    int iChoice=0;
    int iHeight=0,iWidth=0,iSide=0;
    int iRet=0;
    float fRadius=0.0f,fRet=0.0f;
    float fHeight=0.0f,fBase=0.0f;
    float fBase1=0.0f,fBase2=0.0f;
    float fLength1=0.0f,fLength2=0.0f;

    printf("Welcome to Calulator Application:\n");

    while(1)  //infinite Hearing loop
    {
                    printf("1:Calculate Area Of Reactangle:\n");
                    printf("2:Calculate Area Of Square:\n");
                    printf("3:Calculate Area of Circle:\n");
                    printf("4:Calculate Area of Triangle:\n");
                    printf("5:Calculate Area Of Trapezoid:\n");
                    printf("6:Caculate Area Of Ellipse:\n");
                    printf("7:Terminating the Calculator Application:\n");

                    printf("Please Enter the Choice:\n");
                    scanf("%d",&iChoice);
                    
                    switch(iChoice)
                    {
                        case 1:
                            cout<<"Please Enter the Height:"<<endl;
                            cin>>iHeight;

                            cout<<"Please Enter the Width:"<<endl;
                            cin>>iWidth;

                            iRet=AreaOfReactangle(iHeight,iWidth);
                            cout<<"Area Of Reactangle:"<<iRet<<endl;

                            cout<<"Please Enter the Height:"<<endl;
                            cin>>fHeight;

                            cout<<"Please Enter the Width:"<<endl;
                            cin>>fBase;

                            fRet=AreaOfReactangle(fHeight,fBase);
                            cout<<"Area Of Reactangle:"<<fRet<<endl;

                            break;

                        case 2:
                            cout<<"Please Enter the length of side:"<<endl;
                            cin>>iSide;

                            iRet=AreaOfSquare(iSide);
                            cout<<"Area of Square:"<<iRet<<endl;

                            cout<<"Please Enter the length of side:"<<endl;
                            cin>>fRadius;

                            fRet=AreaOfSquare(fRadius);
                            cout<<"Area of Square:"<<fRet<<endl;
                            break;

                        case 3:   
                            printf("Please Enter the Radius:\n");
                            scanf("%f",&fRadius);

                            fRet=AreaOfCircle(fRadius);
                            printf("Area of Circle:%f\n",fRet);
                            break;

                        case 4:    
                            printf("Please Enter the Height:\n");
                            scanf("%f",&fHeight);
                            
                            printf("Please Enter the Base:\n");
                            scanf("%f",&fBase);

                            fRet=AreaOfTriangle(fHeight,fBase);
                            printf("Area of Triangle:%f\n",fRet);
                            break;

                        case 5:    
                            printf("Please Enter the First Base of Trapezoid:\n");
                            scanf("%f",&fBase1);

                            printf("Please Enter the Second Base of Trapezoid:\n");
                            scanf("%f",&fBase2);

                            printf("Please Enter the Height:\n");
                            scanf("%f",&fHeight);

                            fRet=AreaOfTrapezoid(fBase1,fBase2,fHeight);
                            printf("Area of Trapezoid:%f\n",fRet);
                            break;

                        case 6:
                            printf("Please Enter the First Length:\n");
                            scanf("%f",&fLength1);

                            printf("Please Enter the Second Length:\n");
                            scanf("%f",&fLength2);

                            fRet=AreaOfellipse(fLength1,fLength2);
                            printf("Area of ellipse:%f\n",fRet);
                            break;

                        case 7:
                            printf("Thank you For Using  Our Application:\n");   //Explicitely Loop Break
                            return 0;  //Successfull Termination

                        default:
                            printf("Invalid Case:\n");        
                    }
    }
    return 0;
}
