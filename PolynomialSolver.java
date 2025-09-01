import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigInteger;
import java.util.Scanner;

public class PolynomialSolver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        while (sc.hasNextLine()) {
            input.append(sc.nextLine());
        }
        sc.close();

        JSONObject json = new JSONObject(input.toString());
        JSONArray keys = json.getJSONArray("keys");
        int n = json.getInt("n");
        int k = json.getInt("k");

        BigInteger[] roots = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            JSONObject obj = keys.getJSONObject(i);
            int base = Integer.parseInt(obj.getString("base"));
            String value = obj.getString("value");
            roots[i] = new BigInteger(value, base);
        }


        BigInteger[] coeffs = { BigInteger.ONE };

        for (BigInteger root : roots) {
            coeffs = multiply(coeffs, root.negate());
        }

        JSONObject output = new JSONObject();
        JSONArray coeffArray = new JSONArray();

        for (BigInteger c : coeffs) {
            coeffArray.put(c.toString());
        }
        output.put("coefficients", coeffArray);

        System.out.println(output.toString(2));
    }


    private static BigInteger[] multiply(BigInteger[] coeffs, BigInteger root) {
        BigInteger[] newCoeffs = new BigInteger[coeffs.length + 1];
        for (int i = 0; i < newCoeffs.length; i++) {
            newCoeffs[i] = BigInteger.ZERO;
        }

        for (int i = 0; i < coeffs.length; i++) {
           
            newCoeffs[i] = newCoeffs[i].add(coeffs[i]);
          
            newCoeffs[i + 1] = newCoeffs[i + 1].add(coeffs[i].multiply(root));
        }

        return newCoeffs;
    }
}
