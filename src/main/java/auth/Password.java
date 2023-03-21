package auth;

public class Password {
    public  String Mat_Pers;

    public String getMat_Pers() {
        return Mat_Pers;
    }

    public void setMat_Pers(String mat_Pers) {
        Mat_Pers = mat_Pers;
    }

    public String newPassword;
    public String newPassword2;
    public String  oldPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
