/**
 * 
 */
package com.adorsys.app.data.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.adorsys.app.api.data.EditionState;
import com.adorsys.app.api.data.MailModelRepresentation;
import com.adorsys.app.api.data.ViewState;
import com.adorsys.app.data.domain.AppUserMail;

/**
 * @author w2b
 *
 */
public interface AppUserMailRepository extends PagingAndSortingRepository<AppUserMail, Long> {
	public AppUserMail findByMail(MailModelRepresentation mail);
	public List<AppUserMail> findByEditionState(EditionState editionState);
	public List<AppUserMail> findByViewState(ViewState viewState);
	public List<AppUserMail> findByViewStateAndEditionState(ViewState viewState,EditionState editionState);
}
