package entity;

import java.math.BigDecimal;

public class Loan 
{
	int loanid;
	int customer;
	BigDecimal principalamount;
    BigDecimal interestrate;
    int loanterm;
    String loantype;
    String loanstatus;
 
    public Loan()
    {
    }
 
    public Loan(int loanId, int customer, BigDecimal principalamount, BigDecimal interestrate, int loanterm, String loantype, String loanstatus) 
    {
        this.loanid = loanId;
        this.customer = customer;
        this.principalamount = principalamount;
        this.interestrate = interestrate;
        this.loanterm = loanterm;
        this.loantype = loantype;
        this.loanstatus = loanstatus;
    }
    
   
    public int getLoanId() 
    {
        return loanid;
    }

    public void setLoanId(int loanId) 
    {
        this.loanid = loanId;
    }

    public int getCustomer() 
    {
        return customer;
    }

    public void setCustomer(int customer)
    {
        this.customer = customer;
    }

    public void setCustomerId(int customerId) 
    {
    	this.customer=customer;
    }

    public BigDecimal getPrincipalAmount() {
		return principalamount;
	}
    
    public void setPrincipalAmount(BigDecimal d) {
		this.principalamount=d;
		
	}
     

    public BigDecimal getInterestRate()
    {
        return interestrate;
    }

    public void setInterestRate(BigDecimal interestRate) 
    {
        this.interestrate = interestRate;
    }

    public int getLoanTerm()
    {
        return loanterm;
    }

    public void setLoanTerm(int loanTerm)
    {
        this.loanterm = loanTerm;
    }

    public String getLoanType() 
    {
        return loantype;
    }

    public void setLoanType(String loanType) 
    {
        this.loantype = loanType;
    }

    public String getLoanStatus() 
    {
        return loanstatus;
    }

    public void setLoanStatus(String loanStatus) 
    {
        this.loanstatus = loanStatus;
    }
    
  
    public void printInfo()
    {
        System.out.println("Loan ID: " + loanid);
        System.out.println("Customer Information:");
        System.out.println("Principal Amount: " + principalamount);
        System.out.println("Interest Rate: " + interestrate);
        System.out.println("Loan Term: " + loanterm);
        System.out.println("Loan Type: " + loantype);
        System.out.println("Loan Status: " + loanstatus);
    }
    @Override
    public String toString() {
        return "Loan ID: " + loanid + ", Customer ID: " + customer +
               ", Principal Amount: " + principalamount + ", Interest Rate: " + interestrate +
               ", Loan Term: " + loanterm + ", Loan Type: " + loantype + ", Loan Status: " + loanstatus;
    }
}

 




class homeloan extends Loan
{
	String propertyaddress;
    int propertyvalue;
    
    public homeloan()
    {
        super();
    }
    
   
    public homeloan(int loanid, int customer, BigDecimal principalamount, BigDecimal interestrate, int loanterm, String loanstatus, String propertyaddress, int propertyvalue)
    {
        super(loanid, customer, principalamount, interestrate, loanterm, "HomeLoan", loanstatus);
        this.propertyaddress = propertyaddress;
        this.propertyvalue = propertyvalue;
    }
    
    
    public String getPropertyAddress() 
    {
        return propertyaddress;
    }

    public void setPropertyAddress(String propertyAddress) 
    {
        this.propertyaddress = propertyAddress;
    }

    public int getPropertyValue() 
    {
        return propertyvalue;
    }

    public void setPropertyValue(int propertyValue)
    {
        this.propertyvalue = propertyValue;
    }
    
    
    public void printInfo()
    {
        super.printInfo();
        System.out.println("Property Address: " + propertyaddress);
        System.out.println("Property Value: " + propertyvalue);
    }
    

}


class carloan extends Loan
{
	String carmodel;
	int carvalue;
	
	public carloan() 
	{
        super();
    }
    
   
    public carloan(int loanid, int customer, BigDecimal principalamount, BigDecimal interestrate, int loanterm, String loanstatus, String carmodel, int carvalue)
    {
        super(loanid, customer, principalamount, interestrate, loanterm, "Carloan", loanstatus);
        this.carmodel = carmodel;
        this.carvalue = carvalue;
    }
    
  
    public String getCarModel() 
    {
        return carmodel;
    }

    public void setCarModel(String carmodel) 
    {
        this.carmodel = carmodel;
    }

    public int getCarValue() 
    {
        return carvalue;
    }

    public void setCarValue(int carvalue) 
    {
        this.carvalue = carvalue;
    }
    
    
    public void printInfo()
    {
        super.printInfo();
        System.out.println("Car Model: " + carmodel);
        System.out.println("Car Value: " + carvalue);
    }
  
 
}
