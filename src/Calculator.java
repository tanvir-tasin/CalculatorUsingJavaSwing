import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Frame extends JFrame implements ActionListener {
    JButton[] numberButton=new JButton[10];
    JButton[] functionButton=new JButton[8];
    JFrame frame;
    JTextField textField;
    JPanel panel;



    char operator;
    Double num1=0.0;
    Double num2=0.0;
    Double result=0.0;
    Double multipleresult=1.0;
    JButton delbtn,clrbtn,addbtn,subbtn,decbtn,equbtn,mulbtn,divbtn;
    Frame()
    {

        frame=new JFrame("Calculator");

        frame.setSize(380,480);
        frame.getContentPane().setBackground(new Color(0xD923D1DB, true));
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         textField=new JTextField();
        textField.setBounds(40,20,280,40);
        frame.add(textField);

       textField.setFont(new Font("Ink Free " ,Font.BOLD,20));


        ImageIcon img1=new ImageIcon("calculator.jpg");

        frame.setIconImage(img1.getImage());



        clrbtn=new JButton("Clear");
        addbtn=new JButton("+");
        subbtn=new JButton("-");
        decbtn=new JButton(".");
        equbtn=new JButton("=");
        mulbtn=new JButton("*");
        divbtn=new JButton("/");
        delbtn=new JButton("Del");
        functionButton[0]=clrbtn;
        functionButton[2]=delbtn;
        functionButton[1]=addbtn;
        functionButton[3]=subbtn;
        functionButton[4]=decbtn;
        functionButton[5]=equbtn;
        functionButton[6]=mulbtn;
        functionButton[7]=divbtn;

        for(int i=0;i<8;i++)
        {
functionButton[i].addActionListener(this);
//functionButton[i].setFont();
functionButton[i].setFocusable(false);
        }
        for(int i=0;i<10;i++)
        {
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFocusable(false);
        }



delbtn.setBounds(75,380,90,40);
        clrbtn.setBounds(175,380,90,40);
         panel=new JPanel();
        panel.setBounds(40,70,280,300);
        panel.setVisible(true);
        panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(addbtn);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(mulbtn);
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);

        panel.add(subbtn);
        panel.add(decbtn);
        panel.add(numberButton[0]);
        panel.add(equbtn);
        panel.add(divbtn);


        frame.add(panel);


        frame.add(delbtn);
        decbtn.setFocusable(false);
        frame.add(clrbtn);
        clrbtn.setFocusable(false);
        panel.setBackground(Color.cyan);

        frame.repaint();
        frame.setVisible(true);


    }

    @Override

    public void actionPerformed(ActionEvent e) {
for(int i=0;i<10;i++)
{
    if(e.getSource()==numberButton[i])
    {
textField.setText(textField.getText()+String.valueOf(i));
    }
}
if(e.getSource()==addbtn)
{
    operator='+';
    textField.setText(textField.getText()+operator);

}
        if(e.getSource()==subbtn)
        {
            operator='-';
            textField.setText(textField.getText()+operator);

        }
        if(e.getSource()==mulbtn)
        {
            operator='*';
            textField.setText(textField.getText()+operator);

        }
        if(e.getSource()==divbtn)
        {
            operator='/';
            textField.setText(textField.getText()+operator);

        }
        if(e.getSource()==decbtn)
        {

            textField.setText(textField.getText()+".");

        }
        if(e.getSource()==equbtn)
        {
            String str=textField.getText();
            String[] strArray;
           switch (operator)
           {
               case '+': strArray= str.split("\\+");
               for(int i=0;i<strArray.length;i++)
               {
                   result+=Double.parseDouble(strArray[i]);
               }
               textField.setText(String.valueOf(result));
               result=0.0;
               break;

               case '*': strArray= str.split("\\*");
                   for(int i=0;i<strArray.length;i++)
                   {
                       multipleresult*=Double.parseDouble(strArray[i]);
                   }
                   textField.setText(String.valueOf(multipleresult));
                   multipleresult=1.0;
                   break;
               case '/': strArray= str.split("/");
               result=Double.parseDouble(String.valueOf(strArray[0]))/Double.parseDouble(String.valueOf(strArray[1]));
               textField.setText(String.valueOf(result));
               result=0.0;
               break;
               case '-': strArray= str.split("-");
                   result=Double.parseDouble(String.valueOf(strArray[0]))-Double.parseDouble(String.valueOf(strArray[1]));
                   textField.setText(String.valueOf(result));
                   result=0.0;
           }
           if(e.getSource()==delbtn)
           {
               textField.setText("");

           }

           }
        if(e.getSource()==delbtn)
        {
            String str1=textField.getText();
            textField.setText("");
            for(int i=0;i<str1.length()-1;i++)
            {
                textField.setText(textField.getText()+str1.charAt(i));

            }
        }
        if(e.getSource()==clrbtn)
        {
            textField.setText("");
        }



    }
}
public class Calculator
{
    public static void main(String[] args) {
        new Frame();

    }
}

