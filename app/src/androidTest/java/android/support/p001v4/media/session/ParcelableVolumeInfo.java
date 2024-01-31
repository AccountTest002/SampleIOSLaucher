package android.support.p001v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.media.session.ParcelableVolumeInfo */
/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new C0100a();

    /* renamed from: c */
    public final int f242c;

    /* renamed from: d */
    public final int f243d;

    /* renamed from: e */
    public final int f244e;

    /* renamed from: f */
    public final int f245f;

    /* renamed from: g */
    public final int f246g;

    /* renamed from: android.support.v4.media.session.ParcelableVolumeInfo$a */
    /* loaded from: classes.dex */
    public static class C0100a implements Creator<ParcelableVolumeInfo> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableVolumeInfo[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f242c = parcel.readInt();
        this.f244e = parcel.readInt();
        this.f245f = parcel.readInt();
        this.f246g = parcel.readInt();
        this.f243d = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f242c);
        parcel.writeInt(this.f244e);
        parcel.writeInt(this.f245f);
        parcel.writeInt(this.f246g);
        parcel.writeInt(this.f243d);
    }
}
