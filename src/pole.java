import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class pole extends JPanel
{
	private Image shapka;
	private Image fon;
	private int x = 400;
	private int slogn;
	private podar[] gamePodar;
	private Image end_game;
	private Timer timerUpdate,timerDraw;
	
	public pole (int slogn)
	{
		this.slogn = slogn;
		try
		{
			fon = ImageIO.read(new File(""));
		}
		catch(IOException ex){}
		try
		{
			fon = ImageIO.read(new File(""));
		}
		catch (IOException ex){}
		try
		{
			end_game = ImageIO.read(new File(""));
		}
		catch(IOException ex){}
		gamePodar = new podar[7];
		for (int i=0;i<7;i++)
		{
			try
			{
				gamePodar[i] = new podar(ImageIO.read(new File("c:\\p"+i+".png")));
			}
			catch(IOException ex){}
			}
		timerUpdate = new timer(3000,new ActionListener(){
			public void actionPerfomed(ActionEvent e) {
				updateStart();
			}
		});
		timerUpdate.start();
		timerDraw = new Timer(50,new ActionListener(){
			public void actionPerfomed(ActionEvent e){
				repaint();
				
			});
		timerDraw.start();	
		}
		public void paintComponent(Graphics gr)
		{
			super.paintComponent(gr);
			gr.drawImage(fon, 0, 0, null);
			gr.drawImage(shapka,x,465,null);
			for (int i=0;i<7;i++)
			{
				gamePodar[i].draw(gr);
				if (game Podar[i].act==true)
				{
					if ((gamePodar[i].y+gamePodar[i].img.getHeight(null))>=47o)
						if (Math.abs(gamePodar[i].x-x)>75)
						{
							gr.drawImage(end_game,300,300,null);
							timerDraw.stop();
							timerUpdate.stop();
							break;
						}
						else gamePodar[i].act=false;
						}
				}
			}
		}
	private void updateStart()
	{
		int kol = 0;
		for (int i=0;i<7;i++)
		{
			if (gamePodar[i].act==false)
			{
				if (kol<slogn)
				{
					gamePodar[i].start();
					break;
				}
			}
			else kol++;
		}
	}
}