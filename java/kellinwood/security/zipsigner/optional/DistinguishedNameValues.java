package kellinwood.security.zipsigner.optional;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Vector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x500.style.BCStyle;
import org.spongycastle.jce.X509Principal;

public class DistinguishedNameValues extends LinkedHashMap<ASN1ObjectIdentifier, String> {
    public DistinguishedNameValues() {
        put(BCStyle.C, null);
        put(BCStyle.ST, null);
        put(BCStyle.L, null);
        put(BCStyle.STREET, null);
        put(BCStyle.O, null);
        put(BCStyle.OU, null);
        put(BCStyle.CN, null);
    }

    public String put(ASN1ObjectIdentifier oid, String value) {
        if (value != null && value.equals("")) {
            value = null;
        }
        if (containsKey(oid)) {
            super.put(oid, value);
        } else {
            super.put(oid, value);
        }
        return value;
    }

    public void setCountry(String country) {
        put(BCStyle.C, country);
    }

    public void setState(String state) {
        put(BCStyle.ST, state);
    }

    public void setLocality(String locality) {
        put(BCStyle.L, locality);
    }

    public void setStreet(String street) {
        put(BCStyle.STREET, street);
    }

    public void setOrganization(String organization) {
        put(BCStyle.O, organization);
    }

    public void setOrganizationalUnit(String organizationalUnit) {
        put(BCStyle.OU, organizationalUnit);
    }

    public void setCommonName(String commonName) {
        put(BCStyle.CN, commonName);
    }

    public int size() {
        int result = 0;
        for (String value : values()) {
            if (value != null) {
                result++;
            }
        }
        return result;
    }

    public X509Principal getPrincipal() {
        Vector<ASN1ObjectIdentifier> oids = new Vector();
        Vector<String> values = new Vector();
        for (Entry<ASN1ObjectIdentifier, String> entry : entrySet()) {
            if (!(entry.getValue() == null || ((String) entry.getValue()).equals(""))) {
                oids.add(entry.getKey());
                values.add(entry.getValue());
            }
        }
        return new X509Principal(oids, values);
    }
}
