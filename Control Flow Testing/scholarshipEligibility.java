/*
 * Description: Basic codebase for determining the eligibility of a student for a scholarship.
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
        if (isOfAge() && !isCaliforniaResident() && householdIncome < 5000f ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Operation to determine student eligibility for the scholarship
     * Takes into account all the "OR" possibilities described in the requirements.
     * 
     * @return A string that can be sent to the console that communicates whether
     *         the student is eligible for the scholarship.
     */
    public int determineEligibility(int studentAge,boolean twoYearResidency,boolean sixMonthsWorking,
    boolean oneYearParentResidency,boolean proofOfVolunteering,float householdIncome) {
       
        this.studentAge = studentAge;
        this.twoYearResidency = twoYearResidency;
        this.sixMonthsWorking = sixMonthsWorking;
        this.oneYearParentResidency = oneYearParentResidency;
        this.proofOfVolunteering = proofOfVolunteering;
        this.householdIncome = householdIncome;

        if (isOfAge() && isCaliforniaResident()) {
            return 1;
        } else if (deansConsideration()) {
            return 0;
        } else {
            return 2;
        }
    }
}
