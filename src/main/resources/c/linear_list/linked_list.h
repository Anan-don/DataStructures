typedef struct LNode
{
	ElemType data;
	struct LNode *next;
};
struct LNode *InitList_L()
{
	struct LNode *head=NULL;
	return head;
}
Status DestroyList_L(struct LNode *head)
{
	struct LNodee *p,*q;
	if(!head)exit(INFEASIBLE);
	q=head;
	p=head;
	while(p)
	{
		q=p->next;
		free(p);
		p=q;
	}
	head=NULL;
	return OK;
}
Status ListEmpty_L(struct LNode *head)
{
	if(head)return TRUE;
	else return FALSE;
}
int ListLength_L(struct LNode *head)
{
	int i=0;
	struct LNode *p;
	p=head;
	while(p)
	{
		i++;
		p=p->next;
	}
	return i;
}
ElemType GetElem_L(struct LNode *head,int i)
{
	ElemType e;
	int n;
	struct LNode *p;
	if(!head)exit(INFEASIBLE);
	if(i<1||i>ListLength_L(head))exit(ERROR);
	p=head;
	for(n=1;n<i;n++)
	{
		p=p->next;
	}
	e=p->data;
	return e;
}
int LocateElem_L(struct LNode *head,ElemType e)
{
	Status compare(ElemType a,ElemType b)
	{
		//
	}
	int i;
	struct LNode *p;
	p=head;
	if(!head)exit(INFEASIBLE);
	for(i=1;i<=ListLength_L(head);i++)
	{
		if(compare(e,p->data))return i;
		p=p->next;
	}
	return 0;
}
ElemType PriorElem_L(struct LNode *head,ElemType e)
{
	struct LNode *p,*q;
	if(!head)exit(INFEASIBLE);
	if(!(head->next))exit(ERROR);
	p=head->next;
	q=head;
	while(p)
	{
		if(p->data==e)return q->data;
		q=p;
		p=p->next;
	}
	exit(ERROR);
}
ElemType NextElem_L(struct LNode *head,ElemType e)
{
	struct LNode *p;
	if(!head)exit(INFEASIBLE);
	p=head;
	while(p)
	{
		if(p->data==e&&p->next)return (p->next)->data;
		p=p->next;
	}
	exit(ERROR);
}
Status ListInsert_L(struct LNode *head,int i,ElemType e)
{
	int n=ListLength_L(head),j;
	struct LNode *p,*q,*temp;
	if(i<1||i>n+1)exit(ERROR);
	q=(struct LNode *)malloc(sizeof(struct LNode));
	if(!q)exit(OVERFLOW);
	if(i==1)
	{
		temp=head;
		head=q;
		q->next=temp;
		q->data=e;
		return OK;
	}
	else
	{
	p=head;
	temp=NULL;
	for(j=1;j<i;j++)
	{
		temp=p;
		p=p->next;
	}
	temp->next=q;
	q->next=p;
	q->data=e;
	return OK;
	}
}
Status ListDelete_L(struct LNode *head,int i)
{
	int n=ListLength_L(head),j;
	struct LNode *p,*q,*temp;
	if(!head)exit(INFEASIBLE);
	if(i<1||i>n)exit(ERROR);
	if(i==1)
	{
		q=head;
		head=head->next;
		free(q);
		q=NULL;
		return OK;
	}
	else 
	{
		p=head;
		q=head;
		for(j=1;j<i;j++)
		{
			q=p;
			p=p->next;
		}
		q->next=p->next;
		free(q);
		q=NULL;
		return OK;
	}
}
Status ListTraverse_L(struct LNode *head)
{
	Status visit(ElemType e)
	{
		//
	}
	struct LNode *p;
	p=head;
	if(!head)exit(INFEASIBLE);
	while(p)
	{
		if(!visit(p->data))return ERROR;
		p=p->next;
	}
	return OK;
}
