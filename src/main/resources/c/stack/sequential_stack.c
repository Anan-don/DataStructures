#include"init.h"
#include"sequential_stack.h"
#include<stdio.h>
#include<stdlib.h>
#define STACK_INIT_SIZE 100
#define STACKINCREMENT 10
//定义顺序栈类型
/*typedef struct
{
	ElemType *bottom;//栈底指针
	ElemType *top;//栈顶指针
	int stacksize;//栈数据元素容量
}SqStack;*/
Status InitStack_Sq(SqStack *S)
{
	S->bottom=(ElemType *)malloc(STACK_INIT_SIZE*sizeof(ElemType));
	if(!(S->bottom))exit(OVERFLOW);
	S->top=S->bottom;
	S->stacksize=STACK_INIT_SIZE;
	return OK;
}//创建空栈
Status DestoryStack_Sq(SqStack *S)
{
	if(!(S->bottom))exit(INFEASIBLE);
	free(S->bottom);
	S->bottom=NULL;
	S->top=NULL;
	S->stacksize=0;
	return OK;
}//销毁栈
Status ClearStack_Sq(SqStack *S)
{
	ElemType *p;
	if(!(S->bottom))exit(INFEASIBLE);
	p=(ElemType *)realloc(S->bottom,STACK_INIT_SIZE*sizeof(ElemType));
	if(!p)exit(OVERFLOW);
	S->bottom=p;
	S->top=p;
	S->stacksize=STACK_INIT_SIZE;
	return OK;
}//清空栈
Status StackEmpty_Sq(SqStack *S)
{
	if(!(S->bottom))exit(INFEASIBLE);
	if((S->bottom)==(S->top))return TRUE;
	else return FALSE;
}//栈判空
int StackLength_Sq(SqStack *S)
{
	if(!(S->bottom))exit(INFEASIBLE);
	return (S->top)-(S->bottom);
}//栈长度
ElemType GetTop_Sq(SqStack *S)
{
	if(!(S->bottom)&&(S->bottom)==(S->top))exit(INFEASIBLE);
	return *((S->top)-1);
}//得到栈顶元素
Status Push_Sq(SqStack *S,ElemType e)
{
	ElemType *p;
	if(!(S->bottom))exit(INFEASIBLE);
	if(((S->top)-(S->bottom))>=(S->stacksize))
	{
		p=(ElemType *)realloc(S->bottom,((S->stacksize)+(STACKINCREMENT))*sizeof(ElemType));
		if(!p)exit(OVERFLOW);
		S->bottom=p;
		S->top=(S->bottom)+(S->stacksize);
		S->stacksize+=STACKINCREMENT;
	}
	*((S->top)++)=e;
	return OK;
}//入栈
ElemType Pop_Sq(SqStack *S)
{
	if(!(S->bottom)&&((S->bottom)==(S->top)))exit(INFEASIBLE);
	return *(--(S->top));
}//出栈
Status StackTraverse_Sq(SqStack *S)
{
	ElemType *p;
	if(!(S->bottom)&&((S->bottom)==(S->top)))exit(INFEASIBLE);
	for(p=(S->bottom);p<(S->top);p++)
	{
		if(!visit(*p))return ERROR;
	}
	return OK;
}//栈遍历
Status visit(ElemType e)
{
	//
}//遍历函数
