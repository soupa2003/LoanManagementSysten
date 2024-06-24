package dao;
import java.util.List;
import exception.InvalidLoanException;
import entity.Loan;

import java.math.BigDecimal;
import java.util.*;
public interface ILoanRepository
{
	void applyLoan(Loan loan);
	double calculateInterest(int loanId) throws InvalidLoanException;
    List<Loan> getAllLoan();
    Loan getLoanById(int loanId) throws InvalidLoanException;
    
}