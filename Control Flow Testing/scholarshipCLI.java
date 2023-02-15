
import java.util.Scanner;

class scholarshipCLI {
    public static void main(String[] args) {
        scholarshipEligibility obj = new scholarshipEligibility();
        Scanner scanner = new Scanner(System.in); // Scanner takes input from console

        // Basic init prompt
        System.out.print("Enter your age: ");
        int studentAge = scanner.nextInt(); // studentInt is variable that will be input into the eligibility checker.
        /**
         * Diego
         * 
         * How are we checking if the student is of age within 18-24 years old?
         * I'm not seeing any use of isOfAge or any in-house checks within this CLI.
         * 
         * Nevermind, I see that you decided to input studentAge at end eligibility
         * check, will remove upon merge.
         */

        // Prompt block for checking if student has two-year residency
        System.out.print("Have you lived in California for the last 2 years? (Y/N): ");
        String twoYearResidencyStr = scanner.next().toUpperCase(); // Added to cover edge case where 'y' is entered
        boolean twoYearResidency = false;
        if (twoYearResidencyStr.equals("Y")) {
            twoYearResidency = true;
        }

        // Prompt block for checking if student has worked at least 6 months part-time
        System.out.print("Have you worked part-time for at least 6 months in the relevant field of study? (Y/N): ");
        String sixMonthsWorkingStr = scanner.next().toUpperCase(); // Added to cover edge case where 'y' is entered
        boolean sixMonthsWorking = false;
        if (sixMonthsWorkingStr.equals("Y")) {
            sixMonthsWorking = true;
        }

        // Prompt block if student has one-year residency with parents
        System.out.print("Have your parents paid California state tax for at least 1 year in their lifetime? (Y/N): ");
        String oneYearParentResidencyStr = scanner.next().toUpperCase(); // Added to cover edge case where 'y' is
                                                                         // entered
        boolean oneYearParentResidency = false;
        if (oneYearParentResidencyStr.equals("Y")) {
            oneYearParentResidency = true;
        }

        // Prompt block if student has volunteered in CA
        System.out.print("Have you volunteered for a cause in California, and have valid proof of it? (Y/N): ");
        String proofOfVolunteeringStr = scanner.next().toUpperCase(); // Added to cover edge case where 'y' is entered
        boolean proofOfVolunteering = false;
        if (proofOfVolunteeringStr.equals("Y")) {
            proofOfVolunteering = true;
        }

        // Prompt block if student has low-income and demonstrates financial need
        System.out.print("Enter your household income per annum: ");
        float householdIncome = scanner.nextFloat();

        // In-house eligibility checker that is input into a switch block
        int eligibility = obj.determineEligibility(studentAge, twoYearResidency, sixMonthsWorking,
                oneYearParentResidency, proofOfVolunteering, householdIncome);

        // Switch block to return a certain message and wrap up the program
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

        // Exit from the switch block and wrap up scanner/return behaviors
        scanner.close();
        return;
    }

}
