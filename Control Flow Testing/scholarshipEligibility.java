/*
 * Description: Basic codebase for determining the eligibility of a student.
 * 
 * Member names:
 * Diego Cruz
 * David Huang
 * Khoa Le
 * Nhat Tuan Nguyen
 * 
 * Course: CMPE 187
 * Section: 02
 * Homework: Control Flow 
 * Date: 11 February 2023 
 */

class scholarshipEligibility {

    private int studentAge;
    private boolean twoYearResidency;
    private boolean sixMonthsWorking;
    private boolean oneYearParentResidency;
    private boolean proofOfVolunteering;
    private float householdIncome;

    /**
     * Boolean operation to determine if student falls between ages 18-24, inclusive
     * 
     * @return Whether or not the age falls between the bounds
     */
    public boolean isOfAge() {
        if (studentAge >= 18 && studentAge <= 24) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Boolean operation to determine if student satisfies residency requirements.
     * 
     * Accounts for the volunteering status, and allows one to be met or all to be
     * met to return true.
     * 
     * @return Whether the student satisfies one or more of the conditions.
     */
    public boolean isCaliforniaResident() {
        if (twoYearResidency || sixMonthsWorking || oneYearParentResidency || proofOfVolunteering) {
            return true;
        } else {
            return false;
        }

    };

    /**
     * Boolean operation to determine if student can be considered by the Dean
     * Takes into account the rest of the basic requirements, so no further
     * operations are necessary to determine eligibility.
     * 
     * @return
     */
    public boolean deansConsideration() {
        if (isOfAge() && isCaliforniaResident() == false && householdIncome < 5000f) {
            return true;
        } else {
            return false;
        }
    }

    public String determineEligibility() {
        if (isOfAge() && isCaliforniaResident()) {
            return "The Student is eligible for the scholarship.";
        } else if (deansConsideration()) {
            return "The student has been placed under Dean's Consideration for the scholarship.";
        } else {
            return "The student is not eligible for this scholarship.";
        }
    }
}
