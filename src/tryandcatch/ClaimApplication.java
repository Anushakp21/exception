package tryandcatch;

class FraudulentClaimException extends RuntimeException{
	public FraudulentClaimException(String message) {
		super(message);
	}
}
class InvalidClaimAmountException extends RuntimeException
{
	public InvalidClaimAmountException(String message)
	{
		super(message); 
	}
}
class ProcessClaim
{
	 public void processClaim(double claimAmount, String claimDate, double policyCoverage) {
	        if (claimAmount <= 0) {
	            throw new InvalidClaimAmountException("Invalid claim amount: Claim amount must be greater than zero.");
	        }
	        if (claimAmount > policyCoverage) {
	            throw new FraudulentClaimException("Fraudulent claim detected: Claim amount exceeds policy coverage.");
	        }
	        System.out.println("Claim processed successfully for amount: ₹" + claimAmount);
	    }
}
public class ClaimApplication {
    public static void main(String[] args) {
        ProcessClaim claimSystem = new ProcessClaim();

        double claimAmount = 15000; 
        String claimDate = "2024-09-30"; 
        double policyCoverage = 10000; 

        try {
            claimSystem.processClaim(claimAmount, claimDate, policyCoverage);
            System.out.println("Claim processed successfully.");
        } catch (InvalidClaimAmountException | FraudulentClaimException e) {
            System.out.println("Claim processing error: " + e.getMessage());
            System.err.println("Notification sent to claims department: " + e.getMessage());
        }
    }
}
