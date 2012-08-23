package demo.spring.rest.number.service;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


import demo.spring.rest.handler.INumberToWordHandler;

/**
 * Implementation of ISubscriberRs to support all subscriber related operations.
 *
 */
public class NumberToWordsRSImpl implements INumberToWordsRS {
	
	private String THIS_CLASS = "NumberToWordsRSImpl";
		
	private INumberToWordHandler numberWordHandler;
	
	public INumberToWordHandler getNumberWordHandler() {
		return numberWordHandler;
	}

	public void setNumberWordHandler(INumberToWordHandler numberWordHandler) {
		this.numberWordHandler = numberWordHandler;
	}

	/* (non-Javadoc)
	 * @see com.mportal.cds.service.ISubscriberRS#registerSubscriber(javax.ws.rs.core.HttpHeaders, com.mportal.cds.bean.UserDetail)
	 */
	
	
	public Response convertNumberToWord( long number)
	{
		String numberStr = numberWordHandler.convertWordToNumber(number);
		
		  System.out.println("numberStr is "+numberStr);
		return Response.ok(numberStr).header("Access-Control-Allow-Origin", "*").build();	
	}
	


	
}
