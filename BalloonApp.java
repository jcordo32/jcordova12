package Balloon;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class BalloonApp extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					BalloonApp frame = new BalloonApp();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BalloonApp()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblLabBalloon = new JLabel("Lab Balloon");
		lblLabBalloon.setFocusable(false);
		lblLabBalloon.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblLabBalloon.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabBalloon.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblLabBalloon, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(25);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnGenerateBalloons = new JButton("Generate Balloons");
		
		btnGenerateBalloons.setFocusable(false);
		btnGenerateBalloons.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnGenerateBalloons);
		
		JLabel lblResults = new JLabel("(Results)");
		lblResults.setFocusable(false);
		lblResults.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblResults);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 2, 25, 0));
		
		JLabel lblBalloon1 = new JLabel("Balloon1");
		lblBalloon1.setVisible(false);
		lblBalloon1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblBalloon1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblBalloon1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalloon1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblBalloon1.setIcon(new ImageIcon(BalloonApp.class.getResource("/images/balloon20.jpg")));
		lblBalloon1.setOpaque(true);
		lblBalloon1.setBackground(Color.WHITE);
		panel_1.add(lblBalloon1);
		
		JLabel Balloon2 = new JLabel("Balloon2");
		Balloon2.setVisible(false);
		Balloon2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Balloon2.setHorizontalTextPosition(SwingConstants.CENTER);
		Balloon2.setHorizontalAlignment(SwingConstants.CENTER);
		Balloon2.setVerticalTextPosition(SwingConstants.BOTTOM);
		Balloon2.setIcon(new ImageIcon(BalloonApp.class.getResource("/images/balloon80.jpg")));
		Balloon2.setOpaque(true);
		Balloon2.setBackground(Color.WHITE);
		panel_1.add(Balloon2);
		
		btnGenerateBalloons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblBalloon1.setVisible(true);
				Balloon2.setVisible(true);
		     Random rand = new Random();
				Balloon b1 = new Balloon (Size.values()[rand.nextInt(Size.values().length)], rand.nextBoolean());
				Balloon b2 = new Balloon (Size.values()[rand.nextInt(Size.values().length)], rand.nextBoolean());
				
				lblBalloon1.setIcon(new ImageIcon(BalloonApp.class.getResource(b1.getImagePath())));
				Balloon2.setIcon(new ImageIcon(BalloonApp.class.getResource(b2.getImagePath())));
				lblBalloon1.setText(b1.toString());
				Balloon2.setText(b2.toString());
				if (b1.equals(b2)) 
					lblResults.setText("Match!");
				else
					lblResults.setText("No Match");
				
			}
		});
	}
}
