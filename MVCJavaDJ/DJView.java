import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DJView implements ActionListener, BeatObserver, BPMObserver{
    BeatModelInterface model;
    ControllerInterface controller;
    JLabel bpmLabel;
    JTextField bpmTextField;
    JButton setBPMButton;
    JButton increaseBPMButton;
    JButton decreaseBPMButton;
    JMenuBar menuBar;
    JMenu menu;
    JMenu startMenuItem;
    JMenu stopMenuItem;
    JFrame viewFrame;
    JFrame controlFrame;
    JPanel viewPanel;
    JPanel controlPanel;
    BeatBar beatBar;
    JLabel bpmOutputLabel;

    public DJView(ControllerInterface controller, BeatModelInterface model){
        this.controller = controller;
        this.model = model;
        model.registerObserver((BeatObserver)this);
        model.registerObserver((BPMObserver)this);

    }
    public void createView(){
        viewPanel = new JPanel(new GridLayout(1,2));
        viewFrame = new JFrame("View");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(100,80));
        bpmOutputLabel = new JLabel("offline",SwingContestants.CENTER);
        beatBar = new BeatBar();
        beatBar.setValue(0);
        JPanel bpmPanel = new JPanel(new GridLayout(2,1));
        bpmPanel.add(beatBar);
        bpmPanel.add(bpmOutputLabel);
        viewPanel.add(bpmPanel);
        viewFrame.getContentPane().add(viewPanel,BorderLayout.CENTER);
        viewFrame.pack();
        viewFrame.setVisible(true);
    }
    public void updateBPM(){
        int bpm = model.getBPM();
        if(bpm == 0){
            bpmOutputLabel.setText("offline");
        }
        else{
            bpmOutputLabel.setText("Current BPM: " + model.getBPM());
        }
    }
    public void updateBeat(){
        beatBar.setValue(100);
    }

    public void createControls(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        controlFrame = new JFrame("Control");
        controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlFrame.setSize(new Dimension(100,80));

        controlPanel = new JPanel(new GridLayout(1,2));

        menuBar = new JMenuBar();
        menu = new JMenu("DJ Control");
        startMenuItem = new JMenuItem("Start");
        menu.add(startMenuItem);
        startMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                controller.stop();
            }
        });
        
        JMenuItem exit = new JMenuItem("Quit");
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
            
        });
        menu.add(exit);
        menuBar.add(menu);
        controlFrame.setJMenuBar(menuBar);
        bpmTextField = new JTextField(2);
        bpmLabel = new JLabel("Enter BPM: ", SwingContestants.RIGHT);
        setBPMButton = new JButton("Set");
        //continue

    }
    public void enableStopMenuItem(){
        stopMenuItem.setEnabled(true);
    }
    public void disableStopMenuItem(){
        stopMenuItem.setEnabled(false);
    }
    public void enableStartMenuItem(){
        startMenuItem.setEnabled(true);
    }
    public void disableStartMenuItem(){
        startMenuItem.setEnabled(false);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == setBPMButton){
            int bpm = Integer.parseInt(bpmTextField.getText());
            controller.setBPM(bpm);
        }
        else if(event.getSource() == increaseBPMButton){
            controller.increaseBPM();
        }
        else if(event.getSource() == decreaseBPMButton){
            controller.decreaseBPM();
        }
    }
}
