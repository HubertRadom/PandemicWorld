package pandemicworld;

public class ControlPanel {

    private double transRate;
    private double transRateMask;
    private double transIfVacc;
    private double lockdownTreshold;
    private int visitsBeforeRecover;
    private int numOfVacc;
    private int numOfClients;

    ControlPanel(double transRate, double transRateMask, double transIfVacc, double lockdownTreshold,
            int visitsBeforeRecover, int numOfVacc, int numOfClients) {
        this.transRate = transRate;
        this.transRateMask = transRateMask;
        this.transIfVacc = transIfVacc;
        this.lockdownTreshold = lockdownTreshold;
        this.visitsBeforeRecover = visitsBeforeRecover;
        this.numOfVacc = numOfVacc;
        this.numOfClients = numOfClients;
    }

    public void setTransRate(double rate) {
        transRate = rate;
    }

    public double getTransRate() {
        return transRate;
    }

    public void setTransRateMask(double rate) {
        transRateMask = rate;
    }

    public double getTransRateMask() {
        return transRateMask;
    }

    public void setTransIfVacc(double num) {
        transIfVacc = num;
    }

    public double getTransIfVacc() {
        return transIfVacc;
    }

    public void setLockdownTeshold(double treshold) {
        lockdownTreshold = treshold;
    }

    public double getLockDownTreshold() {
        return lockdownTreshold;
    }

    public void setVisitsBeforeRecover(int visBefore) {
        visitsBeforeRecover = visBefore;
    }

    public int getVisitsBeforeRecover() {
        return visitsBeforeRecover;
    }

    public void setNumOfVacc(int num) {
        numOfVacc = num;
    }

    public int getNumOfVacc() {
        return numOfVacc;
    }

    public int getNumOfClients() {
        return numOfClients;
    }
}
