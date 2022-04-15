package com.tn.task.ipcatcher;

import com.tn.task.neededclass.IP;

public class IpGet {
    private static final String DEFAULTURL = "https://api.ipify.org/?format=json";
    private static final String DEFAULTFILE = "jsonhere.txt";
    public interface jsonGet {
        default IP ipGetFromFile(String fileWhereJson) {
            return GetIpFrom.ipGetFromFile(fileWhereJson);
        }

        default IP ipGetFromUrl(String urlWhereJson) {
            return GetIpFrom.ipGetFromUrl(urlWhereJson);
        }

        default IP ipFromUrlOrFile(String[] args) {
            if(args[0].equals("url")) {
                return ipGetFromUrl(args[1].equals("default")?DEFAULTURL:args[1]);
            } else{
                return ipGetFromFile(args[1].equals("default")?DEFAULTFILE:args[1]);
            }
        }
    }
}
