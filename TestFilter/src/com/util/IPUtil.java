package com.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 要过滤的ip
 */
public class IPUtil {
    private static List<String> ipList = new ArrayList<>();

    static{
        ipList.add("192.168.43.51");
    }
    public static List<String> getIpList(){
        return ipList;
    }
}
