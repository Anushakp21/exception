package tryandcatch;

class PolicyExpiredException extends Exception {
    public PolicyExpiredException(String message) {
        super(message);
    }
}

class PaymentPendingException extends Exception {
    public PaymentPendingException(String message) {
        super(message);
    }
}

class NonComplianceException extends Exception {
    public NonComplianceException(String message) {
        super(message);
    }
}

class PolicyRenewal {
    private String policyStatus;
    private boolean paymentPending;
    private boolean compliance;

    public PolicyRenewal(String policyStatus, boolean paymentPending, boolean compliance) {
        this.policyStatus = policyStatus;
        this.paymentPending = paymentPending;
        this.compliance = compliance;
    }

    public void renewPolicy() throws PolicyExpiredException, PaymentPendingException, NonComplianceException {
        if ("expired".equalsIgnoreCase(policyStatus)) {
            throw new PolicyExpiredException("Policy has expired. Renewal is not possible.");
        }
        if (paymentPending) {
            throw new PaymentPendingException("Payment is pending. Please clear the dues before renewal.");
        }
        if (!compliance) {
            throw new NonComplianceException("Policyholder is not in compliance with renewal terms.");
        }
        
        System.out.println("Policy renewed successfully.");
    }
}
public class InsuranceRenewalApp {
    public static void main(String[] args) {
        PolicyRenewal policyRenewal1 = new PolicyRenewal("active", false, true);
        PolicyRenewal policyRenewal2 = new PolicyRenewal("expired", false, true);
        PolicyRenewal policyRenewal3 = new PolicyRenewal("active", true, true);
        PolicyRenewal policyRenewal4 = new PolicyRenewal("active", false, false);

        try {
            policyRenewal1.renewPolicy();
        } catch (PolicyExpiredException | PaymentPendingException | NonComplianceException e) {
            System.out.println("Renewal failed: " + e.getMessage());
        }
        try {
            policyRenewal2.renewPolicy();
        } catch (PolicyExpiredException | PaymentPendingException | NonComplianceException e) {
            System.out.println("Renewal failed: " + e.getMessage());
        }
        try {
            policyRenewal3.renewPolicy();
        } catch (PolicyExpiredException | PaymentPendingException | NonComplianceException e) {
            System.out.println("Renewal failed: " + e.getMessage());
        }
        try {
            policyRenewal4.renewPolicy();
        } catch (PolicyExpiredException | PaymentPendingException | NonComplianceException e) {
            System.out.println("Renewal failed: " + e.getMessage());
        }
    }
}

