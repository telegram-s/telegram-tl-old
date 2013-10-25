
package org.telegram.api;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLUserFull extends TLObject {

    public static final int CLASS_ID = 0x771095da;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsUser user;

    protected org.telegram.api.contacts.TLLink link;

    protected org.telegram.api.TLAbsPhoto profilePhoto;

    protected org.telegram.api.TLAbsPeerNotifySettings notifySettings;

    protected boolean blocked;

    protected String realFirstName;

    protected String realLastName;


    public org.telegram.api.TLAbsUser getUser() {
        return user;
    }

    public void setUser(org.telegram.api.TLAbsUser value) {
        this.user = value;
    }

    public org.telegram.api.contacts.TLLink getLink() {
        return link;
    }

    public void setLink(org.telegram.api.contacts.TLLink value) {
        this.link = value;
    }

    public org.telegram.api.TLAbsPhoto getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(org.telegram.api.TLAbsPhoto value) {
        this.profilePhoto = value;
    }

    public org.telegram.api.TLAbsPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(org.telegram.api.TLAbsPeerNotifySettings value) {
        this.notifySettings = value;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean value) {
        this.blocked = value;
    }

    public String getRealFirstName() {
        return realFirstName;
    }

    public void setRealFirstName(String value) {
        this.realFirstName = value;
    }

    public String getRealLastName() {
        return realLastName;
    }

    public void setRealLastName(String value) {
        this.realLastName = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.user, stream);
        writeTLObject(this.link, stream);
        writeTLObject(this.profilePhoto, stream);
        writeTLObject(this.notifySettings, stream);
        writeTLBool(this.blocked, stream);
        writeTLString(this.realFirstName, stream);
        writeTLString(this.realLastName, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.user = (org.telegram.api.TLAbsUser)readTLObject(stream, context);
        this.link = (org.telegram.api.contacts.TLLink)readTLObject(stream, context);
        this.profilePhoto = (org.telegram.api.TLAbsPhoto)readTLObject(stream, context);
        this.notifySettings = (org.telegram.api.TLAbsPeerNotifySettings)readTLObject(stream, context);
        this.blocked = readTLBool(stream);
        this.realFirstName = readTLString(stream);
        this.realLastName = readTLString(stream);
    }

}
