package arno;

/**
 * @author Arno
 * @date:2016��4��9�� ����2:48:01
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
//		but1=new JButton("����");
//		b2=new JButton("+");
//		text1=new JTextField(7);
//		text2=new JTextField(7);
//		lable=new JLabel("0");
		
		label11=new JLabel("����");
		text11=new JTextField(10);
		label12=new JLabel("����");
		text12=new JTextField("12");
		but1=new JButton("�ƽ�");
//		���
		none1=new JLabel("Cyanide Group");
		
		label21=new JLabel("���");
		text21=new JTextField(10);
		label22=new JLabel("������");	
		text22=new JTextField(10);
		but2=new JButton("����");
		none2=new JLabel("����M.A.R");
		
		label31=new JLabel("Made by Arno Frost");
		label32=new JLabel(" ��������version 1.30");
		
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

				System.out.println("����ر�");
				System.exit(1);
			}
		});
		
	}
	
	class Mylistener1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
//		��ȡ����Ҫ�ƽ��ˮ������
			String str1=text11.getText();
			Integer area=Integer.parseInt(text12.getText());
//			System.out.println(area);
//			System.out.println(str1);
			new CrackArno();
//			����crack�����������ΪString����
			String str1re=CrackArno.CrackAl(str1,area);
			text12.setText(str1re);	
//			lable1.setText(str1re);	

			
		}
		
	}
	class Mylistener2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
//			��ȡ����Ҫ�Ľ��ֵ
			String str2=text21.getText();
//			System.out.println(str1);
//			����edit��������String�Ľ����
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




