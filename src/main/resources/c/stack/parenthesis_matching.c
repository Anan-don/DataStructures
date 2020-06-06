#include"init.h"
#include"sequential_stack.h"
#include<stdio.h>
#include<stdlib.h>
#define CHAR_INIT_SIZE 100
int main()
{
	char *c;
	c=(char *)malloc(CHAR_INIT_SIZE*sizeof(char));
	if(!c)exit(OVERFLOW);
	printf("Please input the string(include %d):",CHAR_INIT_SIZE);
	scanf("%s",c);
	if(match(c))printf("The string is match ture\n");
	else printf("The string is match flase\n");
	return 0;
}
Status match(char *c)
{
	SqStack ss;
	SqStack *p=&ss;
	InitStack_Sq(p);
	while(*c)
	{
		switch(*c)
		{
			case '(':Push_Sq(p,')');break;
			case '[':Push_Sq(p,']');break;
			case ')': {
						 if(GetTop_Sq(p)==')')Pop_Sq(p);
						 else
						 {
							 DestoryStack_Sq(p);
							 return FALSE;
						 }
					 }
					 break;
			case ']': {
						 if(GetTop_Sq(p)==']')Pop_Sq(p);
						 else
						 {
							 DestoryStack_Sq(p);
							 return FALSE;
						 }
					 }
					  break;
		}
		c++;
	}
	if((p->top)==(p->bottom))
	{
		DestoryStack_Sq(p);
		return TRUE;
	}
	else 
	{
		DestoryStack_Sq(p);
		return FALSE;
	}
}
