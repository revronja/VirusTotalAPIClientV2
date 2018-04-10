import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Map;

//test hash is 99017f6eebbac24f351415dd410d522d

public class New02 extends JPanel implements ActionListener
{
	JLabel lblName;
	JTextField txtName;
	JTextArea respBody;
	JButton btnIcon;
	//ImageIcon imgIcon;
	RestAPIClient01 newreq = new RestAPIClient01();
	TimeDifference td = new TimeDifference();
	private JScrollPane scrollPane;

	public New02()
	{
		setLayout(null);
		lblName = new JLabel("Enter MD5/SHA-1/SHA-256 : ");
		txtName = new JTextField(15);
		btnIcon = new JButton("Retrieve report");
		btnIcon.addActionListener(this);
		
		lblName.setBounds(10,20,191,25);
		txtName.setBounds(202,19,271,25);
		btnIcon.setBounds(189,100,150,30);
		
		//Add labels to the Panel.
		add(lblName);
		add(txtName);
		add(btnIcon);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 485, 174);
		add(scrollPane);
		respBody = new JTextArea(10,10);
		scrollPane.setViewportView(respBody);
	
		
		
	}
	public void actionPerformed(ActionEvent actEvt)
	{
		if (actEvt.getSource() == btnIcon)
		{
			String checksum = txtName.getText();
			try {
				newreq.sendGet(checksum);
				respBody.append("Report found: " + RestAPIClient01.message + "\n");
				respBody.append("Response code: " + RestAPIClient01.responsecode + "\n");
				respBody.append("Verbose message: " + RestAPIClient01.verbosemsg + "\n");
				respBody.append("Resource searched for: " + RestAPIClient01.resource + "\n");
				respBody.append("Md5: " + RestAPIClient01.md5 + "\n");
				respBody.append("Sha1: " + RestAPIClient01.sha1 + "\n");
				respBody.append("Sha256: " + RestAPIClient01.sha256 + "\n");
				respBody.append("Scandate: " + RestAPIClient01.scandate + "\n");
				respBody.append("Permalink: " + RestAPIClient01.permalink + "\n");
				respBody.append("Positive: " + RestAPIClient01.positive + "\n");
				respBody.append("Total: " + RestAPIClient01.total + "\n");
				respBody.append("% of AVs that detected: " + RestAPIClient01.percent + "\n");
				Iterator<Map.Entry> itr1 = RestAPIClient01.avs.entrySet().iterator();
		        while (itr1.hasNext()) {
		            Map.Entry pair = itr1.next();
		            respBody.append(pair.getKey() + " : " + pair.getValue() + "\n");
		            //System.out.println(pair.getKey() + " : " + pair.getValue());
		        }
		        TimeDifference.a = LocalDateTime.now();
		        TimeDifference.b = TimeDifference.FormatDateString("2010-05-15 03:38:44");
		        TimeDifference.hr = TimeDifference.a.getHour() - TimeDifference.b.getHour();
			    TimeDifference.mn = TimeDifference.a.getMinute() - TimeDifference.b.getMinute();
		        TimeDifference.c = TimeDifference.TimeDiffer(TimeDifference.a,TimeDifference.b);
		        respBody.append("Last scan was " + TimeDifference.c.getYears() + " years, " + TimeDifference.c.getDays()+ " days, "+TimeDifference.hr+ " hours, "+TimeDifference.mn+ " minutes ago." + "\n");
				
				
			} catch (Exception e) {
				System.out.println(e + " Exception thrown.");
			}
			
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


