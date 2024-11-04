package org.example;

import java.util.Arrays;
import java.util.Locale;

public class CheckConditions {

    public static boolean processContains(Object val) {

        Object var2 = val;
        if (var2 instanceof String data) {
            String[] tokens = String.valueOf(getConfiguredValue()).split(",");
            String[] var3 = tokens;
            int var4 = tokens.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String token = var3[var5];
                if (data.trim().toLowerCase(Locale.ROOT).contains(token.trim().toLowerCase(Locale.ROOT))) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean processGreaterThanEqualTo(Object ruleExpression) {
        Object data1 = ruleExpression;
        if (data1 instanceof Integer data) {
            return data >= (Integer.parseInt(String.valueOf(getConfiguredValue())));

        } else if (data1 instanceof Float data) {
            return data >= (Float.parseFloat(String.valueOf(getConfiguredValue())));

        } else if (data1 instanceof Double data) {
            return data >= (Double.parseDouble(String.valueOf(getConfiguredValue())));

        } else if (data1 instanceof Long data) {
            return data >= (Long.parseLong(String.valueOf(getConfiguredValue())));
        }
        return false;

    }

    private static Object getConfiguredValue() {

        return ("100");
    }

}
