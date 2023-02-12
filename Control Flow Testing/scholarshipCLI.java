
import java.util.Scanner;
import scholarshipEligibility;

class scholarshipCLI {
    public static void main(String[] args) {
        scholarshipEligibility obj = new scholarshipEligibility();
        Scanner scanner = new Scanner (System.in);

        System.out.print("Enter you age: ");
            int studentAge = scanner.nextInt();

        System.out.print("Have you lived in California for last 2 years? (Y/N): ");
            String twoYearResidencyStr = scanner.next();
            boolean twoYearResidency = false;
            if (twoYearResidencyStr.equals("Y")) {
                twoYearResidency = true;
            }

        System.out.print("Have you work part-time for at least 6 months in the relevant field of study? (Y/N): ");
            String sixMonthsWorkingStr = scanner.next();
            boolean sixMonthsWorking = false;
            if (sixMonthsWorkingStr.equals("Y")) {
                sixMonthsWorking = true;
            }

        System.out.print("Have your parents paid California state tax for at least 1 year in their lifetime? (Y/N): ");
            String oneYearParentResidencyStr = scanner.next();
            boolean oneYearParentResidency = false;
            if (oneYearParentResidencyStr.equals("Y")) {
                oneYearParentResidency = true;
            }

        System.out.print("Have you volunteered for a cause and has a valid proof of it? (Y/N): ");
            String proofOfVolunteeringStr = scanner.next();
            boolean proofOfVolunteering  = false;
            if (proofOfVolunteeringStr.equals("Y")) {
                proofOfVolunteering  = true;
            }

        System.out.print("Enter your household income per annum: ");
            float householdIncome = scanner.nextFloat();

        
        int eligibility = obj.determineEligibility(studentAge,twoYearResidency,sixMonthsWorking,
                                oneYearParentResidency,proofOfVolunteering,householdIncome);

        switch (eligibility) {
            case 1:
                System.out.println("The student is eligible for the scholarship.");
                break;
                
            case 0:
                System.out.println("The student has been placed under Dean's Consideration for the scholarship.");
                break;

            case 2:
                System.out.println("The student is not eligible for this scholarship.");
                break;
        
        }
        scanner.close();
    }

}

