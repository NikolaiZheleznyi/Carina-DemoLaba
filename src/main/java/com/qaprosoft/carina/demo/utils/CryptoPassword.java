package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.commons.SpecialKeywords;
import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.qaprosoft.carina.core.foundation.utils.R;

import java.util.regex.Pattern;
public class CryptoPassword {
    public static String getApiKey(){

        CryptoTool cryptoTool = new CryptoTool("/Users/nzheleznui/SOLVD/crypto.key");
        Pattern CRYPTO_PATTERN = Pattern.compile(SpecialKeywords.CRYPT);

        return (cryptoTool.decryptByPattern(R.TESTDATA.get("api_key"), CRYPTO_PATTERN).replaceAll("\\\\f1 ", "")).replaceAll("\\\\", "");

    }
    public static String getLoginKufar(){

        CryptoTool cryptoLoginKufar = new CryptoTool("/Users/nzheleznui/SOLVD/crypto.key");
        Pattern CRYPTO_PATTERN = Pattern.compile(SpecialKeywords.CRYPT);

        return (cryptoLoginKufar.decryptByPattern(R.TESTDATA.get("log_kufar"), CRYPTO_PATTERN).replaceAll("\\\\f1 ", "")).replaceAll("\\\\", "");

    }
}
