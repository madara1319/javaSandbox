public interface BeatModelInterface{
    //methods controller will use to direct the model based on user interaction
    void initialize();

    void on();

    void off();

    void setBPM(int bpm);
//-------------------------------
    //these methods allow the view and controller to get state and to become observers
    int getBPM();
//two kinds of observers ones that want to be notified
//every beat and ones getting notified when beats per minute change
    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);


}
