package android.support.p001v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p001v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

/* renamed from: android.support.v4.media.MediaDescriptionCompat */
/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new C0093a();

    /* renamed from: c */
    public final String f226c;

    /* renamed from: d */
    public final CharSequence f227d;

    /* renamed from: e */
    public final CharSequence f228e;

    /* renamed from: f */
    public final CharSequence f229f;

    /* renamed from: g */
    public final Bitmap f230g;

    /* renamed from: h */
    public final Uri f231h;

    /* renamed from: i */
    public final Bundle f232i;

    /* renamed from: j */
    public final Uri f233j;

    /* renamed from: k */
    public Object f234k;

    /* renamed from: android.support.v4.media.MediaDescriptionCompat$a */
    /* loaded from: classes.dex */
    public static class C0093a implements Creator<MediaDescriptionCompat> {
        @Override // android.os.Parcelable.Creator
        public final MediaDescriptionCompat createFromParcel(Parcel parcel) {
            Creator creator;
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            creator = MediaDescription.CREATOR;
            return MediaDescriptionCompat.m6137b(creator.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    }

    public MediaDescriptionCompat(Parcel parcel) {
        this.f226c = parcel.readString();
        this.f227d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f228e = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f229f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f230g = (Bitmap) parcel.readParcelable(classLoader);
        this.f231h = (Uri) parcel.readParcelable(classLoader);
        this.f232i = parcel.readBundle(classLoader);
        this.f233j = (Uri) parcel.readParcelable(classLoader);
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f226c = str;
        this.f227d = charSequence;
        this.f228e = charSequence2;
        this.f229f = charSequence3;
        this.f230g = bitmap;
        this.f231h = uri;
        this.f232i = bundle;
        this.f233j = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaDescriptionCompat m6137b(Object obj) {
        int i;
        String mediaId;
        CharSequence title;
        CharSequence subtitle;
        CharSequence description;
        Bitmap iconBitmap;
        Uri iconUri;
        Bundle extras;
        Uri uri;
        Bundle bundle;
        Uri uri2 = null;
        if (obj == null || (i = Build.VERSION.SDK_INT) < 21) {
            return null;
        }
        MediaDescription mediaDescription = (MediaDescription) obj;
        mediaId = mediaDescription.getMediaId();
        title = mediaDescription.getTitle();
        subtitle = mediaDescription.getSubtitle();
        description = mediaDescription.getDescription();
        iconBitmap = mediaDescription.getIconBitmap();
        iconUri = mediaDescription.getIconUri();
        extras = mediaDescription.getExtras();
        if (extras != null) {
            MediaSessionCompat.m6136a(extras);
            uri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
        } else {
            uri = null;
        }
        if (uri != null) {
            if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                bundle = null;
                if (uri == null) {
                    if (i >= 23) {
                        uri2 = mediaDescription.getMediaUri();
                    }
                    uri = uri2;
                }
                MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, uri);
                mediaDescriptionCompat.f234k = obj;
                return mediaDescriptionCompat;
            }
            extras.remove("android.support.v4.media.description.MEDIA_URI");
            extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = extras;
        if (uri == null) {
        }
        MediaDescriptionCompat mediaDescriptionCompat2 = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, uri);
        mediaDescriptionCompat2.f234k = obj;
        return mediaDescriptionCompat2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f227d) + ", " + ((Object) this.f228e) + ", " + ((Object) this.f229f);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = Build.VERSION.SDK_INT;
        Bundle bundle = this.f232i;
        Uri uri = this.f233j;
        Uri uri2 = this.f231h;
        Bitmap bitmap = this.f230g;
        CharSequence charSequence = this.f229f;
        CharSequence charSequence2 = this.f228e;
        CharSequence charSequence3 = this.f227d;
        String str = this.f226c;
        if (i2 < 21) {
            parcel.writeString(str);
            TextUtils.writeToParcel(charSequence3, parcel, i);
            TextUtils.writeToParcel(charSequence2, parcel, i);
            TextUtils.writeToParcel(charSequence, parcel, i);
            parcel.writeParcelable(bitmap, i);
            parcel.writeParcelable(uri2, i);
            parcel.writeBundle(bundle);
            parcel.writeParcelable(uri, i);
            return;
        }
        Object obj = this.f234k;
        if (obj == null && i2 >= 21) {
            MediaDescription.Builder builder = (MediaDescription.Builder) C4388z80.m115a();
            builder.setMediaId(str);
            builder.setTitle(charSequence3);
            builder.setSubtitle(charSequence2);
            builder.setDescription(charSequence);
            builder.setIconBitmap(bitmap);
            builder.setIconUri(uri2);
            if (i2 < 23 && uri != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                    bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", uri);
            }
            builder.setExtras(bundle);
            if (i2 >= 23) {
                builder.setMediaUri(uri);
            }
            obj = builder.build();
            this.f234k = obj;
        }
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }
}
