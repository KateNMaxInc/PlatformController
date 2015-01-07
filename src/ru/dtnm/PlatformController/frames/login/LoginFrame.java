package ru.dtnm.PlatformController.frames.login;

import gnu.io.CommPortIdentifier;
import ru.dtnm.PlatformController.frames.config.Config;
import ru.dtnm.PlatformController.frames.main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * <p>��������:  </p>
 * <p>�����: maxie </p>
 * <p>������: 0.0.1 </p>
 */
public class LoginFrame extends JFrame {

    private static LoginFrame instance = null;

    public static final String caption = "Login:";

    private LoginFrame() {
        super(caption);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("�������� ��������� �����������");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(82, 110, 125));
        panel.setPreferredSize(new Dimension(380,240));

        JLabel namesLabel = new JLabel("�������� ����");
        namesLabel.setBounds(20,20,150,20);
        panel.add(namesLabel);

        // �������, ����� �� ����� rxtxParallel.dll � rxtxSerial.dll � JRE_HOME/bin/
        String javaHomeDir = System.getenv("JAVA_HOME");
        String jreDir = javaHomeDir + "\\jre\\bin";
        File parallelDllTo = new File(jreDir + "\\rxtxParallel.dll");
        File serialDllTo = new File(jreDir + "\\rxtxSerial.dll");

        if (parallelDllTo.exists()) System.out.println("Parallel dll file exists");
        else {
            System.out.println("Parallel .dll file doesn't exists: " + jreDir + "\\rxtxParallel.dll");
            System.out.println("Copying it.");

            //<!TODO> � ������ ���� ������ ����������� ���� �� �������� � ������ �����
        }

        if (serialDllTo.exists()) System.out.println("Serial dll file exists");
        else {
            System.out.println("Serial .dll file doesn't exist: " + jreDir + "\\rxtxSerial.dll");
            System.out.println("Copying it.");

            //<!TODO> � ������ ���� ������ ����������� ���� �� �������� � ������ �����
        }

        // ��������� ��� ��������� �����
        Enumeration portsList = CommPortIdentifier.getPortIdentifiers();
        final List<String> portsNames = new ArrayList<String>();
        while (portsList.hasMoreElements()){
            CommPortIdentifier port = (CommPortIdentifier)portsList.nextElement();
            portsNames.add(port.getName());
            System.out.println(port.getName());
        }
        String[] names = (String[])portsNames.toArray(new String[portsNames.size()]);
        JComboBox nameCombo = new JComboBox(names);
        nameCombo.setBounds(170,20,150,20);
        panel.add(nameCombo);

        //������� �������� �����������
        final JLabel baudsLabel = new JLabel("�������� �������");
        baudsLabel.setBounds(20,50,150,20);
        panel.add(baudsLabel);

        final JComboBox baudBox = new JComboBox(Config.BAUDS);
        baudBox.setBounds(170,50,150,20);
        panel.add(baudBox);

        // ������� ���������� �������� �����
        final JLabel bitsLabel = new JLabel("��������");
        bitsLabel.setBounds(20,80,150,20);
        panel.add(bitsLabel);

        final JComboBox bitsBox = new JComboBox(Config.BITS);
        bitsBox.setBounds(170,80,150,20);
        panel.add(bitsBox);

        // ������� ���������� �������� ���
        final JLabel stopLabel = new JLabel("�������� ���");
        stopLabel.setBounds(20,110,150,20);
        panel.add(stopLabel);

        final JComboBox stopsBox = new JComboBox(Config.STOPS);
        stopsBox.setBounds(170,110,150,20);
        panel.add(stopsBox);

        // ������� �������� ��������
        final JLabel controlLabel = new JLabel("�������� ��������");
        controlLabel.setBounds(20,140,150,20);
        panel.add(controlLabel);

        final String[] keys = (String[])Config.PARITIES.keySet().toArray(new String[Config.PARITIES.keySet().size()]);
        final JComboBox controlBox = new JComboBox(keys);
        controlBox.setBounds(170,140,150,20);
        panel.add(controlBox);

        // � ������� ������ - �������, �� ������� ������������
        JButton connectBtn = new JButton("Connect");
        connectBtn.setBounds(50,180,220,40);
        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect();
            }
        });
        panel.add(connectBtn);



        add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    public static JFrame getInstance () {
        if (instance == null) try {
            instance = new LoginFrame();
            return instance;
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    /*
     * ������������� ���������� � ����������, ��������� ���� ����������
     */
    public void connect () {
        System.out.println("������ �� ������");
        MainFrame.getInstance(new OutputStream() {
            @Override
            public void write (int b) throws IOException {
                System.out.println("write");
            }
        });
        this.dispose();
//        CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(portName);
//        if (portIdentifier.isCurrentlyOwned()) {
//            log.error("Port already in use");
//        } else {
//            CommPort commPort = portId.open(this.getClass().getName(), TIMEOUT);
//
//            if (commPort instanceof SerialPort) {
//                SerialPort serialPort = (SerialPort) commPort;
//                serialPort.setSerialPortParams(9600,
//                        SerialPort.DATABITS_8,
//                        SerialPort.STOPBITS_1,
//                        SerialPort.PARITY_NONE);
//
//                InputStream in = serialPort.getInputStream();
//                OutputStream out = serialPort.getOutputStream();
//                do something with out and in
//            } else {
//                log.error("Not serial port");
//            }
//        }
    }
}
