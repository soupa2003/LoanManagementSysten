package dao;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Loan;
import exception.InvalidLoanException;
import util.DBconnUtil;

public   class loanImpl implements ILoanRepository {
	private Connection conn;

    public loanImpl() {
        conn = DBconnUtil.getConnection();  
    }
   
    @Override
    public void applyLoan(Loan loan) {     
    	if (!isCustomerExists1(loan.getCustomer())) {
            System.out.println("Error: Customer ID " + loan.getCustomer() + " does not exist.");
            return;
        }

        // Generate a new loan ID
        int newLoanId = generateLoanId();

        String sql = "INSERT INTO Loan (loan_id, customer_id, principal_amount, interest_rate, loan_term, loan_type, loan_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newLoanId);
            stmt.setInt(2, loan.getCustomer());
            stmt.setBigDecimal(3, loan.getPrincipalAmount());
            stmt.setBigDecimal(4, loan.getInterestRate());
            stmt.setInt(5, loan.getLoanTerm());
            stmt.setString(6, loan.getLoanType());
            stmt.setString(7, "pending");

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Loan applied successfully with Loan ID: " + newLoanId);
            } else {
                System.out.println("Failed to apply loan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error applying loan: " + e.getMessage());
        }
    }

    private boolean isCustomerExists1(int customerId) {
        String sql = "SELECT 1 FROM Customer WHERE customer_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error checking customer existence: " + e.getMessage());
            return false;
        }
    }

    private int generateLoanId() {
        int loanId = 0;
        String sql = "SELECT MAX(loan_id) FROM Loan";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                loanId = rs.getInt(1) + 1;
            } else {
                loanId = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error generating loan ID: " + e.getMessage());
        }
        return loanId;
    
    }

    private boolean isCustomerExists(int customerId) {
        String sql = "SELECT 1 FROM Customer WHERE customer_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error checking customer existence: " + e.getMessage());
            return false;
        }
    }


    @Override
    public List<Loan> getAllLoan() {
        List<Loan> loans = new ArrayList<>();
        String sql = "SELECT * FROM Loan";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Loan loan = new Loan();
                loan.setLoanId(rs.getInt("loan_id"));
                loan.setCustomer(rs.getInt("customer_id"));
                loan.setPrincipalAmount(rs.getBigDecimal("principal_amount"));
                loan.setInterestRate(rs.getBigDecimal("interest_rate"));
                loan.setLoanTerm(rs.getInt("loan_term"));
                loan.setLoanType(rs.getString("loan_type"));
                loan.setLoanStatus(rs.getString("loan_status"));
                
                loans.add(loan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
             
        }
        
        return loans;
    }
    
     


    @Override
    public Loan getLoanById(int loanId) throws InvalidLoanException {
        String sql = "SELECT * FROM Loan WHERE loan_id = ?";
        Loan loan = null;
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loanId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                loan = new Loan();
                loan.setLoanId(rs.getInt("loan_id"));
                loan.setCustomer(rs.getInt("customer_id"));
                loan.setPrincipalAmount(rs.getBigDecimal("principal_amount"));
                loan.setInterestRate(rs.getBigDecimal("interest_rate"));
                loan.setLoanTerm(rs.getInt("loan_term"));
                loan.setLoanType(rs.getString("loan_type"));
                loan.setLoanStatus(rs.getString("loan_status"));
            } else {
                throw new InvalidLoanException("Loan ID not found: " + loanId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new InvalidLoanException("Database error while fetching loan ID: " + loanId);
        }
        
        return loan;
    }


	 
	@Override
	public double calculateInterest(int loanId) throws InvalidLoanException {
	    String sql = "SELECT principal_amount, interest_rate, loan_term FROM Loan WHERE loan_id = ?";
	    
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, loanId);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            BigDecimal principalAmount = rs.getBigDecimal("principal_amount");
	            BigDecimal interestRate = rs.getBigDecimal("interest_rate");
	            int loanTerm = rs.getInt("loan_term");
	            
	            // Calculate the interest amount
	            BigDecimal interest = principalAmount.multiply(interestRate).multiply(new BigDecimal(loanTerm)).divide(new BigDecimal(12), 2, RoundingMode.HALF_UP);
	            
	            return interest.doubleValue();
	        } else {
	            throw new InvalidLoanException("Loan ID not found: " + loanId);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new InvalidLoanException("Database error while calculating interest for loan ID: " + loanId);
	    }
	}


	 
	


  
}
