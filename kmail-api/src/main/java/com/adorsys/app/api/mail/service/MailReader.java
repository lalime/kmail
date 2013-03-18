/**
 * 
 */
package com.adorsys.app.api.mail.service;

import java.util.List;

import com.adorsys.app.api.data.MailModelRepresentation;

/**
 * @author w2b
 *
 */
public interface MailReader {
	public List<MailModelRepresentation> readMails();
}
