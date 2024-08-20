package com.itbulls.learnit.onlinestore.core.facades.impl;

import com.itbulls.learnit.onlinestore.core.facades.HelpDeskFacade;
import com.itbulls.learnit.onlinestore.persistence.enteties.SupportTicket;

public class DefaultHelpDeskFacade implements HelpDeskFacade {
	

	@Override
	public void addNewSupportTicket(SupportTicket supportTicket) {

	}

	@Override
	public SupportTicket getNextSupportTicket() {
		return null;
	}

	@Override
	public int getNumberOfTickets() {
		return 0;
	}

}
