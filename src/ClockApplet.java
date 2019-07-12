import java.awt.Graphics;
import java.applet.Applet;
import java.util.Date;

public class ClockApplet extends Applet{
	
	private static final long serialVersionUID = 1L;
	wThread w;
	Date d;
	
	public void start(){
		w = new wThread(this);
		w.t.start();
	}
	
	public void paint(Graphics g){
		g.drawString(d.toString(), 40, 40);
	}
	
}

class wThread implements Runnable{
	
	ClockApplet ca;
	Thread t;
	
	wThread(ClockApplet ca){
		this.ca = ca;
		t = new Thread(this);
	}

	public void run() {
		while(true){
			ca.d = new Date();
			ca.repaint();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){}
		}
	}
	
}
