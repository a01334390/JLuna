/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdvancedElements;

/**
 *
 * @author Arpi
 */
public class HighestBenefitCC {

    private int MaxBenefit;
    private String type;

    public HighestBenefitCC(String type,int MaxBenefit) {
        this.MaxBenefit = MaxBenefit;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getMaxBenefit() {
        return MaxBenefit;
    }

    public void setMaxBenefit(int MaxBenefit) {
        this.MaxBenefit = MaxBenefit;
    }

}
