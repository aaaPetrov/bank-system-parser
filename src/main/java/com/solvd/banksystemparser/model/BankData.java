package com.solvd.banksystemparser.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "bankdata")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankData {

    @XmlElementWrapper(name = "banks")
    @XmlElement(name = "bank")
    private List<Bank> banks;

    public BankData() {
        banks = new ArrayList<>();
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }
        BankData bankData = (BankData) object;
        if (bankData.getBanks().size() != this.getBanks().size()) {
            return false;
        }
        int counter = 0;
        boolean result = false;
        for (int i = 0; i < this.getBanks().size(); i++) {
            if (bankData.getBanks().get(i).equals(this.getBanks().get(i))) {
                counter++;
                if (counter == this.getBanks().size()) {
                    result = true;
                }
            } else {
                result = false;
            }
        }
        return result;
    }
}
