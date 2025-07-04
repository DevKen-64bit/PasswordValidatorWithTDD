package lib;

public class PasswordValidator {

    
    /**
     * ทำการตรวจสอบเกณฑ์การตั้งรหัสผ่าน
     * @param มีเกณการใส่อะไรก็ได้อย่างน้อย8ตัวและไม่มากกว่า20ตัวตัวอักษรพิเศษใส่ได้เฉพาะ!@#$%^&*
     * @return แสดงระดับความปลอดภัยของรหัสผ่าน
     * 
     */
    
    public static PasswordStrength validate(String password) { // Function Type ให้เป็น PasswordStrength 
        
        

        //กำหนดความยาวของรหัสผ่าน
        int minLength = 8; // TODO: มีอะไรขาดหายไปที่บรรทัดนี้?
        int maxLength = 20; // ไม่ให้รหัสผ่านเกิน 20 ตัว
        boolean Upper = false; // เช็คตัวพิมใหญ่
        boolean Lower = false; //เช็คตัวพิมพเล็ก
        boolean num = false; //เช็ตตัวเลข
        boolean special = false; //เช็คตัวอักษรพิเศษ
        int Level = 0; //นับประเภท
        int Passwordcount = 0; //เช็คจำนวนตัวอักษร

        //เช็คว่ารหัสผ่านมีจำนวนตามที่กำหนดไหม
        if(password.length() < minLength || password.length() > maxLength ){
            return PasswordStrength.INVALID;
        }
        for(int i = 0; i < password.length();i++){ // ตรวจสอบตัวอักษรที่ละตัว
            char p = password.charAt(i); // ตัวที่ i+1ไปเรื่อยๆ
        if(Character.isUpperCase(p)){ //เช็คว่าเป็นตัวอักษรตัวใหญ่ไหม
            Upper = true;
            Passwordcount++;
            continue;
           
        }
        if(Character.isLowerCase(p)){ //เช็คว่าเป็นตัวอักษรตัวเล็กไหม
            Lower = true;
            Passwordcount++;
            continue;
           
        }
        if(Character.isDigit(p)){ //เช็คว่าเป็นตัวเลขไหม
            num = true;
            Passwordcount++;
            continue;
            
        }
        if(p == ' '){ //เช็คว่ามีช่องว่างไหม
            return PasswordStrength.INVALID;
            
        }
        if (!Character.isLetterOrDigit(p)) { //ให้ใช้ตัวอักษรพิเศษแค่นี้
            if (p == '!' || p == '@' || p == '#' || p == '$' ||
            p == '%' || p == '^' || p == '&' || p == '*') {
            special = true;
            continue;
        } else {
        return PasswordStrength.INVALID; 
        }
        }

        }
            if (Upper) Level++;
            if (Lower) Level++;
            if (num) Level++;
            if (special) Level++;
        
        if(Level >= 4){ //ถ้าครบทุกเงื่อนไขให้ระดับ Strong
            return PasswordStrength.STRONG;
        }else if(Level >= 2 ){ //ถ้าครอบคุมอย่างน้อย 2 หรือ 3 ให้ Medium
            return PasswordStrength.MEDIUM;
        }else {
            return PasswordStrength.WEAK;
        }

        
        
     
    }
}