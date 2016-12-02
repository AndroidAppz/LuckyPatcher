/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.security.KeyStore
 *  java.security.KeyStoreSpi
 *  java.security.Provider
 */
package kellinwood.security.zipsigner.optional;

import java.security.KeyStore;
import java.security.KeyStoreSpi;
import java.security.Provider;
import kellinwood.security.zipsigner.optional.JKS;
import kellinwood.security.zipsigner.optional.KeyStoreFileManager;

public class JksKeyStore
extends KeyStore {
    public JksKeyStore() {
        super((KeyStoreSpi)new JKS(), KeyStoreFileManager.getProvider(), "jks");
    }
}

