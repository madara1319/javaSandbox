public class DJTestDrive{
    public static void main(String[] args){
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
        System.out.println("test");
    }
}
