package com.tn.task.ipcatcher;

import com.tn.task.neededclass.IP;

public class JsonGetter {
    GetIpFrom getIpFrom;

    public static IP takeIp(GetIpFrom getIpFrom, String whereJson) {
        return getIpFrom.ipFromAnywhere(whereJson);
    }
}
