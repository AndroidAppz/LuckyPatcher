/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  java.lang.Object
 *  java.lang.String
 */
package com.proxoid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IProxoidControl
extends IInterface {
    public boolean update() throws RemoteException;

    public static abstract class Stub
    extends Binder
    implements IProxoidControl {
        private static final String DESCRIPTOR = "com.proxoid.IProxoidControl";
        static final int TRANSACTION_update = 1;

        public Stub() {
            this.attachInterface((IInterface)this, "com.proxoid.IProxoidControl");
        }

        public static IProxoidControl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.proxoid.IProxoidControl");
            if (iInterface != null && iInterface instanceof IProxoidControl) {
                return (IProxoidControl)iInterface;
            }
            return new Proxy(iBinder);
        }

        public IBinder asBinder() {
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean onTransact(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
            switch (n) {
                default: {
                    return super.onTransact(n, parcel, parcel2, n2);
                }
                case 1598968902: {
                    parcel2.writeString("com.proxoid.IProxoidControl");
                    return true;
                }
                case 1: 
            }
            parcel.enforceInterface("com.proxoid.IProxoidControl");
            boolean bl = this.update();
            parcel2.writeNoException();
            int n3 = bl ? 1 : 0;
            parcel2.writeInt(n3);
            return true;
        }

        private static class Proxy
        implements IProxoidControl {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "com.proxoid.IProxoidControl";
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public boolean update() throws RemoteException {
                boolean bl = true;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.proxoid.IProxoidControl");
                    this.mRemote.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    int n = parcel2.readInt();
                    if (n == 0) {
                        bl = false;
                    }
                    return bl;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }

    }

}

