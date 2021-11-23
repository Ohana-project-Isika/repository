package fr.isika.cda11.ohana.project.common.service;

import fr.isika.cda11.ohana.project.common.dto.AccountDto;
import fr.isika.cda11.ohana.project.common.dto.PrivatePersonDto;
import fr.isika.cda11.ohana.project.common.factories.AccountFactory;
import fr.isika.cda11.ohana.project.common.factories.PrivatePersonFactory;
import fr.isika.cda11.ohana.project.common.models.Account;
import fr.isika.cda11.ohana.project.common.models.PrivatePerson;
import fr.isika.cda11.ohana.project.common.repository.PrivatePersonRepos;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PrivatePersonService {

    @Inject
    private PrivatePersonRepos privatePersonRepos;

    //READ
    public PrivatePersonDto findPrivatePersonByAccount(AccountDto accountDto) {
        Account account = AccountFactory.fromAccountDto(accountDto);
        return privatePersonRepos.findPrivatePersonByAccount(account);
    }

    //UPDATE
    public PrivatePerson updatePrivatePerson(PrivatePersonDto privatePersonToUpdate) {
        return privatePersonRepos.updatePrivatePersonRepos(privatePersonToUpdate);
    }
}
