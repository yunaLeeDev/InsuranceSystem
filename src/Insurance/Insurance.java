package Insurance;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Insurance {

	private String insuranceID;	
	private String insuranceName;
	private String type;
	private int maxCompensation;
	private String periodOfInsurance;
	private String paymentCycle;
	private String paymentPeriod;
	private String ageOfTarget;
	private int basicPremium;
	private String rate;
	private boolean distributionStatus;
	private String TermsIDList;
	private String insuranceClausePeriod;	
	private String precaution;
	private boolean authorization;
	

	public GuaranteeListImpl guaranteeList;
	public InsuranceApplication m_InsuranceApplication;


	
	public Insurance() throws FileNotFoundException, IOException {  
		distributionStatus = (Boolean) null;
		basicPremium = 0;
		maxCompensation = 0;
    	authorization = false;
    }  
	public void setInsuranceID(String insuranceID) {
		this.insuranceID = insuranceID;
	}
    public boolean matchId(String insuranceID) {

      return this.insuranceID.equals(insuranceID);
    }
  
    public String toString() {
        String stringReturn = this.insuranceID + " " + this.insuranceName + " " + this.type + " " + this.maxCompensation + " " + this.periodOfInsurance
        		+ " " + this.paymentCycle + " " + this.paymentPeriod + " " + this.ageOfTarget + " " + this.basicPremium
        		+ " " + this.rate + " " + this.distributionStatus + " " + this.TermsIDList + " " + this.insuranceClausePeriod + " "  + this.authorization + " "+ this.precaution;
        return stringReturn;
    }

	public boolean matchType(String type) {
		return this.type.equals(type);
	}

	public String getInsuranceID() {
		return insuranceID;
	}


	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMaxCompensation() {
		return maxCompensation;
	}

	public void setMaxCompensation(int maxCompensation) {
		this.maxCompensation = maxCompensation;
	}

	public String getPeriodOfInsurance() {
		return periodOfInsurance;
	}

	public void setPeriodOfInsurance(String periodOfInsurance) {
		this.periodOfInsurance = periodOfInsurance;
	}

	public String getPaymentCycle() {
		return paymentCycle;
	}

	public void setPaymentCycle(String paymentCycle) {
		this.paymentCycle = paymentCycle;
	}

	public String getPaymentPeriod() {
		return paymentPeriod;
	}

	public void setPaymentPeriod(String paymentPeriod) {
		this.paymentPeriod = paymentPeriod;
	}

	public String getAgeOfTarget() {
		return ageOfTarget;
	}

	public void setAgeOfTarget(String ageOfTarget) {
		this.ageOfTarget = ageOfTarget;
	}

	public int getBasicPremium() {
		return basicPremium;
	}

	public void setBasicPremium(int basicPremium) {
		this.basicPremium = basicPremium;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public boolean isDistributionStatus() {
		return distributionStatus;
	}

	public void setDistributionStatus(boolean distributionStatus) {
		this.distributionStatus = distributionStatus;
	}

	public String getTermsIDList() {
		return TermsIDList;
	}

	public String getInsuranceClausePeriod() {
		return insuranceClausePeriod;
	}

	public void setInsuranceClausePeriod(String insuranceClausePeriod) {
		this.insuranceClausePeriod = insuranceClausePeriod;
	}

	public String getPrecaution() {
		return precaution;
	}

	public void setPrecaution(String precaution) {
		this.precaution = precaution;
	}

	public boolean isAuthorization() {
		return authorization;
	}

	public void setAuthorization(boolean authorization) {
		this.authorization = authorization;
	}

	public GuaranteeListImpl getGuaranteeList() {
		return guaranteeList;
	}

	public void setGuaranteeList(GuaranteeListImpl guaranteeList) {
		this.guaranteeList = guaranteeList;
	}

	public InsuranceApplication getM_InsuranceApplication() {
		return m_InsuranceApplication;
	}

	public void setM_InsuranceApplication(InsuranceApplication m_InsuranceApplication) {
		this.m_InsuranceApplication = m_InsuranceApplication;
	}

	public boolean setTermsIDList(String termsIDList) throws FileNotFoundException, IOException {
		guaranteeList = new GuaranteeListImpl("data/Guarantee.txt"); 
		if(guaranteeList.alreadyExistInsurance(this.insuranceID)) guaranteeList.delete(insuranceID);
		String[] termsIDListSplit = termsIDList.split(",");
		Guarantee guarantee = new Guarantee();
		for(int i=0; i<termsIDListSplit.length; i++) {		
			guarantee.setInsuranceID(this.insuranceID);
			guarantee.setTermsID(termsIDListSplit[i]);
			if(!guarantee.isExistTermsID()) return false;
			}
		guaranteeList.create(guarantee);
		TermsIDList = termsIDList;
		return true;
	}

	public boolean checkAllFillIn() {
		boolean AllFullIn = true;
		if(this.insuranceID.isEmpty()) AllFullIn = false;
		if(this.insuranceName.isEmpty()) AllFullIn = false;
		if(this.type.isEmpty()) AllFullIn = false;
		if(this.maxCompensation == 0) AllFullIn = false;
		if(this.periodOfInsurance.isEmpty()) AllFullIn = false;
		if(this.paymentCycle.isEmpty()) AllFullIn = false;
		if(this.paymentPeriod.isEmpty()) AllFullIn = false;
		if(this.ageOfTarget.isEmpty()) AllFullIn = false;
		if(this.basicPremium == 0) AllFullIn = false;
		if(this.rate.isEmpty()) AllFullIn = false;
		if(this.TermsIDList.isEmpty()) AllFullIn = false;
		if(this.insuranceClausePeriod.isEmpty()) AllFullIn = false;
		if(this.precaution.isEmpty()) AllFullIn = false;
		if(this.distributionStatus == (Boolean) null) AllFullIn = false;
		return AllFullIn;
	}

}
