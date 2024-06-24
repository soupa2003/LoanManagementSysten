package entity;

public class Customer {
	int customerid;
	String name;
	String emailaddress;
	String phonenumber;
	String address;
	int creditscore;
	
	 
    public Customer() 
    {
    	
    }
    
    
    public Customer(int customerid, String name, String emailaddress, String phonenumber, String address, int creditscore) {
        this.customerid = customerid;
        this.name = name;
        this.emailaddress = emailaddress;
        this.phonenumber = phonenumber;
        this.address = address;
        this.creditscore = creditscore;
    }
    

    public int getCustomerId() {
        return customerid;
    }

    public void setCustomerId(int customerid) {
        this.customerid = customerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailaddress;
    }

    public void setEmailAddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreditScore() {
        return creditscore;
    }

    public void setCreditScore(int creditScore) {
        this.creditscore = creditScore;
    }
    
 
    public void printInfo() {
        System.out.println("Customer ID: " + customerid);
        System.out.println("Name: " + name);
        System.out.println("Email Address: " + emailaddress);
        System.out.println("Phone Number: " + phonenumber);
        System.out.println("Address: " + address);
        System.out.println("Credit Score: " + creditscore);

    }
     

}

