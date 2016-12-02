/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package pxb.android.arsc;

public class ResSpec {
    public int flags;
    public final int id;
    public String name;

    public ResSpec(int n) {
        this.id = n;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void updateName(String string) {
        String string2 = this.name;
        if (string2 == null) {
            this.name = string;
            return;
        } else {
            if (string.equals((Object)string2)) return;
            {
                throw new RuntimeException();
            }
        }
    }
}

