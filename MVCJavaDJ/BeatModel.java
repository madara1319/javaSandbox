import java.util.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import javax.sound.sampled.Line;
public class BeatModel implements BeatModelInterface, Runnable{
    //these hold two kinds of observers
    List<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
    List<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
    //holds frequency of beat by default 90
    int bpm = 90;
    //we use these to start and stop the beat thread
    Thread thread;
    boolean stop = false;
    //this is the audio clip we play for the beat
    Clip clip;
//this method does setup for the beat track
    public void initialize(){
        try{
            File resource = new File("clap.wav");
            clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            clip.open(AudioSystem.getAudioInputStream(resource));
        }
        catch(Exception ex){
            System.out.println("Error: Cant load clip");
            System.out.println(ex);
        }
    }

    //sets BPMs to the default and starts thread to play the beat
    public void on(){
        bpm = 90;
        notifyBPMObservers();
        thread = new Thread(this);
        stop = false;
        thread.start();
    }
    //shuts down by setting BPMs to 0 and stopping the thread playing the beat
    public void off(){
        stopBeat();
        stop = true;
    }

    //runs beat thread playing a beat determined by BPM and notifies the beat observers that a beats been played 
    //loop terminates when we select stop from the menu
    public void run(){
        while(!stop){
            playBeat();
            notifyBeatObservers();
            try{
                Thread.sleep(60000/getBPM());
            }
            catch(Exception e){}
        }
        
    }
//controller manipulates the beat with this method
    //sets bpm variable and notifies observers that bpm has changed
    public void setBPM(int bpm){
        this.bpm = bpm;
        notifyBPMObservers();
    }
    //retruns current bpm
    public int getBPM(){
        return bpm;
    }
    
    public void registerObserver(BeatObserver o){
        beatObservers.add(o);
    }
    public void notifyBPMObservers(){
        for (int i = 0; i< beatObservers.size(); i++){
            BeatObserver observer = (BeatObserver)beatObservers.get(i);
            observer.updateBeat();
        }
        
    }
    public void registerObserver(BPMObserver o){
        bpmObservers.add(o);
    }
    public void notifyBPMObservers(){
        for (int i = 0; i <   bpmObservers.size(); i++){
            BPMObserver observer = (BPMObserver)bpmObservers.get(i);
            observer.updateBPM();
        }
    }

    public void removeObserver(BeatObserver o){
        int i = beatObservers.indexOf(o);
        if(i>=0){
            beatObservers.remove(i);
        }
    }
    public void removeObserver(BPMObserver o){
        int i = bpmObservers.indexOf(o);
        if(i>=0){
            bpmObservers.remove(i);
        }
    }
    public void playBeat(){
        clip.setFramePosition(0);
        clip.start();
    }
    public void stopBeat(){
        clip.setFramePosition(0);
        clip.stop();
    }
}
