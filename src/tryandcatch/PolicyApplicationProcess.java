package tryandcatch;

class AgeInvalidException extends Exception {
    public AgeInvalidException(String message) {
       super(message);
    }
}

class PoorDrivingRecordException extends Exception {
    public PoorDrivingRecordException(String message) {
        super(message);
    }
}

class HealthIssueException extends Exception {
    public HealthIssueException(String message) {
        super(message);
    }
}

class PolicyManagement {
    int age;
    boolean hasAccidents;
    boolean hasHealthIssues;

    public PolicyManagement(int age, boolean hasAccidents, boolean hasHealthIssues) {
        this.age = age;
        this.hasAccidents = hasAccidents;
        this.hasHealthIssues = hasHealthIssues;
    }

    public void validate() throws AgeInvalidException, PoorDrivingRecordException, HealthIssueException {
        if (age < 18 || age > 70) {
            throw new AgeInvalidException("Invalid age: Applicant must be between 18 and 70 years old.");
        }
        if (hasAccidents) {
            throw new PoorDrivingRecordException("Poor driving record: Applicant has a history of accidents.");
        }
        if (hasHealthIssues) {
            throw new HealthIssueException("Health issues found: Applicant has severe health conditions.");
        }
    }
}

public class PolicyApplicationProcess {
    public static void main(String[] args) {
        PolicyManagement policy = new PolicyManagement(25, false, false);

        try {
            policy.validate();
            System.out.println("Application approved.");
        } 
        catch (AgeInvalidException | PoorDrivingRecordException | HealthIssueException e) {
            System.out.println("Application denied: " + e.getMessage());
            System.err.println("Error logged: " + e);
        }
    }
}