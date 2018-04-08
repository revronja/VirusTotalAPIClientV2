import javax.swing.*;
import java.awt.event.*;

//test hash is 99017f6eebbac24f351415dd410d522d

public class New02 extends JPanel implements ActionListener
{
	JLabel lblName;
	JTextField txtName;
	JTextArea respBody;
	JButton btnIcon;
	//ImageIcon imgIcon;
	RestAPIClient01 newreq = new RestAPIClient01();
	private JScrollPane scrollPane;

	public New02()
	{
		setLayout(null);
		lblName = new JLabel("Enter MD5/SHA-1/SHA-256 : ");
		txtName = new JTextField(15);
		btnIcon = new JButton("Retrieve report");
		btnIcon.addActionListener(this);
		
		lblName.setBounds(10,20,120,25);
		txtName.setBounds(150,20,150,25);
		btnIcon.setBounds(120,100,150,30);
		
		//Add labels to the Panel.
		add(lblName);
		add(txtName);
		add(btnIcon);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 140, 330, 129);
		add(scrollPane);
		respBody = new JTextArea(10,10);
		scrollPane.setViewportView(respBody);
	
		
		
	}
	public void actionPerformed(ActionEvent actEvt)
	{
		if (actEvt.getSource() == btnIcon)
		{
			String phonenum = txtName.getText();
			try {
				newreq.sendGet(phonenum);
				respBody.append("Phone number valid: " + RestAPIClient01.valid + "\n");
				respBody.append("Local format: " + RestAPIClient01.localformat + "\n");
				respBody.append("International format: " + RestAPIClient01.intformat + "\n");
				respBody.append("Location: " + RestAPIClient01.location + "\n");
				respBody.append("Carrier: " + RestAPIClient01.carrier + "\n");
				respBody.append("Countrycode: " + RestAPIClient01.countrycode + "\n");
				respBody.append("Linetype: " + RestAPIClient01.linetype + "\n");
				
				
			} catch (Exception e) {
				System.out.println(e + " Exception thrown.");
			}
			// output can go here ?
			//taRemarks.append("Carrier: " + newreq.sendGet(phonenum).Number;)
			
		}
	}



	
	public static void main(String[] args) {
		New02 newgui = new New02();
		
		// set text on frame
		JFrame frame = new JFrame("Search Virustotal App");
		frame.setContentPane(newgui);
		
		// setSize() methods is used to specify the width and height of the frame
		frame.setSize(400,300);

		// To display the Frame
		frame.setVisible(true);
		
		WindowListener listener = new WindowAdapter()
		{
			public void windowClosing(WindowEvent winEvt)
			{
				System.exit(0);
			}
		};  // End of WindowAdaptor() method

		// Window listener activates the windowClosing() method
		frame.addWindowListener(listener);
	}
		

	}


