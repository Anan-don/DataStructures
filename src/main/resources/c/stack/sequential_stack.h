//定义顺序栈类型
typedef struct
{
	ElemType *bottom;
	ElemType *top;
	int stacksize;
}SqStack;
//顺序栈的基本操作声明
Status InitStack_Sq(SqStack *S);
Status DestoryStack_Sq(SqStack *S);
Status ClearStack_Sq(SqStack *S);
Status StackEmpty_Sq(SqStack *S);
int StackLength_Sq(SqStack *S);
ElemType GetTop_Sq(SqStack *S);
Status Push_Sq(SqStack *S,ElemType e);
ElemType Pop_Sq(SqStack *S);
Status StackTraverse(SqStack *S);
