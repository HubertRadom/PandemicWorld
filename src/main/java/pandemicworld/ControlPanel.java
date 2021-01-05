package pandemicworld;

public class ControlPanel {
    private float transRate;
    private float transRateMask;
    private float lockdownTreshold;
    private int visitBeforeRecover;
    private int numOfVacc;
    private int disIfVacc;
    
    public void setTransRate(float rate) {
        transRate = rate;
    }
    public void setTransRateMask(float rate) {
        transRateMask = rate;
    }
    public void setLockdownTeshold(float treshold) {
        lockdownTreshold = treshold;
    }
    public void setVisitBeforeRecover(int visBefore) {
        visitBeforeRecover = visBefore;
    }
    public void setNumOfVacc(int num) {
        numOfVacc = num;
    }
    public void setDisIfVacc(int num) {
        disIfVacc = num;
    }
}
