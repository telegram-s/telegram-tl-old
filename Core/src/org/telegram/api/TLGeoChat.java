
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLGeoChat extends TLAbsChat {
    public static final int CLASS_ID = 0x75eaea5a;

    public int getClassId() {
        return CLASS_ID;
    }


    protected long accessHash;

    protected String title;

    protected String address;

    protected String venue;

    protected org.telegram.api.TLAbsGeoPoint geo;

    protected org.telegram.api.TLAbsChatPhoto photo;

    protected int participantsCount;

    protected int date;

    protected boolean checkedIn;

    protected int version;


    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String value) {
        this.venue = value;
    }

    public org.telegram.api.TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(org.telegram.api.TLAbsGeoPoint value) {
        this.geo = value;
    }

    public org.telegram.api.TLAbsChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(org.telegram.api.TLAbsChatPhoto value) {
        this.photo = value;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int value) {
        this.participantsCount = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean value) {
        this.checkedIn = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeLong(this.accessHash, stream);
        writeTLString(this.title, stream);
        writeTLString(this.address, stream);
        writeTLString(this.venue, stream);
        writeTLObject(this.geo, stream);
        writeTLObject(this.photo, stream);
        writeInt(this.participantsCount, stream);
        writeInt(this.date, stream);
        writeTLBool(this.checkedIn, stream);
        writeInt(this.version, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.accessHash = readLong(stream);
        this.title = readTLString(stream);
        this.address = readTLString(stream);
        this.venue = readTLString(stream);
        this.geo = (org.telegram.api.TLAbsGeoPoint)readTLObject(stream, context);
        this.photo = (org.telegram.api.TLAbsChatPhoto)readTLObject(stream, context);
        this.participantsCount = readInt(stream);
        this.date = readInt(stream);
        this.checkedIn = readTLBool(stream);
        this.version = readInt(stream);
    }

}
