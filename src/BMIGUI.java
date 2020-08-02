//Calculator to calculate BMI
//Name: Intan Najihah Samsudin
//matric No: BI19110164

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class BMIGUI extends JFrame {
    // static method main
    public static void main(String[] args) {
        BMIGUI window = new BMIGUI();
        window.setVisible(true);
    }

    // instance variables
    // Declare and initialize instance variables that are
 
    private final JTextField _mField   = new JTextField(4);  // height
    private final JTextField _kgField  = new JTextField(4);  // weight
    private final JTextField _bmiField = new JTextField(4);  // BMI

    // constructor
    public BMIGUI() {
        //... Create button and add action listener.
        JButton bmiButton = new JButton("Compute BMI");
        bmiButton.addActionListener(new BMIListener());

        //Set layout and add components.
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Weight in kilograms"));
        content.add(_kgField);
        content.add(new JLabel("Height in meters"));
        content.add(_mField);
        content.add(bmiButton);
        content.add(new JLabel("Your BMI is"));
        content.add(_bmiField);

        // Set the window characteristics.
        setContentPane(content);
        setTitle("Body Mass Index");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();                          // Do layout.
        setLocationRelativeTo(null);     // Center window.
    }

    // inner class BMIListener
    // Inner class is used to access components.
    private class BMIListener implements ActionListener {
     
        @Override
        public void actionPerformed(ActionEvent e) {
            double kilograms = Double.parseDouble(_kgField.getText());
            double meters    = Double.parseDouble(_mField.getText());
            int    bmi       = (int)computeBMI(kilograms, meters);
            _bmiField.setText("" + bmi);
        }
    }

    //formula to computeBMI
    public static double computeBMI(double weight, double height) {
        return weight / (height * height);
    }
}