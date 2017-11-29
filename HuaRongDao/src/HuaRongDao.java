import java.awt.*;
import java.awt.event.*;
import java.security.PublicKey;
import java.time.Duration;

public class HuaRongDao extends Frame implements MouseListener,KeyListener,ActionListener
{
	Person person[] = new Person[10];
	Button left,right,above,bleow;
	Button restart = new Button("ÖØÐÂ¿ªÊ¼");
	

	public HuaRongDao() 
	{
		init();
		setBounds(100, 100, 320, 320);
		setVisible(true);
		validate();
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}

	public void init() 
	{
		setLayout(null);
		add(restart);
		restart.setBounds(100, 320, 120, 25);
		restart.addActionListener(this);
		String name[] = {"²Ü²Ù","¹ØÓð","ÕÅ·É","Áõ±¸","ÕÔÔÆ","»ÆÖÒ","±ø","±ø","±ø","±ø"};
		for(int k=0; k<name.length; k++)
		{
			person[k] = new Person(k, name[k]);
			person[k].addMouseListener(this);
			person[k].addMouseListener(this);
			add(person[k]);
		}
		person[0].setBounds(104, 54, 100, 100);
		person[1].setBounds(104, 154, 100, 50);
		person[2].setBounds(54, 154, 50, 100);
		person[3].setBounds(204, 154, 50, 100);
		person[4].setBounds(54, 54, 50, 100);
		person[5].setBounds(204, 54, 50, 100);
		person[6].setBounds(54, 254, 50, 50);
		person[7].setBounds(204, 254, 50, 50);
		person[8].setBounds(104, 204, 50, 50);
		person[9].setBounds(154, 204, 50, 50);
		person[9].requestFocus();
		
		left = new Button();
		right = new Button();
		above = new Button();
		bleow = new Button();
		
		add(left);
		add(right);
		add(above);
		add(bleow);
		
		left.setBounds(49, 49, 5, 260);
		right.setBounds(254, 49, 5, 260);
		above.setBounds(49, 49, 210, 5);
		bleow.setBounds(49, 304, 210, 5);
		
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
		new HuaRongDao();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Person man = (Person)e.getSource();
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			go(man, bleow);
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			go(man, above);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			go(man, left);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			go(man, right);
		}
	}

	private void go(Person man, Button direction) {
		// TODO Auto-generated method stub
		boolean move = true;
		Rectangle manRec = man.getBounds();
		int x = man.getBounds().x;
		int y = man.getBounds().y;
		
		if(direction == bleow)
		{
			y = y+50;
		}
		else if(direction == above)
		{
			y = y-50;
		}
		else if(direction == left)
		{
			x = x-50;
		}
		else if(direction == right)
		{
			x = x+50;
		}
		manRec.setLocation(x, y);
		Rectangle directionRect = direction.getBounds();
		for(int k=0; k<10; k++)
		{
			Rectangle personRect = person[k].getBounds();
			if(manRec.intersects(personRect)&&(man.number != k))
			{
				move = false;
			}
		}
		
		if(manRec.intersects(directionRect))
		{
			move = false;
		}
		if(move == true)
		{
			man.setLocation(x, y);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Person man = (Person)e.getSource();
		int x=-1,y=-1;
		x = e.getX();
		y = e.getY();
		int w = man.getBounds().width;
		int h = man.getBounds().height;
		
		if(y > h/2)
		{
			go(man, bleow);
		}
		if(y < h/2)
		{
			go(man, above);
		}
		if(x < w/2)
		{
			go(man, left);
		}
		if(x > w/2)
		{
			go(man, right);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
