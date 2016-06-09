/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include "consumer.h"

bool_t
xdr_call_result1 (XDR *xdrs, call_result1 *objp)
{
	register int32_t *buf;

	 if (!xdr_int (xdrs, &objp->error))
		 return FALSE;
	switch (objp->error) {
	case -1:
		 if (!xdr_int (xdrs, &objp->call_result1_u.errid))
			 return FALSE;
		break;
	default:
		break;
	}
	return TRUE;
}

bool_t
xdr_topics (XDR *xdrs, topics *objp)
{
	register int32_t *buf;

	 if (!xdr_string (xdrs, objp, ~0))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_partitionInfo (XDR *xdrs, partitionInfo *objp)
{
	register int32_t *buf;

	 if (!xdr_string (xdrs, &objp->topic, MAXTOPICNAMELEN))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->partitionId))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->leaderBrokerId))
		 return FALSE;
	 if (!xdr_pointer (xdrs, (char **)&objp->nextPartitionInfo, sizeof (partitionInfo), (xdrproc_t) xdr_partitionInfo))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_partitionInfoList (XDR *xdrs, partitionInfoList *objp)
{
	register int32_t *buf;

	 if (!xdr_pointer (xdrs, (char **)objp, sizeof (partitionInfo), (xdrproc_t) xdr_partitionInfo))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_consumerRecord (XDR *xdrs, consumerRecord *objp)
{
	register int32_t *buf;

	 if (!xdr_string (xdrs, &objp->topic, MAXTOPICNAMELEN))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->partitionId))
		 return FALSE;
	 if (!xdr_quad_t (xdrs, &objp->offset))
		 return FALSE;
	 if (!xdr_string (xdrs, &objp->key, MAXKEYLEN))
		 return FALSE;
	 if (!xdr_string (xdrs, &objp->value, MAXVALLEN))
		 return FALSE;
	 if (!xdr_pointer (xdrs, (char **)&objp->nextConsumerRecord, sizeof (consumerRecord), (xdrproc_t) xdr_consumerRecord))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_consumerRecordList (XDR *xdrs, consumerRecordList *objp)
{
	register int32_t *buf;

	 if (!xdr_pointer (xdrs, (char **)objp, sizeof (consumerRecord), (xdrproc_t) xdr_consumerRecord))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_position_1_argument (XDR *xdrs, position_1_argument *objp)
{
	 if (!xdr_string (xdrs, &objp->arg1, ~0))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->arg2))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_seek_1_argument (XDR *xdrs, seek_1_argument *objp)
{
	 if (!xdr_string (xdrs, &objp->arg1, ~0))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->arg2))
		 return FALSE;
	 if (!xdr_quad_t (xdrs, &objp->arg3))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_seektobeginning_1_argument (XDR *xdrs, seektobeginning_1_argument *objp)
{
	 if (!xdr_string (xdrs, &objp->arg1, ~0))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->arg2))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_seektoend_1_argument (XDR *xdrs, seektoend_1_argument *objp)
{
	 if (!xdr_string (xdrs, &objp->arg1, ~0))
		 return FALSE;
	 if (!xdr_int (xdrs, &objp->arg2))
		 return FALSE;
	return TRUE;
}
