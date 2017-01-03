/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.ecafeteria.persistence;

import eapli.ecafeteria.domain.cafeteria.CashRegister.CashRegister;
import eapli.framework.persistence.repositories.Repository;

/**
 *
 * @author Rui Bastos<1140491@isep.ipp.pt>
 */
public interface CashRegisterRepository extends Repository<CashRegister, Long>{

    public CashRegister findByNumber(String number);
    
}
