package arno;

/**
 * @author Arno
 * @date:2016年4月9日 下午2:48:01
 */
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


class CrackUi{
	private JFrame frame;
	private JTextField text11,text12,text21,text22;
	private JLabel label11,label12,label21,label22,label31,label32;
	private JLabel none1,none2;
	private JButton but1,but2;
	public CrackUi(){
		frame=new JFrame();
//		but1=new JButton("计算");
//		b2=new JButton("+");
//		text1=new JTextField(7);
//		text2=new JTextField(7);
//		lable=new JLabel("0");
		
		label11=new JLabel("卡号");
		text11=new JTextField(10);
		label12=new JLabel("扇区");
		text12=new JTextField("12");
		but1=new JButton("破解");
//		填充
		none1=new JLabel("Cyanide Group");
		
		label21=new JLabel("金额");
		text21=new JTextField(10);
		label22=new JLabel("金额代码");	
		text22=new JTextField(10);
		but2=new JButton("计算");
		none2=new JLabel("——M.A.R");
		
		label31=new JLabel("Made by Arno Frost");
		label32=new JLabel(" ————version 1.30");
		
		but1.addActionListener(new Mylistener1());
		but2.addActionListener(new Mylistener2());
		

		frame.setLayout(new GridLayout(3,5));
		
		frame.add(label11);
		frame.add(text11);	
		frame.add(label12);
		frame.add(text12);
		frame.add(but1);
		
		frame.add(label21);
		frame.add(text21);
		frame.add(label22);
		frame.add(text22);
		frame.add(but2);
		frame.add(none2);
		
		frame.add(none1);
		frame.add(none2);
		
		frame.add(label31);
		frame.add(label32);
		
		
		frame.setBounds(300,300,600,120);
		
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {

				System.out.println("程序关闭");
				System.exit(1);
			}
		});
		
	}
	
	class Mylistener1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
//		获取到需要破解的水卡卡号
			String str1=text11.getText();
			Integer area=Integer.parseInt(text12.getText());
//			System.out.println(area);
//			System.out.println(str1);
			new CrackArno();
//			调用crack方法传入参数为String类型
			String str1re=CrackArno.CrackAl(str1,area);
			text12.setText(str1re);	
//			lable1.setText(str1re);	

			
		}
		
	}
	class Mylistener2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
//			获取到需要的金额值
			String str2=text21.getText();
//			System.out.println(str1);
//			调用edit方法传入String的金额数
			new EditNew();
			String str2re=EditNew.EditNewC(str2);
//			lable2.setText(str2re);
			text22.setText(str2re);


		}
		
	}
		
}
public class UI{
	public static void main(String[] args) {
		new CrackUi();
	}
}




