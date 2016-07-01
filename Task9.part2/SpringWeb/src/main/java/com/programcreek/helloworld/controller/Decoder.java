package com.programcreek.helloworld.controller;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decoder {

    public static String decode(String s) throws IOException {
        byte[] buf = new byte[400];

        ByteArrayInputStream bin = new ByteArrayInputStream(Base64.decodeBase64(s));
        XZCompressorInputStream xzIn = new XZCompressorInputStream(bin);
        xzIn.read(buf);
        xzIn.close();

        String result = new String(buf);
        return result;
    }

}
