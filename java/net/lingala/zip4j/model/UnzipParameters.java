/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package net.lingala.zip4j.model;

public class UnzipParameters {
    private boolean ignoreAllFileAttributes;
    private boolean ignoreArchiveFileAttribute;
    private boolean ignoreDateTimeAttributes;
    private boolean ignoreHiddenFileAttribute;
    private boolean ignoreReadOnlyFileAttribute;
    private boolean ignoreSystemFileAttribute;

    public boolean isIgnoreAllFileAttributes() {
        return this.ignoreAllFileAttributes;
    }

    public boolean isIgnoreArchiveFileAttribute() {
        return this.ignoreArchiveFileAttribute;
    }

    public boolean isIgnoreDateTimeAttributes() {
        return this.ignoreDateTimeAttributes;
    }

    public boolean isIgnoreHiddenFileAttribute() {
        return this.ignoreHiddenFileAttribute;
    }

    public boolean isIgnoreReadOnlyFileAttribute() {
        return this.ignoreReadOnlyFileAttribute;
    }

    public boolean isIgnoreSystemFileAttribute() {
        return this.ignoreSystemFileAttribute;
    }

    public void setIgnoreAllFileAttributes(boolean bl) {
        this.ignoreAllFileAttributes = bl;
    }

    public void setIgnoreArchiveFileAttribute(boolean bl) {
        this.ignoreArchiveFileAttribute = bl;
    }

    public void setIgnoreDateTimeAttributes(boolean bl) {
        this.ignoreDateTimeAttributes = bl;
    }

    public void setIgnoreHiddenFileAttribute(boolean bl) {
        this.ignoreHiddenFileAttribute = bl;
    }

    public void setIgnoreReadOnlyFileAttribute(boolean bl) {
        this.ignoreReadOnlyFileAttribute = bl;
    }

    public void setIgnoreSystemFileAttribute(boolean bl) {
        this.ignoreSystemFileAttribute = bl;
    }
}

