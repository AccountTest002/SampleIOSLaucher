package android.support.p001v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import java.util.ArrayList;

/* renamed from: android.support.v4.media.session.PlaybackStateCompat */
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new C0102a();

    /* renamed from: c */
    public final int f247c;

    /* renamed from: d */
    public final long f248d;

    /* renamed from: e */
    public final long f249e;

    /* renamed from: f */
    public final float f250f;

    /* renamed from: g */
    public final long f251g;

    /* renamed from: h */
    public final int f252h;

    /* renamed from: i */
    public final CharSequence f253i;

    /* renamed from: j */
    public final long f254j;

    /* renamed from: k */
    public final ArrayList f255k;

    /* renamed from: l */
    public final long f256l;

    /* renamed from: m */
    public final Bundle f257m;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction */
    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new C0101a();

        /* renamed from: c */
        public final String f258c;

        /* renamed from: d */
        public final CharSequence f259d;

        /* renamed from: e */
        public final int f260e;

        /* renamed from: f */
        public final Bundle f261f;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$a */
        /* loaded from: classes.dex */
        public static class C0101a implements Creator<CustomAction> {
            @Override // android.os.Parcelable.Creator
            public final CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        }

        public CustomAction(Parcel parcel) {
            this.f258c = parcel.readString();
            this.f259d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f260e = parcel.readInt();
            this.f261f = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f259d) + ", mIcon=" + this.f260e + ", mExtras=" + this.f261f;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f258c);
            TextUtils.writeToParcel(this.f259d, parcel, i);
            parcel.writeInt(this.f260e);
            parcel.writeBundle(this.f261f);
        }
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$a */
    /* loaded from: classes.dex */
    public static class C0102a implements Creator<PlaybackStateCompat> {
        @Override // android.os.Parcelable.Creator
        public final PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f247c = parcel.readInt();
        this.f248d = parcel.readLong();
        this.f250f = parcel.readFloat();
        this.f254j = parcel.readLong();
        this.f249e = parcel.readLong();
        this.f251g = parcel.readLong();
        this.f253i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f255k = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f256l = parcel.readLong();
        this.f257m = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f252h = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "PlaybackState {state=" + this.f247c + ", position=" + this.f248d + ", buffered position=" + this.f249e + ", speed=" + this.f250f + ", updated=" + this.f254j + ", actions=" + this.f251g + ", error code=" + this.f252h + ", error message=" + this.f253i + ", custom actions=" + this.f255k + ", active item id=" + this.f256l + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f247c);
        parcel.writeLong(this.f248d);
        parcel.writeFloat(this.f250f);
        parcel.writeLong(this.f254j);
        parcel.writeLong(this.f249e);
        parcel.writeLong(this.f251g);
        TextUtils.writeToParcel(this.f253i, parcel, i);
        parcel.writeTypedList(this.f255k);
        parcel.writeLong(this.f256l);
        parcel.writeBundle(this.f257m);
        parcel.writeInt(this.f252h);
    }
}
