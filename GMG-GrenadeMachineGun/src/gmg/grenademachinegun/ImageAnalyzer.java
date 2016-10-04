/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gmg.grenademachinegun;

/**
 *
 * @author Matias
 */
public class ImageAnalyzer implements Runnable {

    private CameraReader camRead;
    private GuGl gugl;
    private Thread camera;

    public ImageAnalyzer(GuGl ggl) {
        gugl = ggl;
        camera = new Thread(this); // creates a thread
        camera.start();

    }

    @Override
    public void run() {
        System.out.println("ImageAnalyzer RUN()");
int start = 0;
int max = 25;
        for (int i = start; i < max; i++) {
            gugl.put(i);
            System.out.println("Camera#1 ( " + this.camera.getName() + ")" + "(" + "put" + gugl.get() + ")");

            try {
                //sleep((int)(Math.random() * 100)); // random sleep-time (integer)
                Thread.sleep(1000);  // suspend this thread for a number of millis
            }
      catch (InterruptedException e) {
          System.out.println(e.toString());
      }
    }
        if (camera.getName().equalsIgnoreCase("Thread-1")) {  // compare
            gugl.put(-1); // stop sign for the consumer
        }
        System.out.println("Camera # 1 stopped...");
    }

}
