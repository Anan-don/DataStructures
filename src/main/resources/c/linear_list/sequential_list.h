#define LIST_INIT_SIZE 100
#define LISTINCREMENT 10
typedef struct
{
	ElemType *elem;
	int length;
	int listsize;
}SqList;
Status InitList_Sq(SqList *L)
{
	L->elem=(ElemType *)malloc(LIST_INIT_SIZE*sizeof(ElemType));
	if(!L->elem)exit(OVERFLOW);
	L->length=0;
	L->listsize=LIST_INIT_SIZE;
	return OK;
}
Status DestroyList_Sq(SqList *L)
{
	if(!L->elem)exit(INFEASIBLE);
		free(L->elem);
		L->elem=NULL;
		L->length=0;
		L->listsize=0;
		return OK;
}
Status ClearList_Sq(SqList *L)
{
	if(!L->elem)exit(INFEASIBLE);
		ElemType *p;
		p=(ElemType *)realloc(L->elem,LIST_INIT_SIZE*sizeof(ElemType));
		if(!p)exit(OVERFLOW);
		else L->elem=p;
		L->length=0;
		L->listsize=LIST_INIT_SIZE;
		return OK;
}
Status ListEmpty_Sq(SqList *l)
{
	if(!L->elem)exit(INFEASIBLE);
	else 
	{
		if(0==L->length)return TRUE;
		else return FALSE;
	}
}
int ListLength_Sq(SqList *L)
{
	if(!L->elem) exit(INFEASIBLE);
	else return L->length;
}
ElemType GetElem_Sq(SqList *L,int i)
{
	if(!L->elem)exit(INFEASIBLE);
	else
	{
		if(i<1||i>L->length)exit(ERROR);
		else return *((L->elem)+i-1);
	}
}
int LocateElem_Sq(SqList *L,ElemType e)
{
	Status compare(ElemType a,ElemType b)
	{
		return (a?b)?TRUE:FALSE;
	}
	int i=0;
	if(!L->elem)exit(INFEASIBLE);
	else
	{
		for(;i<(L->length);i++)
			if(compare(*((L->elem)+i),e))return i+1;
	}
	return 0;
}
ElemType PriorElem_Sq(SqList *L,ElemType e)
{
	int i;
	if(!(L->elem))exit(INFEASIBLE);
	else 
	{
		for(i=1;i<(L->length);i++)
		{
			if(*((L->elem)+i)==e)return *((L->elem)+i-1);
		}
		exit(ERROR);
	}
}
ElemType NextElem_Sq(SqList *L,ElemType e)
{
	int i;
	if(!(L->elem))exit(INFEASIBLE);
	else
	{
		for(i=0;i<(L->length-1);i++)
		{
			if(*((L->elem)+i)==e)return *((L->elem)+i+1);
		}
		exit(ERROR);
	}
}
Status ListInsert_Sq(SqList *L,int i,ElemType e)
{
	ElemType *p;
	int j;
	if(!(L->elem))exit(INFEASIBLE);
	if(i<1||i>(L->length+1))exit(ERROR);
	if((L->length)>=(L->listsize))
	{
		p=(ElemType *)realloc(L->elem,sizeof(ElemType)*(LISTINCREMENT+(L->listsize)));
		if(!p)exit(OVERFLOW);
		L->elem=p;
		L->listsize+=LISTINCREMENT;
	}
	for(j=(L->length)+1;j>i;j--)
	{
		*((L->elem)+j-1)=*((L->elem)+j-2);
	}
	*((L->elem)+i-1)=e;
	L->length++;
	return OK;
}
Status ListDelete_Sq(SqList *L,int i)
{
	int j;
	if(!(L->elem)||(L->length)==0)exit(INFEASIBLE);
	if(i<1||i>(L->length))exit(ERROR);
	for(j=i-1;j<(L->length)-1;j++)
	{
		*((L->elem)+j)=*((L->elem)+j+1);
	}
	L->length--;
	return OK;
}
Status ListTraverse_Sq(SqList *L)
{
	Status visit(ElemType e)
	{
		if(e)return TRUE;
		else return FALSE;
	}
	int i;
	if(!(L->elem))exit(INFEASIBLE);
	for(i=0;i<(L->length);i++)
	{
		if(!visit(*((L->elem)+i)))return ERROR;
	}
	return OK;
}
