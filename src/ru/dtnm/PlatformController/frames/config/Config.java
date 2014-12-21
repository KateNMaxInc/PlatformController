package ru.dtnm.PlatformController.frames.config;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>��������:  </p>
 * <p>�����: maxie </p>
 * <p>������: 0.0.1 </p>
 */
public class Config {

    public static final String VERSION = "v.0.0.1";
    // ������ ������������ ���������
    public static final Integer[] BAUDS = {9600,4800,7200,14400,19200,28800,38400,57600,115200,250000,300000,375000,500000,750000,1500000};
    // �������� ��������
    public static final Integer[] BITS = {8, 5, 6, 7};
    // �������� ���-�� �������� ���
    public static final Integer[] STOPS = {1,2,3};
    // �������� �������� ��������
    public static final Map<String, Integer> PARITIES = new HashMap<String, Integer>(){{
        put("PARITY_NONE",0);
        put("PARITY_ODD",1);
        put("PARITY_EVEN",2);
        put("PARITY_MARK",3);
        put("PARITY_SPACE",4);
    }};
}
