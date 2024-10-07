package tryandcatch;

class DataNotFoundException extends Exception {
    public DataNotFoundException(String message) {
        super(message);
    }
}

class CalculationException extends RuntimeException {
    public CalculationException(String message) {
        super(message);
    }
}

class PremiumCalculator {

    public double calculateLifePremium(int age, String healthCondition) throws DataNotFoundException {
        if (age <= 0) {
            throw new DataNotFoundException("Age data is missing or invalid.");
        }
        if (healthCondition == null || healthCondition.isEmpty()) {
            throw new DataNotFoundException("Health condition data is missing.");
        }
        double basePremium = 1000; 

        if (age > 50) {
            basePremium += 500; 
        }
        if ("poor".equalsIgnoreCase(healthCondition)) {
            basePremium += 700;
        }
        return basePremium;
    }

    public double calculateHealthPremium(int age, boolean preExistingConditions) throws DataNotFoundException {
        if (age <= 0) {
            throw new DataNotFoundException("Age data is missing or invalid.");
        }
        double basePremium = 800; 

        if (preExistingConditions) {
            basePremium += 400; 
        }

        return basePremium;
    }

    public double calculateVehiclePremium(String vehicleType, int vehicleAge) throws DataNotFoundException {
        if (vehicleType == null || vehicleType.isEmpty()) {
            throw new DataNotFoundException("Vehicle type data is missing.");
        }
        if (vehicleAge < 0) {
            throw new DataNotFoundException("Vehicle age data is invalid.");
        }

        double basePremium = 600; 

        if ("luxury".equalsIgnoreCase(vehicleType)) {
            basePremium += 300; 
        }
        if (vehicleAge > 5) {
            basePremium += 200; 
        }

        return basePremium;
    }
}

public class InsurancePremiumApp {
    public static void main(String[] args) {
        PremiumCalculator calculator = new PremiumCalculator();

        try {
            double lifePremium = calculator.calculateLifePremium(55, "poor");
            System.out.println("Life Insurance Premium: ₹" + lifePremium);
        } catch (DataNotFoundException e) {
            System.out.println("Error calculating life premium: " + e.getMessage());
        }

        try {
            double healthPremium = calculator.calculateHealthPremium(30, true);
            System.out.println("Health Insurance Premium: ₹" + healthPremium);
        } catch (DataNotFoundException e) {
            System.out.println("Error calculating health premium: " + e.getMessage());
        }

        try {
            double vehiclePremium = calculator.calculateVehiclePremium("luxury", 6);
            System.out.println("Vehicle Insurance Premium: ₹" + vehiclePremium);
        } catch (DataNotFoundException e) {
            System.out.println("Error calculating vehicle premium: " + e.getMessage());
        }
    }
}
