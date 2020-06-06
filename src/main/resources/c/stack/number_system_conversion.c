#include"init.h"
#include"sequential_stack.h"
#include<stdio.h>
int main(int argc,char *argv[])
{
	void conversion();
	conversion();
	return 0;
}
void conversion()
{
	int n;
	SqStack ss;
	SqStack *p=&ss;
	InitStack_Sq(p);
	printf("Please input a intenger:");
	scanf("%d",&n);
	while(n)
	{
		Push_Sq(p,n%8);
		n=n/8;
	}
	while(!StackEmpty_Sq(p))
	{
		printf("%d",Pop_Sq(p));
	}
	DestoryStack_Sq(p);
}
